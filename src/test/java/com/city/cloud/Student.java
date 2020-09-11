
package com.city.cloud;

import com.sun.org.apache.xpath.internal.SourceTree;
import lombok.Data;

import javax.xml.ws.soap.Addressing;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class Student {

    //唯一
    private String id;

    private String name;

    private Integer score;

    private String classmame;

    private String province;

    private String city;

    private  String star;

    public Student(String id, String name, Integer score, String classmame, String province, String city) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.classmame = classmame;
        this.province = province;
        this.city = city;
    }

    public Student() { }

    public static void main(String[] args) {
        Student s1 = new Student("20190001", "小A", 80, "初三", "河南", "商丘");
        Student s2 = new Student("20190002", "B", 70, "初三", "河南", "商丘");
        Student s3 = new Student("20190003", "C", 60, "初三", "河南", "濮阳");
        Student s4 = new Student("20190004", "D", 50, "初三", "河南", "濮阳");
        Student s5 = new Student("20190005", "E", 40, "初三", "河南", "安阳");
        Student s6 = new Student("20190006", "F", 30, "初三", "河南", "安阳");
        Student s7 = new Student("20190006", "F", 30, "初三", "河南", "安阳");
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        Double collect = list.stream().filter(st -> st.getProvince() == "河南").collect(Collectors.averagingInt(Student::getScore));
        //分组
        Map<String, IntSummaryStatistics> collect1 = list.stream().filter(st -> st.getProvince() == "河南").collect(Collectors.groupingBy(Student::getCity, Collectors.summarizingInt(Student::getScore)));
        System.out.println(collect1.get("安阳").getMax());
        System.out.println(collect1.get("安阳").getCount());
        System.out.println(collect);
        List<Student> collect2 = list.stream().filter(st -> st.getProvince() == "河南").collect(Collectors.toList());
         list.stream().filter(st -> st.getProvince().equals("河南")).distinct().map(st -> st.getScore() + 1).collect(Collectors.toList()).forEach(e-> System.out.println(e));

        List<Integer> aaa = list.stream().filter(st -> st.getProvince().equals("河南")).distinct().map(st -> st.getScore() + 1).collect(Collectors.toList());

         System.out.println(aaa);
      //  List<Student> collect3 = list.stream().filter(st -> st.getProvince() == "河南").sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());






       // System.out.println(collect3);
//        System.out.println(collect2);
//        List<Map<String, Object>> maps = new ArrayList<>();
//        HashMap<String, Object> map1 = new HashMap<>();
//        map1.put("aaa",1);
//        map1.put("bbb",2);
//        HashMap<String, Object> map2 = new HashMap<>();
//        map2.put("aaa",111);
//        map2.put("bbb",222);
//        maps.add(map2);
//        maps.add(map1);
//        List<Map<String, Object>> aaa = maps.stream().filter(st -> st.get("aaa").equals(111)).collect(Collectors.toList());


        List<Student> classOneStudents = new ArrayList<>();
        List<Student> classTwoStudents = new ArrayList<>();
        List<Student> classThreeStudents = new ArrayList<>();
        List<List<Student>> students = new ArrayList<>();

        classOneStudents.add(new Student("20190001", "AA", 80, "classOne", "河南", "商丘"));
        classOneStudents.add(new Student("20190002", "小A", 70, "classOne", "河南", "商丘"));
        classOneStudents.add(new Student("20190003", "小B", 60, "classOne", "河南", "商丘"));
        classOneStudents.add(new Student("20190004", "小C", 50, "classOne", "河南", "商丘"));

        classTwoStudents.add(new Student("20190001", "小D", 90, "classTwoStudents", "河南", "商丘"));
        classTwoStudents.add(new Student("20190005", "小E", 90, "classTwoStudents", "河南", "商丘"));
        classTwoStudents.add(new Student("20190006", "小F", 80, "classTwoStudents", "河南", "商丘"));

        classThreeStudents.add(new Student("20190001", "小G", 70, "初三", "河南", "商丘"));
        classThreeStudents.add(new Student("20190001", "小H", 80, "初三", "河南", "商丘"));
        students.add(classOneStudents);
        students.add(classTwoStudents);
        students.add(classThreeStudents);


        /**
         * flatmap 出入的参数必须是 stream
         * map 是收集一个个元素的
         */
        List<Student> collect3 = classOneStudents.stream().flatMap(one -> classTwoStudents.stream().filter(two -> two.getId().equals(one.getId())).map(
                s -> {
                    Student student = new Student();
                    student.setId(s.getId());
                    student.setName(one.getName());
                    student.setClassmame(s.getClassmame());
                    return student;
                }
                )
        ).collect(Collectors.toList());

        System.out.println(collect3);


        //5 flatMap 把Stream中的层级结构扁平化并返回Stream
        List<Student> studentList = students
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        //展开多个List合并到一个新list
       // studentList.stream().forEach(System.out::println);
       // System.out.println(students);

    }

}