package com.hellojpa;

import org.hibernate.Hibernate;

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

            Member member1 = new Member();
            member.setUsername("member1");
            em.persist(member1);



            em.flush();
            em.clear();

           Member refMember = em.getReference(Member.class, member1.getId());
           System.out.println("refMember.class=" + refMember.getClass());  //proxy
            Hibernate.initialize(refMember); // 강제 초기화
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));


//            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId()); // 가짜 프록시 객체
//            System.out.println("findMember=" + findMember.getClass()); //Member$HibernateProxy$7hN72mTU 하이버 네이트가 만들어낸 가짜 클래스
//            System.out.println("findMember.getId()=" + findMember.getId()); // 이때는 쿼리 안나감.
//            System.out.println("findMember.getUsername()=" + findMember.getUsername());// 이때는 쿼리 나감.
//            System.out.println("findMember.getUsername()=" + findMember.getUsername()); // 두번째는 쿼리 안나감. 이미 값 가져왔기 때문.

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
/**
 * em.find() vs em.getReference
 * em.find() : 데이터베이스를 통해서 실제 엔티티 객체 조회
 * em.getReference() : 데이터베이스 조회를 미루는 가짜(프록시) 엔티티 객체 조회
 * 프록시 특징
 * 1. 실제 클래스 상속 받아서 만들어짐
 * 2. 실제 클래스와 겉 모양이 같다.
 * 3.사용하는 입장에서는 진짜 객체인지 프록시 객체인지 구분하지 않고 사용하면 됨(이론상)
 * 4.프록시 객체는 실제 객체의 참조(target) 를 보관
 * 5. 프록시 객체를 호출하면 프록시 객체는 실제 객체의 메소드를 호출
 * 6. 영속성 컨텍스트에 이미 엔티티가 있으면 em.getReference() 를 호출해도 실제 엔티티 반환
 * 7. 프록시 객체는 원본 엔티티를 상속 받음, 따라서 타입 체크시 주의 해야함. (==비교 실패, 대신 instance of 를 사용)
 */