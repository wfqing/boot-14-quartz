////////////////////////////////////////
///////////////////////////////////////
package com.etoak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 启动spring task配置 123
public class Boot14App {

    public static void main(String[] args) {
        SpringApplication.run(Boot14App.class, args);
    }



}
