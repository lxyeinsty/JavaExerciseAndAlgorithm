package com.lixinyan.thirdlib.BDSpeech.src.STT;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

import org.json.JSONObject;

public class SpeechRecognition {

    private  final String serverURL = "http://vop.baidu.com/server_api";
    private  String token = "";
    private  int rate = 16000 ; //设置好对应的频率 不然会出错
    private  String result = "";
    private  String FileURL = "";  //这里的是绝对路径
    private	 boolean isDetailed = false;
    //put your own params here
    
    private  String apiKey = "";
    private  String secretKey = "";
    private  String cuid = "";
    public SpeechRecognition(String cuid){
    	this.cuid = cuid;
    	checkLocalToken();
    }
    public SpeechRecognition(String apiKey , String secretKey , String cuid){
    	this.apiKey = apiKey;
    	this.secretKey = secretKey;
    	this.cuid = cuid;
    	
    checkLocalToken();
    }
  
		private void checkLocalToken() {
	// TODO Auto-generated method stub
			File tokenFile = new File("STT_token.dat");
	    	if(tokenFile.exists()){
	    		try {
					token = new Scanner(tokenFile).nextLine();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	else{
	    	 	try {
	    			getToken();
	    			PrintWriter output = new PrintWriter(tokenFile);
	    			output.print(token);
	    			output.close();
	    		} catch (Exception e) {
	    			// TODO Auto-generated catch block
	    			System.out.println("获取认证失败,请检查apiKey,secreKey,cuid位置或者内容是否设置正确");
	    			System.exit(1);
	    		}
	    	}
}

	//与验证服务器验证  获取token
    public  void getToken() throws Exception {
        String getTokenURL = "https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials" + 
            "&client_id=" + apiKey + "&client_secret=" + secretKey;
        HttpURLConnection conn = (HttpURLConnection) new URL(getTokenURL).openConnection();   //与验证服务器连接
        			
        token = new JSONObject(printResponse(conn)).getString("access_token");//获取access_token:...后的token
    }
    		//利用获得的token与语音服务器连接
    public  String methodByPOST() throws Exception {
    			if(FileURL.isEmpty()){
    				System.err.println("请设置识别语音所在位置");
    				System.exit(1);
    				
    			}
        File pcmFile = new File(FileURL);
        HttpURLConnection conn = (HttpURLConnection) new URL(serverURL).openConnection();  //与语音服务器建立连接

        // construct params  
        JSONObject params = new JSONObject();
        params.put("format", "pcm");
        params.put("rate", rate);
        params.put("channel", "1");
        params.put("token", token);
        params.put("cuid", cuid);
        params.put("len", pcmFile.length());
        params.put("speech", DatatypeConverter.printBase64Binary(loadFile(pcmFile)));

        // add request header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        conn.setDoInput(true);
        conn.setDoOutput(true);

        // send request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(params.toString());
        wr.flush();
        wr.close();
        
        result = getResult(printResponse(conn));
       
       return result;
    }
    		//与方法一的区别在于没有设置params
    public  String methodByGET(String newFileURL) throws Exception {  
    			
    			setFileURL(newFileURL);
    			 	
        File pcmFile = new File(FileURL);
        HttpURLConnection conn = (HttpURLConnection) new URL(serverURL
                + "?cuid=" + cuid + "&token=" + token).openConnection();

        // add request header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "audio/pcm; rate=" + rate);

        conn.setDoInput(true);
        conn.setDoOutput(true);

        // send request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.write(loadFile(pcmFile));  //loadFile()把
        wr.flush();
        wr.close();
        
        result = getResult(printResponse(conn));
        
        return result;
    }

    private  String printResponse(HttpURLConnection conn) throws Exception {
        if (conn.getResponseCode() != 200) {
            // request error
        	System.err.println("请求失败,请检查网络");
            return "";
        }
        InputStream is = conn.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        if(isDetailed){
        			System.out.println( new JSONObject(response.toString()).toString(4));
        			}
        return response.toString();
    }
    		//把语音文件转换成byte数组存储
    private  byte[] loadFile(File file) throws IOException {

        InputStream is = new FileInputStream(file);

        long length = file.length();
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            is.close();
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
    }
    	//从返回的数据块中分离出最终的翻译结果
    private  String getResult(String returnResult){
    	
    		String startMark = "\"result\":[\"",endMark = "\"],\"sn\":"; //通过数据的字符串标记找到这两个标记之间的 结果字符串
    		
    		int startIndex,endIndex; 
    		
    		startIndex = returnResult.indexOf(startMark) + startMark.length() ;  //因为indexOf()得到的是子字符串开始的位置所以加个长度取到 起始标记字符的尾部下标
    		endIndex = returnResult.indexOf(endMark,startIndex);
    		
    		try{
    		returnResult = returnResult.substring(startIndex, endIndex);
    		}catch(Exception e){
    			
    			if(returnResult.contains("recognition error"))
    						System.err.println("识别失败");
    			else
    						System.err.println("结果解析时,下标越界或异常");
    			return "!";
    		}
    		
    	return returnResult;
    }
      //设置音频文件的配置信息
    public  void setFileConfigure(String newFileURL , int newRate ){
    	FileURL = newFileURL;
    	rate = newRate;
    }
    public  void setFileURL(String newFileURL ){
    	FileURL = newFileURL;
    }
    public 	void setIsDetailed(boolean isDetailed){
    	this.isDetailed = isDetailed;
    }
    public void setToken(String token){
    	this.token = token;
    }

}
