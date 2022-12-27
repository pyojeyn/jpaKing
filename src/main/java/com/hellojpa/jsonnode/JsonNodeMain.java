package com.hellojpa.jsonnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.extern.slf4j.Slf4j;


import java.io.File;


public class JsonNodeMain {
    public static void main(String[] args) throws Exception {
        // ObjectMapper 생성.
        ObjectMapper mapper = new ObjectMapper();

        // JsonNode 생성
        JsonNode jsonNode = mapper.createObjectNode();

        // ArrayNode 생성
        ArrayNode arrayNode = mapper.createArrayNode();

        // Field 읽기 , get(), path(), at()
        JsonNode jsonNodeReadTreeForField = mapper.readTree(new File("C:\\jennyboo\\json\\lecture.json"));
        System.out.println("jsonNodeReadTreeForField!!");
        System.out.println(jsonNodeReadTreeForField);

//        readJsonNodeWithGet(jsonNodeReadTreeForField);
//        readJsonNodeWithPath(jsonNodeReadTreeForField);
//        readJsonNodeWithAt(jsonNodeReadTreeForField);


        // get() vs path() => 찾는 필드가 없는 경우에 서로 다른 값을 리턴
        missingJsonNodeWithGet(jsonNodeReadTreeForField); // null
        missingJsonNodeWithPath(jsonNodeReadTreeForField);

    }

    private static void missingJsonNodeWithPath(JsonNode jsonNode) {
        JsonNode classRoomNode = jsonNode.path("classRoom");

        System.out.println("----- path() -----");
        System.out.println(classRoomNode);
        System.out.println(classRoomNode.getClass()); // class com.fasterxml.jackson.databind.node.MissingNode

        // check missing node
        if (classRoomNode.isMissingNode()) {
            System.out.println("노드를 찾을 수 없습니다.");
        }
    }

    public static void missingJsonNodeWithGet(JsonNode jsonNode){
        JsonNode classRoomNode = jsonNode.get("classRoom");
        System.out.println("===============missingJsonNodeWithGet====================");
        System.out.println(classRoomNode);
    }

    public static void readJsonNodeWithGet(JsonNode jsonNode){
        int lectureId = jsonNode.get("id").asInt();
        String lectureName = jsonNode.get("title").asText();
        String professorName = jsonNode.get("professor").get("name").asText();
        String studentName1 = jsonNode.get("students").get(0).get("name").asText();
        String studentName2 = jsonNode.get("students").get(1).get("name").asText();
        System.out.println("[GET]");
        System.out.println(lectureId);
        System.out.println(lectureName);
        System.out.println(professorName);
        System.out.println(studentName1);
        System.out.println(studentName2);
    }

    public static void readJsonNodeWithPath(JsonNode jsonNode){
        int lectureId = jsonNode.path("id").asInt();
        String lectureName = jsonNode.path("title").asText();
        String professorName = jsonNode.path("professor").path("name").asText();
        String studentName1 = jsonNode.path("students").path(0).path("name").asText();
        String studentName2 = jsonNode.path("students").path(1).path("name").asText();

        System.out.println("----- path() -----");
        System.out.println(lectureId); // 1
        System.out.println(lectureName); // Java
        System.out.println(professorName); // Kim
        System.out.println(studentName1); // Anna
        System.out.println(studentName2); // Brian
    }

    public static void readJsonNodeWithAt(JsonNode jsonNode){
        int lectureId = jsonNode.at("/id").asInt();
        String lectureName = jsonNode.at("/title").asText();
        String professorName = jsonNode.at("/professor/name").asText();
        String studentName1 = jsonNode.at("/students/0/name").asText();
        String studentName2 = jsonNode.at("/students/1/name").asText();

        System.out.println("----- at() -----");
        System.out.println(lectureId); // 1
        System.out.println(lectureName); // Java
        System.out.println(professorName); // Kim
        System.out.println(studentName1); // Anna
        System.out.println(studentName2); // Brian
    }
}
