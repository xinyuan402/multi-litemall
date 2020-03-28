package com.lcwork.multimall.sysadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {
        "com.lcwork.multimall.db",
        "com.lcwork.multimall.core",
        "com.lcwork.multimall.sysadmin"
})
@MapperScan("com.lcwork.multimall.db.dao")
@EnableTransactionManagement
@EnableScheduling
public class SysadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysadminApplication.class, args);
    }

}
