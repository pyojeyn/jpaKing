package com.hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
public enum RoleType {
    LEADER("리더"), SUBLEADER("부리더"), MIDDLE("미들"), ROOKEY("루키");

    private String label;

    public static RoleType from(String val){
        for(RoleType type : RoleType.values()){
            if(type.getLabel().equals(val)){
                System.out.println("type이 대체 뭔데 ㅡㅡ== " + type);
                return type;
            }
        }
        return null;
    }

    // 이 생성자는 저 괄호안에 label String을 뽑아내기 위해 있는 듯 싶다.
    RoleType(String label){
        System.out.println("=================");
        System.out.println("언제 되는겨 ?");
        System.out.println("=================");
        this.label = label;
    }


    // 내가 깨달은거 enum 열거 옆에 괄호 열고 뭐 넣어주고 싶으면 생성자 무조건 있어줘야하는듯.
    // @RequiredArgsConstructor : 생성자 주입
}
