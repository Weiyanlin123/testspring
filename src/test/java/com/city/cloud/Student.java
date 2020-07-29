//
//package com.city.cloud;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Student{
//
//        //唯一
//        private String id;
//
//        private String name;
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                '}';
//    }
//
//    public Student() {
//        }
//
//        public Student(String id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//
//    public static void main(String[] args) {
//        Student studentA = new Student("20190001","小明");
//        Student studentB = new Student("20190002","小红");
//        Student studentC = new Student("20190003","小丁");
//
//
//        //Function.identity() 获取这个对象本身，那么结果就是Map<String,Student> 即 id->student
//        //串行收集
//        Map<String, Student> collect = Stream.of(studentA, studentB, studentC)
//                .collect(Collectors.toMap(Student::getId, Function.identity()));
//
//        Map<String, Student> collect1 = Stream.of(studentA, studentB, studentC)
//                .collect(Collectors
//                        .toMap(Student::getId,
//                                Function.identity(),
//                                (s1, s2) -> {
//
//                                    //这里使用compareTo 方法 s1>s2 会返回1,s1==s2 返回0 ，否则返回-1
//                                    if (((Student) s1).name.compareTo(((Student) s2).name) < -1) {
//                                        return s2;
//                                    } else {
//                                        return s1;
//                                    }
//                                }));
//
//        System.out.println(collect);
//
//
//        Optional<Integer> collect2 = Stream.of(studentA, studentB, studentC)
//                .map(e -> e.name.length())
//                .collect(Collectors.reducing(Integer::sum));
//
//        System.out.println(collect2.get());
//
//        Map<String, List<Integer>> collect3 = Stream.of(-6, -7, -8, -9, 1, 2, 3, 4, 5, 6,0)
//                .collect(Collectors.groupingBy(integer -> {
//                    if (integer < 0) {
//                        return "小于";
//                    } else if (integer == 0) {
//                        return "等于";
//                    } else {
//                        return "大于";
//                    }
//                }));
//
//        System.out.println(collect3);
//    }
//    }
