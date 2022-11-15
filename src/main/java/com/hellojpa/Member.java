package com.hellojpa;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    // MEMBER 입장 MANY 한 MEMBER 가 각각 한(ONE) 팀에!!
    @ManyToOne
    @JoinColumn(name = "TEAM_ID") //team 의 어떤 컬럼으로 관계 맺을거임?
    private Team team;

    // 일대일 관계
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    // 다대다 관계
//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "e_role_type", nullable = false,
            columnDefinition = "VARCHAR(32) COMMENT '등급 이름'")
    private RoleType roleType;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    public void setRoleType(RoleType roleType){
        this.roleType = roleType;
    }

    public RoleType getRoleType() {
        return roleType;
    }


}
