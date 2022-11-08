package com.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Hello hello = new Hello();
//            hello.setId("ID_A");
            hello.setUsername("DD");

            System.out.println("=======");
            em.persist(hello);
            // **IDENTITY 전략은 em.persist()시점에 즉시 INSERT SQL을 실행하고 DB에서 식별자를 조회
            System.out.println("hello의 id!!=="+ hello.getId());
            System.out.println("=======");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }

}
