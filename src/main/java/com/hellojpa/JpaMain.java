package com.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for(Member m : members){
                System.out.println("m = " + m.getUsername());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
