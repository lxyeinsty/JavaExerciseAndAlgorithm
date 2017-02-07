package com.lixinyan.proxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/11/3
 *
 */
public class Test {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^(http|https)://(.*)\\.(com|org)");
        Matcher matcher = pattern.matcher("https://zhuanlan.zhihu.com/p/22426678?refer=fuwangezy");
        System.out.print(matcher.find());
        System.out.print(matcher.group(0));
    }
}
