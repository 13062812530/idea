package com.idea.bms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.idea")
@MapperScan("com.idea.bms.dao")
@SpringBootApplication
@EnableSwagger2
public class BmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BmsApplication.class,args);
    }
}
