package com.hellojpa.jsonnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// JsonNode -> Java Object
public class JsonNodeToObject {
    public static void main(String[] args) throws Exception{
        String jsonStr = "{\"id\":1,\"name\":\"Anna\"}";

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(jsonStr);

        Student student = objectMapper.treeToValue(jsonNode, Student.class);

        System.out.println("JsonNode To Java Object");
        System.out.println(student); //Student[id=1,name=Anna]
    }
}
