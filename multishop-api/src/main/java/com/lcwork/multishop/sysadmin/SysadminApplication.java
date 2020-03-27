package com.lcwork.multishop.sysadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {
        "com.lcwork.multishop.db",
        "com.lcwork.multishop.core",
        "com.lcwork.multishop.sysadmin"
})
@MapperScan("com.lcwork.multishop.db.dao")
@EnableTransactionManagement
@EnableScheduling
public class SysadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysadminApplication.class, args);
    }

}
