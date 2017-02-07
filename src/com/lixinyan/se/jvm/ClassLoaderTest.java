package com.lixinyan.se.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by administrator on 2016/6/19.
 *
 */
public class ClassLoaderTest {

    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = this.getClass().getResourceAsStream(filename);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return this.defineClass(filename, bytes, 0, bytes.length);
                } catch (IOException ex) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object object = classLoader.loadClass("com.lixinyan.se.jvm.ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof com.lixinyan.se.jvm.ClassLoaderTest);
    }
}
