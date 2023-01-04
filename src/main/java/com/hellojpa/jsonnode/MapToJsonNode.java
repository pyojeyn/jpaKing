package com.hellojpa.jsonnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

// Map 을 Jackson 의 JsonNode 로 변환하기
// Object를 JsonNode로 바꿀때와 같이 valueToTree(), convertValue() 사용
public class MapToJsonNode {
    public static void main(String[] args) {

        // Map 생성
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "sunny");

        // jackson objectmapper 객체 생성
        ObjectMapper objectMapper = new ObjectMapper();

        // Map -> JsonNode
        JsonNode jsonNode1 = objectMapper.valueToTree(map);
        JsonNode jsonNode2 = objectMapper.convertValue(map, JsonNode.class);

        //jsonNode 출력
        System.out.println(jsonNode1);
        System.out.println(jsonNode2);



    }
}
