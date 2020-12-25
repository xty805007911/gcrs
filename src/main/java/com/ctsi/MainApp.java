package com.ctsi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName : MainApp
 * @Description :
 * @Author : Xiaotianyu
 * @Date: 2020-08-27 10:07
 */
@SpringBootApplication
@MapperScan("com.ctsi.mapper")
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class,args);
    }
}
