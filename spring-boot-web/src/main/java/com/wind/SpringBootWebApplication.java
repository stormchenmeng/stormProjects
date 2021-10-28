package com.wind;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * @author cmm
 */
@SpringBootApplication(scanBasePackages = "com.wind")
@EnableAsync
@EnableWebMvc
@EnableWebSocket
@MapperScan(basePackages = "com.wind.dao")
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
