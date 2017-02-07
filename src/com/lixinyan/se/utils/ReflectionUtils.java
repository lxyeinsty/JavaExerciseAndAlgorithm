package com.lixinyan.se.utils;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by administrator on 2016/6/26.
 *
 */
public class ReflectionUtils {

    private static Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    private ReflectionUtils() {

    }

    /**
     * 直接读取对象属性值,无视private/protected修饰符,不经过getter函数.
     */
    public static Object getFieldValue(final Object object, final String fieldName) {
        Field field = getDeclaredField(object, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        }

        makeAccessible(field);
        Object result = null;
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常{}", e.getMessage());
        }
        return result;
    }

    /**
     * 循环向上转型,获取对象的DeclaredField.
     */
    protected static Field getDeclaredField(final Object object, final String fieldName) {
        Assert.notNull(object, "object不能为空");
            return getDeclaredField(object.getClass(), fieldName);
        }

    /**
     * 循环向上转型,获取对象的DeclaredField.
     */
    @SuppressWarnings("unchecked")
    protected static Field getDeclaredField(final Class clazz, final String fieldName) {
        Assert.notNull(clazz, "clazz不能为空");
        Assert.hasText(fieldName, "fieldName");
        for (Class superClass = clazz; superClass != null; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 强制转换field可访问.
     */
    protected static void makeAccessible(final Field field) {
        if (!Modifier.isPublic(field.getModifiers()) ||
                !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            field.setAccessible(true);
        }
    }

    /**
     * 提取集合中的对象的属性,组合成List.
     *
     * @param collection 来源集合.
     * @param propertyName 提取的属性名.
     */
    @SuppressWarnings("unchecked")
    public static List fetchElementPropertyToList(final Collection collection,
                                                  final String propertyName) throws Exception {
        List list = new ArrayList<>();
        for (Object obj : collection) {
            list.add(PropertyUtils.getProperty(obj, propertyName));
        }
        return list;
    }
}
