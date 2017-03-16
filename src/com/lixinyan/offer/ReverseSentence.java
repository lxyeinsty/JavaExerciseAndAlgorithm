package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/2/14.
 *
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null) {
            return null;
        }

        if (str.trim().equals("")) return str;

        String string = str;
        String[] strings = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            if (i == 0) {
                stringBuilder.append(strings[i]);
            } else {
                stringBuilder.append(strings[i]);
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
