package com.citycloud.dcm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.citycloud.dcm.street.mapper")
public class Application {
    //dev分支

    //测试合并

    //合并远程分支
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
