package com.hellojpa.jsonnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/* Java Object 를 JsonNode 로 변환하기 */
// 1. valueToTree()
// 2. convertValue()
public class ObjectToJsonNode {

    public static void main(String[] args) {
        // Student 객체 생성
        Student student = new Student(1, "minsu");

        // jackson objectMapper 객체 생성
        ObjectMapper objectMapper = new ObjectMapper();

        // Object -> JsonNode 생성
        JsonNode jsonNode1 = objectMapper.valueToTree(student);
        JsonNode jsonNode2 = objectMapper.convertValue(student, JsonNode.class);


        // 결과 출력
        System.out.println(jsonNode1); //{"id":1,"name":"minsu"}
        System.out.println(jsonNode2); //{"id":1,"name":"minsu"}
    }



}
