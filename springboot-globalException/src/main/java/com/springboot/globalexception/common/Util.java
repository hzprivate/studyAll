package com.springboot.globalexception.common;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.springboot.globalexception.excep.MyException;
import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.util.*;

public class Util {
    public static LogOut logOut;

    public static String Object2String(Object t) {
        if (t == null) {
            return "";
        }
        if ("null".equalsIgnoreCase(String.valueOf(t))) {
            return "";
        }
        return String.valueOf(t);
    }

    public static String objToJson(Object o) {
        ObjectMapper jsckson = new ObjectMapper();
        String ret = "";
        try {
            // 变量为null -> ""
            jsckson.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
                @Override
                public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
                    arg1.writeString("");
                }
            });
            ret = jsckson.writeValueAsString(o);
        } catch (Exception e1) {

        }
        return ret;
    }

    public static String mapToJson(Map map) {
        ObjectMapper jsckson = new ObjectMapper();
        String ret = "";
        try {
            ret = jsckson.writeValueAsString(map);
        } catch (Exception e1) {

        }
        return ret;
    }


    public static <T> T jsonToObj(String jsonString, Class<T> clazz) {
        if (StringUtils.isBlank(jsonString)) {
            throw new MyException("解析报文失败，未传Json");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        //忽略与实体类中不一样的字段
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            throw new MyException("解析报文失败", e);
        }
    }

    public static Map jsonToMap(String str) {
        ObjectMapper jsckson = new ObjectMapper();
        Map map = new HashMap();
        try {
            map = jsckson.readValue(str, Map.class);
        } catch (Exception e1) {

        }
        return map;
    }


    public static <T> List<T> json2List(String json, Class<T> tClass) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, tClass);
        try {
            return mapper.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}