package org.kxw.bms.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Create by kangxiongwei on 2018/8/11 下午12:53
 */
@SpringBootApplication
@ComponentScan("org.kxw.bms")
@MapperScan("org.kxw.bms.auth.dao")
public class BmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmsApplication.class, args);
    }

}
