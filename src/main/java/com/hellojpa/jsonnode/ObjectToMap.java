package com.hellojpa.jsonnode;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class ObjectToMap {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Student student = new Student();
        student.setId(2);
        student.setName("Mini");

        Map<String, Object> map = objectMapper.convertValue(student, Map.class);
        map.put("phone", "010101");

        System.out.println("==== map ====");
        System.out.println(map);

        System.out.println("==== map.getPhone() ====");
        System.out.println(map.get("phone"));

        System.out.println("==== map.getName() ====");
        System.out.println(map.get("name"));

        System.out.println("==== map.getId() ====");
        System.out.println(map.get("id"));




    }
}
