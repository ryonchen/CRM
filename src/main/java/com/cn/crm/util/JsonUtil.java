package com.cn.crm.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * json处理工具类
 *
 *
 */
/**
 * json处理工具类
 *
 *
 */
@Component
public class JsonUtil {

    private static final ObjectMapper mapper;

    public ObjectMapper getMapper() {
        return mapper;
    }

    static {

        mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addSerializer(LocalTime.class, new LocalTimeSerializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        mapper.registerModule(module);
    }

    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("转换json字符失败!");
        }
    }

    public <T> T toObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException("将json字符转换为对象时失败!");
        }
    }
}

class LocalDateSerializer extends JsonSerializer<LocalDate> {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeString(dateFormatter.format(value));
    }
}

class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeString(dateTimeFormatter.format(value));
    }

}

class LocalTimeSerializer extends JsonSerializer<LocalTime> {

    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void serialize(LocalTime value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeString(timeFormatter.format(value));

    }

}