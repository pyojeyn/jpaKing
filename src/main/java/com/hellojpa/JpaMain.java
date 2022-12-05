package com.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // **엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //  <persistence-unit name="hello">

        // **엔티티 매니저는 쓰레드간에 공유 x 사용하고 버려야함
        EntityManager em = emf.createEntityManager();

        /* jpa 는 트랜젝션 중요함. 트랜젝션 안에서만 놀아야함. */
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("jane");
            member.setCreatedBy("pyo");
            member.setCreatedDate(LocalDateTime.now());

            //저장
//            Team team = new Team();
//            team.setName("어때");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("킹키");
////            member.setRoleType(RoleType.LEADER);
//            member.setRoleType(RoleType.from("부리더"));
//
//            System.out.println("라벨은 단지 조회용이었음??");
//            System.out.println("member.getRoleType().getLabel() ==> " +  member.getRoleType().getLabel());
//            //member.getRoleType().getLabel() ==> 부리더
//            member.setTeam(team);
//
            em.persist(member);

            em.flush();
            em.clear();
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
