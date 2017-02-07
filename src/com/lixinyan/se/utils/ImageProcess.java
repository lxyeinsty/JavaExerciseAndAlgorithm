package com.lixinyan.se.utils;

import com.lixinyan.se.encrypt.MD5;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by administrator on 2016/6/24.
 *
 */
public class ImageProcess {
    private Image image;
    private int width;
    private int height;
    private String imageFormat;

    public ImageProcess(InputStream inputStream, String filename) throws Exception {
        image = ImageIO.read(inputStream);
        width = image.getWidth(null);
        height = image.getHeight(null);
        imageFormat = filename.substring(filename.lastIndexOf(".") + 1);
    }

    /**
     * 按照宽度还是高度进行压缩
     * @param w int 最大宽度
     * @param h int 最大高度
     */
    public byte[] resizeFix(int w, int h) throws IOException {
        if (width / height > w / h) {
            return resizeByWidth(w);
        } else {
            return resizeByHeight(h);
        }
    }

    /**
     * 以宽度为基准，等比例放缩图片
     * @param w int 新宽度
     */
    public byte[] resizeByWidth(int w) throws IOException {
        int h = (int) (height * w / width);
        return resize(w, h);
    }

    /**
     * 以高度为基准，等比例缩放图片
     * @param h int 新高度
     */
    public byte[] resizeByHeight(int h) throws IOException {
        int w = (int) (width * h / height);
        return resize(w, h);
    }

    /**
     * 强制压缩/放大图片到固定的大小
     * @param w int 新宽度
     * @param h int 新高度
     */
    public byte[] resize(int w, int h) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, w, h, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, imageFormat, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void byteToImage(byte[] bytes) throws Exception {
        String baseDir = "E:\\图片\\";
        String filename = baseDir + MD5.getMD5(new Long(System.currentTimeMillis()).toString())
                + "." + imageFormat;
        FileOutputStream outputStream = new FileOutputStream(new File(filename));
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();
    }
}
