package com.hellojpa.aboutstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 하지만 Stream 을 사용한다면 ?
public class StreamMain {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Song", 33));
        customers.add(new Customer("Kim", 44));
        customers.add(new Customer("Park", 32));
        customers.add(new Customer("Lee", 11));
        customers.add(new Customer("Choi", 13));

        List<String> customersNames = customers.stream()
                .filter(customer -> customer.getAge() > 30) //필터링 : 중간연산
                .sorted() //정렬 : 중간연산
                .map(Customer::getName) //매핑 : 중간연산
                .collect(Collectors.toList()); // 리스트 형태로 수집 반환 : 최종연산

        for (String name : customersNames){
            System.out.println("name: " + name);
        }

        /**
         * 스트림의 연산읜 중간 연산, 최종연산이 있다.
         * 중간 연산은 filter,map과 같은 연산으로 Stream을 반환.
         * 중간연산은 연속해서 호출하는 메소드 체이닝으로 구현 가능.
         * 최종연산이 실행되어야 중간연산이  처리되므로 중간연산들로만 구성된 메소드 체인은 실행 안됨.
         * filter, map, limit, sorted, distinct, peek, skip -> 중간 연산.
         *
         * 최종 연산. forEanch, collect와 같은 연산으로 void를 반환하거나 컬렉션 타입을 반환.
         * 중간 연산을 통해 가공된 스트림은 마지막으로 최종연산을 통해 각 요소를 소모하여 결과를 출력.
         * 즉, 지연(lazy)되었던 모등 중간 연산들이 최종연산시 모두 수향되는 것.
         * 최종 연산 후에는 한번 생성해서 소모한 스트림은 닫히게 되고 재사용이 불가능함.
         * forEach, count, collect, sum, reduce
         */

    }
}
