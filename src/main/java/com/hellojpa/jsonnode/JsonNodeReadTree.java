package com.hellojpa.jsonnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNodeReadTree {
    public static void main(String[] args) throws Exception{
        /*JsonStringToJsonNode*/

        // JSON 문자열
        String jsonStr =  "{\"id\":1,\"name\":\"Anna\"}";

        // jackson objectMapper 객체 생성
        ObjectMapper objectMapper = new ObjectMapper();

        // JsonNode 생성(readTree, readValue)
        JsonNode jsonNode1 = objectMapper.readTree(jsonStr);
        JsonNode jsonNode2 = objectMapper.readValue(jsonStr, JsonNode.class);

        System.out.println(jsonNode1);
        System.out.println(jsonNode2);

    }
}
