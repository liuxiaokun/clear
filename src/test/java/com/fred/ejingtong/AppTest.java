package com.fred.ejingtong;


public class AppTest {


    public static void main(String[] args) {

        Long l1 = new Long(1);
        Long l2 = new Long(1);

        System.out.println("l1 == l2:" + (l1 == l2));
        System.out.println("l1.equals(l2):" + l1.equals(l2));


        Long l3 = new Long(129);
        Long l4 = new Long(129);

        System.out.println("l3 == l4:" + (l3 == l4));
        System.out.println("l3.equals(l4):" + l3.equals(l4));

        System.out.println("==============================================================");

        Long l5 = 1L;
        Long l6 = 1L;

        System.out.println("l5 == l6:" + (l5 == l6));
        System.out.println("l5.equals(l6):" + l5.equals(l6));


        Long l7 = 129L;
        Long l8 = 129L;

        System.out.println("l7 == l8:" + (l7 == l8));
        System.out.println("l7.equals(l8):" + l7.equals(l8));


    }
}
