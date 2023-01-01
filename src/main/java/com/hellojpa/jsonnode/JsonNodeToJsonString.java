package com.hellojpa.jsonnode;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// JsonNode -> JSON 문자열
public class JsonNodeToJsonString {
    public static void main(String[] args) throws Exception{

        String jsonStr = "{\"id\":1,\"name\":\"tissue\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonStr);

        String jsonString = jsonNode.toString();
        String prettyJsonString = jsonNode.toPrettyString();
        String writeValueString = objectMapper.writeValueAsString(jsonNode);

        // 결과 출력
        System.out.println(jsonString); //{"id":1,"name":"tissue"}
        System.out.println("=============================");
        System.out.println(prettyJsonString);
        System.out.println("=============================");
        System.out.println(writeValueString);
        /*
        * {
              "id" : 1,
              "name" : "tissue"
           }
        * */



    }
}
