package com.lcwork.multishop.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.lcwork.multishop.db", "com.lcwork.multishop.core", "org" +
        ".linlinjava.litemall.admin"})
@MapperScan("com.lcwork.multishop.db.dao")
@EnableTransactionManagement
@EnableScheduling
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
