package com.hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Locker {
    /**
     * 1.다대일 양방향 매핑 처럼 외래 키가 있는 곳이 연관관계의 주인
     * 2. 반대편은 mappedBy
     */

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // 양방향 읽기 전용.
    @OneToOne(mappedBy = "locker")
    private Member member;
}
