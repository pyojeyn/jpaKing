package com.hellojpa.jsonnode;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReadValue {
    public static void main(String[] args) throws Exception{
        // readTree() 메소드는 Json 문자열을 받아서 JsonNode 객체 리턴
        // readValue() 메소드는 2번째 파라미터로 Json 문자열 을 변환할 클래스 타입 입력 => 따라서 이 메소드를 사용하면, Json 문자열을 JsonNode 뿐만 아니라 다른 객체 타입으로도 변환 가능


        String jsonStr = "{\"id\": 1, \"name\" : \"JANE\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // ObjectMapper 설정 - 없는 필드 무시 설정!

        Student student = objectMapper.readValue(jsonStr, Student.class);

        System.out.println(student);
        System.out.println("student.id: " + student.getId());
        System.out.println("student.name: " + student.getName());

    }
}
