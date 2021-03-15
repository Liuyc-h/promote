package com.bj58.finance.platform.promote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.bj58.finance.platform.promote.db.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class PromoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PromoteApplication.class, args);
    }

}
