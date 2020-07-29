package com.citycloud.dcm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.citycloud.dcm.street.mapper")
public class Application {

    public static void main(String[] args) {
        Integer integer = new Integer(0);
        Double aDouble = new Double(0);
        SpringApplication.run(Application.class, args);
    }

}
