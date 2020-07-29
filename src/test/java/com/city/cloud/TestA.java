package com.city.cloud;

import java.util.HashMap;

public class TestA {
    public static void main(String[] args) {
        A a = new A();

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("","");


        System.out.println(a.getATest());
    }
}
