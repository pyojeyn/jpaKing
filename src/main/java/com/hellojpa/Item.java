package com.hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 구현 클래스마다 테이블 전략 : 쓰면 안되는 전략임.
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;
}
// 구현 클래스마다 테이블 전략은 조회 할때 비효율 적임. 왜냐묜 한번 조회 할때 union 으로 자식테이블 다 뒤져야함.
/**
 * select
 *         item0_.id as id1_3_0_,
 *         item0_.name as name2_3_0_,
 *         item0_.price as price3_3_0_,
 *         item0_.artist as artist1_0_0_,
 *         item0_.actor as actor1_7_0_,
 *         item0_.director as director2_7_0_,
 *         item0_.author as author1_1_0_,
 *         item0_.isbn as isbn2_1_0_,
 *         item0_.clazz_ as clazz_0_
 *     from
 *         ( select
 *             id,
 *             name,
 *             price,
 *             artist,
 *             null as actor,
 *             null as director,
 *             null as author,
 *             null as isbn,
 *             1 as clazz_
 *         from
 *             Album
 *         union
 *         select
 *             id,
 *             name,
 *             price,
 *             null as artist,
 *             actor,
 *             director,
 *             null as author,
 *             null as isbn,
 *             2 as clazz_
 *         from
 *             Movie
 *         union
 *         select
 *             id,
 *             name,
 *             price,
 *             null as artist,
 *             null as actor,
 *             null as director,
 *             author,
 *             isbn,
 *             3 as clazz_
 *         from
 *             Book
 *     ) item0_
 */