package com.lixinyan.se.utils;

import java.util.UUID;

/**
 * Created by administrator on 2016/6/25.
 *
 */
public class UUIDValueGenerator {

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    public static String generateValue(String param) {
        return UUID.fromString(UUID.nameUUIDFromBytes(param.getBytes()).toString()).toString();
    }
}
