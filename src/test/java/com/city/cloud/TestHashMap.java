package com.city.cloud;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {


    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("aaa","aaab");
        objectObjectHashMap.put("vvv","aava");
        objectObjectHashMap.get("1");

        Instant now = Instant.now();

        System.out.println(now);
        System.out.println(Instant.ofEpochMilli(11111111));
        System.out.println(Instant.ofEpochSecond(111111111));


        Set<Map.Entry<Object, Object>> entries = objectObjectHashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> it = entries.iterator();

        while (it.hasNext()){
            Map.Entry<Object, Object> next = it.next();
            System.out.println(next.getKey()+"================"+next.getValue());
        }

        for(Object key:objectObjectHashMap.keySet()){
            System.out.println(objectObjectHashMap.get(key));
        }

//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//        }

        for(Map.Entry<Object,Object> ennty:objectObjectHashMap.entrySet()){
            System.out.println(ennty.getKey());
            System.out.println(ennty.getValue());
        }


        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();
        stringStringConcurrentHashMap.put("","");

        String[] str = new String[] { "yang", "hao" };
        List list = Arrays.asList(str);
        //list.add("yangguanbao");
        str[0] = "changed";
        System.out.println(list);

       list.addAll(null);

    }
}
