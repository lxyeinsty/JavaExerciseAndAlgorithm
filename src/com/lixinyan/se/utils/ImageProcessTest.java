package com.lixinyan.se.utils;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by administrator on 2016/6/24.
 *
 */
public class ImageProcessTest {

    @Test
    public void test1() throws Exception {
        InputStream inputStream = new FileInputStream(new File("E:\\图片\\QQ图片20160624172711.jpg"));
        String filename = "E:\\图片\\QQ图片20160624172711.jpg";
        ImageProcess imageProcess = new ImageProcess(inputStream, filename);
        imageProcess.byteToImage(imageProcess.resize(432, 576));
    }

    @Test
    public void test2() {
        System.out.println(UUIDValueGenerator.generateValue());
    }

    @Test
    public void test3() {
        Date date = new Date();
        Date date1 = DateUtil.rollDay(date, -20);
        Date date2 = DateUtil.rollMonth(date, -3);
        System.out.println(DateUtil.format(date1));
        System.out.println(DateUtil.format(date2));
        System.out.println(DateUtil.getTimeOffsetDesc(date1));
        System.out.println(DateUtil.getTimeOffsetDesc(date2));
        System.out.println(DateUtil.getNextMonthStartTime());
        System.out.println(DateUtil.getNextMonthEndTime());
        System.out.println(DateUtil.getPrevWorkday());
        System.out.println(DateUtil.getNextWorkday());
        System.out.println(DateUtil.getQuarterStartTime());
        System.out.println(DateUtil.getQuarterEndTime());
        System.out.println(DateUtil.getFirstWorkday());
        System.out.println(DateUtil.getLastWorkday());
        System.out.println(DateUtil.getWeekdayDesc(null));
    }
}
