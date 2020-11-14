package com.bj58.finance.platform.promote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.bj58.finance.platform.promote.db.mapper")
@SpringBootApplication
public class PromoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PromoteApplication.class, args);
    }

}
