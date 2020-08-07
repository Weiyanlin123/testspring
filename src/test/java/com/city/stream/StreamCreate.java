//package com.city.stream;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//public class StreamCreate {
//
//
//    public static void main(String[] args) {
//
//        unLimitStream2();
//    }
//
//    public static void testArrayStream(){
//        int[] arr = new int[]{1,2,3,4,5};
//        IntStream intStream = Arrays.stream(arr);
//        Student[] students = new Student[]{Student.builder().name("zhangsan").age(12).score(12).build(),Student.builder().name("zhangsan").age(12).score(12).build()};
//        Stream<Student> studentStream = Arrays.stream(students);
//        Stream<Integer> integerStream =Stream.of(1,2,5,4,6);
//        Stream<int[]> intArrayStrean = Stream.of(arr,arr);
//        intArrayStrean.forEach(System.out::println);
//    }
//
//    public static void testCollectionStream(){
//        List<String> strings = Arrays.asList("sdf","sdfdsf","ertert","sdfdsf");
//        //创建普通流
//        Stream<String> stringStream = strings.stream();
//        //创建并行流
//        Stream<String> parallelStream = strings.parallelStream();
//    }
//
//    public static void emptyStream(){
//        Stream<Integer> stream = Stream.empty();
//    }
//
//    public static void unLimitStream(){
//        Stream.generate((() -> "number" + new Random().nextInt())).limit(20).forEach(System.out::println);
//
//    }
//
//    public static void unLimitStream2(){
//        Stream.iterate(0,x ->x+1).limit(10).forEach(System.out::println);
//        Stream.iterate(0,x ->x).limit(10).forEach(System.out::println);
//    }
//}