package com.city.cloud;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        User x = new User("x",11);
        User y = new User("y",12);
        User w = new User("w",10);

        Stream.of(w,x,y)
                .sorted((e1,e2)->e1.age>e2.age?1:e1.age==e2.age?0:-1)
                .forEach(e->System.out.println(e.toString()));

    }

    static class User {

        private String name;

        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}