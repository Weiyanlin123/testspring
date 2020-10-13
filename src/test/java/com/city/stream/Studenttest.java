package com.city.stream;

import com.citycloud.dcm.street.param.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weiyl
 * @date 2020/9/7 15:11
 */
public class Studenttest {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();
        Person p = new Person(1, "小明", 0);
        Person p2 = new Person(2, "小红", 0);
        Person p3 = new Person(3, "老王", 0);
        list.add(p);
        list.add(p2);
        list.add(p3);
        Person p4 = new Person(1, null, 10);
        Person p5 = new Person(2, null, 20);

        list2.add(p4);
        list2.add(p5);

        list.stream().flatMap(x -> list2.stream().filter(
                y -> x.getId() == y.getId() && x.getAge() == 0 && y.getName() == null)
                .map(y -> new Person(x.getId(), x.getName(), y.getAge()))
        ).collect(Collectors.toList()).forEach(m -> System.out.println(m));

    }

}
