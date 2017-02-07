package com.lixinyan.thirdlib.BDSpeech.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

import STT.SpeechRecognition;
import TTS.SpeechSynthesis;
public class Speech {
	 //没有getToken 或者参数 缺少 就会出现 44KB的错误
		/*
		 * @param args
		 */
	
  static	String TTSToken = "24.5b615490afd43d2ed98a7e4dc5c27308.2592000.1468589938.282335-8053385";
	static String STTToken = "24.c05313fcc9ff4378e5674d169540eb2b.2592000.1468589938.282335-6355687";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		creatLocalTokenFile();
		
		SpeechSynthesis TTS = new SpeechSynthesis("8053385");
		//TTS.setToken(TTSToken);
		SpeechRecognition STT = new SpeechRecognition("6355687");
		//STT.setToken(STTToken);
		
		if(args.length == 0){
			showHelp();
			System.exit(1);
		}else{
			if(args[0].contains("/root/")||args[0].contains(":\\")){
				STT.setFileURL(args[0]);
				try {
					System.out.println(STT.methodByPOST());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				TTS.setSaveURL("test.mp3");
				TTS.setText(args[0]);
				try {
					TTS.methodByGET();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
				
		
	

	public static void creatLocalTokenFile(){
		File TTStoken = new File("TTS_token.dat");
		File STTtoken = new File("STT_token.dat");
		try {
			PrintWriter writeTTS = new PrintWriter(TTStoken);
			PrintWriter writeSTT = new PrintWriter(STTtoken);
			
			writeTTS.print("24.5b615490afd43d2ed98a7e4dc5c27308.2592000.1468589938.282335-8053385");
			writeSTT.print("24.c05313fcc9ff4378e5674d169540eb2b.2592000.1468589938.282335-6355687");
			
			writeTTS.close();
			writeSTT.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void showHelp(){
		System.out.println("百度语音识别与合成\n"
												+"TTS :\n\t-t 设置需要合成的文本\n"
												+"STT:\n\t-path 设置合成路径\n"
												+"如:\n\tTest 你说什么 \n"
												+"\tTest C:\\root\\1.mp3 ");
	}

}
