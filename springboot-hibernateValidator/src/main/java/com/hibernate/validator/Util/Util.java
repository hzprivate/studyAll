package com.hibernate.validator.Util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author hz
 * @create 2020-04-28
 */
public class Util {
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
}
