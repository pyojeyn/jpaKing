package com.hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    // jpa 한테 PK가 누군지는 최소한 알려줘야함.
    @Id
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;

    private Integer age;

    // db에는 enum이 없음.
    // 그래서 enum 매핑 할때는 @Enumerated 달아줘야함.
    // 기본이 ORDINAL 임. (나열 순서 숫자를 저장 -0부터 시작)
    // ** 주의!! 왠만하면 그냥 STRING 타입 지정하자.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP) // DATE, TIME , TIMESTAMP 이렇게 세가지 있다.
    private Date lastModifiedDate;

    /* 최신 버전 */
    private LocalDate testLocalDate; // 년월만. testLocalDate date,
    private LocalDateTime testLocalDateTime; //년원일 다 포함. testLocalDateTime datetime(6),

    // 좀 긴 문장 쓸때?
    // 지정할 수 있는 속성이 없다.
    @Lob
    private String description; //description longtext,

    // db랑 매핑 안하고 싶을떄떄
    @Transient
    private int temp;

    public Member(){

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
