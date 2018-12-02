package com.idea.bms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.idea")
@MapperScan("com.idea.bms.dao")
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class BmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BmsApplication.class,args);
    }
}
