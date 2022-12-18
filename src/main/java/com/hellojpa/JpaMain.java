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

            // 영속성 깔끔
            System.out.println("안녕!!");
            // 아 이 밑에 부터 쿼리 안날라간거 멤버 프로덕트 때문이었음;;
            Member member = new Member();
            member.setUsername("hello");

            em.persist(member);
            em.flush();
            em.clear();


//            Member findMember = em.find(Member.class, member.getId());
            Member findMember = em.getReference(Member.class, member.getId());
            System.out.println("findMember.class="+ findMember.getClass());
            System.out.println("findMember=" + findMember.getId());
            System.out.println("findMember=" + findMember.getUsername());





            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
