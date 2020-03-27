package com.lcwork.multishop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.lcwork.multishop"})
@MapperScan("com.lcwork.multishop.db.dao")
@EnableTransactionManagement
@EnableScheduling
public class MallApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MallApplication.class, args);
    }
}
