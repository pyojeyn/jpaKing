package com.hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn // DType 생김 NAME 설정 가능
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;
}
