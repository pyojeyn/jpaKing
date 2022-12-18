package com.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExtendExample {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //  <persistence-unit name="hello">

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try {




            Movie movie = new Movie();
            movie.setDirector("봉준호");
            movie.setActor("신세경");
            movie.setName("바람과 함께 사라지다");
            movie.setPrice(10000);

            em.persist(movie);
            em.flush();
            em.clear();

//            Movie findMovie = em.find(Movie.class, movie.getId());

            Item item = em.find(Item.class, movie.getId());
            System.out.println("item={}" + item);
            /** 조인 전략 했을때.
             * select
             *         m.id as id,
             *         i.name as name,
             *         i.price as price,
             *         m.actor as actor,
             *         m.director as director
             *     from
             *         Movie m
             *     inner join
             *         Item i
             *             on m.id=i.id
             *     where
             *         m.id = 1
             */

            /** 싱글테이블 전략 했을 떄.
             * select
             *         id ,
             *         name ,
             *         price ,
             *         actor ,
             *         director
             *     from
             *         Item
             *     where
             *         id=1
             *         and DTYPE='M'
             */






            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
