package com.lcwork.multishop.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.lcwork.multishop.db", "com.lcwork.multishop.core", "com.lcwork.multishop.wx"})
@MapperScan("com.lcwork.multishop.db.dao")
@EnableTransactionManagement
@EnableScheduling
public class WxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class, args);
    }

}
