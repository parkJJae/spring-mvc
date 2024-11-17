package com.sparta.springmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springmvc.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 자바의 객체를 Json 형태로
public class JacksonTest {

    @Test
    @DisplayName("Object To JSON : get Method 필요") // Star 클래스의 @Getter
    void test1() throws JsonProcessingException {
        Star star = new Star("Robbie", 95);

        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper
        String json = objectMapper.writeValueAsString(star);
        // star 객체를 읽은 후 String type의 json으로 반환 가능
        System.out.println("json = " + json);
    }

    @Test
    @DisplayName("JSON To Object : 기본 생성자 & (get OR set) Method 필요")
    void test2() throws JsonProcessingException {
        String json = "{\"name\":\"Robbie\",\"age\":95}"; // JSON 타입의 String

        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper

        Star star = objectMapper.readValue(json, Star.class);
        System.out.println("star.getName() = " + star.getName());
    }

}
