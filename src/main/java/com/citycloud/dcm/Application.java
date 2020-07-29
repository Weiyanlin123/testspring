package com.citycloud.dcm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.citycloud.dcm.street.mapper")
public class Application {
    //提交master
    //dev分支
    //master 合并
    public static void main(String[] args) {
        //nihao
        SpringApplication.run(Application.class, args);
    }

}
