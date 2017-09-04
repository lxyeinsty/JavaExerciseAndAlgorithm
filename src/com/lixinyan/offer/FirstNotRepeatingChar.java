package com.lixinyan.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxy on 2017/9/4.
 *
 */
public class FirstNotRepeatingChar {

    public int firstNotRepeatingChar(String str) {
        if(str == null || str.length()==0) return -1;
        List<Character> list = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!list.contains(ch)){
                list.add(Character.valueOf(ch));
            }else{
                list.remove(Character.valueOf(ch));
            }
        }
        if(list.size() <=0) return -1;
        return str.indexOf(list.get(0));
    }
}
