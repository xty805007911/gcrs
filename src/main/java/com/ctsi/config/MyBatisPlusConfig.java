package com.ctsi.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : MyBatisPlusConfig
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-11-04 08:55
 */
@Configuration
@ConditionalOnClass(value = PaginationInnerInterceptor.class)
public class MyBatisPlusConfig {

    //配置可分页
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
