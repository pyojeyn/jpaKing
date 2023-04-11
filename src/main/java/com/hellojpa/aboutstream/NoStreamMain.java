package com.hellojpa.aboutstream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// 만약 Stream 을 사용하지 않는다면.
public class NoStreamMain {

    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Song", 33));
        customers.add(new Customer("Kim", 44));
        customers.add(new Customer("Park", 32));
        customers.add(new Customer("Lee", 11));
        customers.add(new Customer("Choi", 13));

        // 나이 30살 이상 오름차순 이름 STRING 추출 할거임.

        List<Customer> list = new ArrayList<>();
        for(Customer customer : customers){
            if(customer.getAge() > 30){
                list.add(customer);
            }
        } // age > 30 추출.

        Collections.sort(list); // age 오름차순

        List<String> results = new ArrayList<>();
        for(Customer customer : list){
            results.add(customer.getName());
        }

        for(String name : results){
            System.out.println("name: " + name);
        }


    }
}
