package com.hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Product {

    @Id @GeneratedValue
    private String id;

    private String name;

//    @ManyToMany(mappedBy = "products")
//    private List<Member> members = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<MemberProduct> memberProducts = new ArrayList<>();


    /*
    * [다대다 매핑의 한계]
    * 1. 편리해 보이지만 실무에서 사용 X
    * 2. 연결 테이블이 단순히 연결만 하고 끝나지 않음
    * 3. 주문시간, 수량같은 데이터가 들어올 수 있음.
    *
    * [다대다 한계 극복]
    * 1. 연결 테이블용 엔티티 추가 (연결 테이블을 엔티티로 승격)
    * 2. @ManyToMany -> @OneToMany, @ManyToOne
    * */


}
