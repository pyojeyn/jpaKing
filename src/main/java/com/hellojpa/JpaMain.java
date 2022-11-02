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
            // JPQL : 대상이 객체 멤버 객체 다가져와
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(2)
                    .setMaxResults(10)
                    .getResultList();
            // 1번부터 10개 가져와

            for (Member member : result){
                System.out.println("member.name = " + member.getName());
            }




            // 처음 생성
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("JungHoon");

            // 수정임. 찾아내서  set 만 해주면됨. 대박쿠.
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("prettyJENNYBOO");

            // 처음 조회 한명
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println(findMember.getId());
//            System.out.println(findMember.getName());

            // 삭제임 초간단
//            em.remove(findMember);

//            em.persist(member);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
