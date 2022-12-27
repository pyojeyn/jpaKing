package com.hellojpa.jsonnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonNodeCheckNullValueMain {
    public static void main(String[] args) throws Exception{
        // 특정 field 의 값이 null 인 경우.
        // 'lecture.json' 파일에서, 'textbook' 필드의 값은 null 임
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(new File("C:\\jennyboo\\json\\lecture.json"));

        // 특정 field 의 값이 null 인 경우
        checkNullValue(jsonNode);

        // 특정 field 가 아예 없는 경우 - path()
        checkMissingNodeWithPath(jsonNode);

        // 특정 field 가 아예 없는 경우 - get()
        checkMissingNodeWithGet(jsonNode);
    }

    public static void checkNullValue(JsonNode jsonNode){
        JsonNode textbookNode = jsonNode.path("textbook");
        System.out.println("----- 특정 field 의 값이 null 인 경우 -----");
        System.out.println(textbookNode); // null
        System.out.println(textbookNode.isNull()); // true
        // isNull 의 결과가 true 인걸 비교할때는 필드 : null 이라고 되어있어야함.
        // 없는거 가지고 비교하면 아마도  NullPointException 날듯;; 찾아냄.  path 로 하면 다 나오는데 get으로 하면 싸그리 다 NullPointException
    }

    public static void checkMissingNodeWithPath(JsonNode jsonNode){
        JsonNode classRoomNode = jsonNode.path("classroom");

        System.out.println("----- 특정 field가 없는 경우 path() 사용 -----");
        System.out.println(classRoomNode); //    => 공백. 아예 뜨지도 않음.
        System.out.println(classRoomNode.getClass()); //class com.fasterxml.jackson.databind.node.MissingNode
        System.out.println(classRoomNode.isMissingNode()); // true
        System.out.println(classRoomNode.isNull()); // false => 필드 자체가 없는것이지 필드의 값이 null 이 아니니까 false 나오는듯;
        System.out.println(classRoomNode.equals("")); //false
    }

    public static void checkMissingNodeWithGet(JsonNode jsonNode){
        System.out.println("----- 특정 field 가 없는 경우 get() 사용 -----");
        JsonNode classRoomNode = jsonNode.get("classroom");
        System.out.println(classRoomNode); // null
        // 그냥 다 널포인트 Exception
        // System.out.println(classRoomNode.getClass()); // NullPointerException
        // System.out.println(classRoomNode.isMissingNode()); // NullPointerException
        // System.out.println(classRoomNode.isNull()); // NullPointerException
        // System.out.println(classRoomNode.equals("")); // NullPointerException


    }
}
