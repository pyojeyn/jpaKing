package com.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ParentMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //  <persistence-unit name="hello">

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try {

            Child child1 = new Child();
            Child child2 = new Child();

            // Parent 중심으로 개발하고 싶을때 : Parent persist 할때, child 도 같이 persist 되게 하고 싶음.
            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();
            System.out.println("parentId="+parent.getId());
            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}

/**
 * [ 영속성 전이 : CASCADE ]
 * 1. 특정 엔티티를 영속 상태로 만들 때 연관된 엔티티도 함께 영속 상태로 만들고 싶을 때.
 * 2. 부모 엔티티를 저장할 때 자식 엔티티도 함께 저장.
 * 3. 주의 ! 영속성 전이는 연관관계를 매핑하는 것과 아무 관련이 없음
 * 4. 엔티티를 영속화할 때 연관된 엔티티도 함께 영속화하는 편리함을  제공할 뿐
 * [CASCADE 의 종류]
 * 1. ALL : 모두 적용
 * 2. PERSIST : 영속 ** 삭제하면 안될때.
 * 3. REMOVE : 삭제
 * 4. MERGE : 병합
 * 등등.
 */

/**
 * [고아객체]
 * 1. 고아 객체 제거: 부모 엔티티와 연관관계까 끊어진 자식 엔티티를 자동으로 삭제
 * 2. orphanRemoval = true
 * 3. 참조하는 곳이 하나일 때 사용해야함!
 * 4. 특정 엔티티가 개인 소유할 때 사용
 * 5. @OneToOne , @OneToMany 만 가능.
 * 6. 참고 : 개념적으로 부모를 제거하면 자식은 고아가 된다. 따라서 고아 객체 제거 기능을 활성화 하면,
 *          부모를 제거할 때 자식도 함께 제거된다. 이것은 CascadeType.REMOVE 처럼 동작한다.
 */