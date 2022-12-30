package com.hellojpa.jsonnode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Arrays;

public class JsonNodeAddArrayNode {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        arrayNodeForJsonNode(mapper);

        arrayNodeForPrimitiveType(mapper);
    }

    private static void arrayNodeForPrimitiveType(ObjectMapper mapper){
        ObjectNode objectNode = mapper.createObjectNode();
        // ArrayNode 생성
        ArrayNode arr = mapper.createArrayNode();

        // ArrayNode 에 primitive type element 추가
        arr.add("a");
        arr.add("b");
        arr.add("c");

        // ObjectNode 에 ArrayNode 추가
        objectNode.set("alphabet", arr);

        // 결과 출력
        System.out.println("----- ArrayNode(Primitive Type) -----");
        System.out.println(objectNode);
    }

    private static void arrayNodeForJsonNode(ObjectMapper mapper){
        ObjectNode objectNode = mapper.createObjectNode();

        // Array 에 들어갈 Elements 생성
        ObjectNode element1 = mapper.createObjectNode();
        element1.put("id", 1);
        element1.put("name", "Harry");

        ObjectNode element2 = mapper.createObjectNode();
        element2.put("id", 2);
        element2.put("name", "Merry");

        ObjectNode element3 = mapper.createObjectNode();
        element3.put("id", 3);
        element3.put("name", "MinJee");

        // ArrayNode 생성
        ArrayNode students = mapper.createArrayNode();
        students.add(element1);
        students.addAll(Arrays.asList(element2, element3));

        // ObjectNode 에 ArrayNode 추가
        objectNode.set("students", students);

        // 결과 출력
        System.out.println("----- ArrayNode(JsonNode) -----");
        System.out.println(objectNode);


    }
}
