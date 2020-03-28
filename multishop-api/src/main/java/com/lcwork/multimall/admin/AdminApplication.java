package com.lcwork.multimall.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.lcwork.multimall.db", "com.lcwork.multimall.core", "org" +
        ".linlinjava.litemall.admin"})
@MapperScan("com.lcwork.multimall.db.dao")
@EnableTransactionManagement
@EnableScheduling
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
