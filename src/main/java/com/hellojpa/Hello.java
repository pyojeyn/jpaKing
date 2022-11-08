package com.hellojpa;

import javax.persistence.*;

@Entity
public class Hello {

    // 직접 할당 : @Id만 사용
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    public Hello(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

/**
 *  GenerationType.IDENTITY 전략
 *  1. 기본 키 생성을 데이터베이스에 위임
 *  주로 MySQL, PostgreSQL, SQL server, DB2 에서 사용
 *  ex) MySQL 의 AUTO_INCREMENT
 *  2. JPA 는 보통 트랜잭션 커밋 시점에 INSERT SQL 실행
 *  3. AUTO_INCREMENT 는 데이터베이스에 INSERT SQL 을 실행한 이후에 ID값을 알 수 있음
 *  4. **IDENTITY 전략은 em.persist()시점에 즉시 INSERT SQL을 실행하고 DB에서 식별자를 조회
 */
