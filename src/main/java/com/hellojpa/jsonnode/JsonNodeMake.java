package com.hellojpa.jsonnode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JsonNodeMake {
    public static void main(String[] args) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        addPrimitiveType(mapper);

        addNewNode(mapper);
        // JsonNode 는 Immutable 임 따라서 , JsonNode 를 수정하기 위해서는 JsonNode 대신 ObjectNode 객체를 사용합니다.
        // 추가, 수정 할수 있는 객체를 생성하기 위해 기존의 JsonNode 객체는 ObjectNode 객체로 타입 캐스팅하고,
        // 새로운 객체는 createObjectNode() 메소드를 사용하여 ObjectNode 객체를 생성.
    }

    private static void addPrimitiveType(ObjectMapper mapper) throws IOException {
        ObjectNode lectureNode = (ObjectNode) mapper.readTree(new File("C:\\jennyboo\\json\\lecture.json"));

        // primitive type 추가
        lectureNode.put("classroom", 101);

        System.out.println("----- classroom 노드 추가 -----");
        System.out.println(lectureNode);
        /*
        * {
        *   "id":1,
        *   "title":"Java",
        *   "professor":{"id":"P1","name":"Kim"},
        *   "students":[{"id":"S1","name":"표제인"},{"id":"S2","name":"이훈훈"}],
        *   "textbook":null,
        *   "classroom":101
        * }
        * */
    }

    public static void addNewNode(ObjectMapper mapper) throws IOException {
        // lecture JSON 읽기
        ObjectNode lectureNode = (ObjectNode) mapper.readTree(new File("C:\\jennyboo\\json\\lecture.json"));

        // ObjectNode 생성
        ObjectNode contact = mapper.createObjectNode();
        contact.put("tel", "010-1111-1111");
        contact.put("email", "aa@mail.com");

        lectureNode.set("concat", contact);
        // 결과출력
        System.out.println("----- contact 노드 추가 -----");
        System.out.println(lectureNode);
        /*
            {
                "id":1,
                "title":"Java",
                "professor":{"id":"P1","name":"Kim"},
                "students":[{"id":"S1","name":"표제인"},{"id":"S2","name":"이훈훈"}],
                "textbook":null,
                "concat":{"tel":"010-1111-1111","email":"aa@mail.com"}}
         */
    }


}
