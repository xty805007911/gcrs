package com.ctsi.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : MinioConfig
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-09 08:47
 */
@Configuration
public class MinioConfig {

    @Autowired
    private MinioProp minioProp;

    @Bean
    public MinioClient minioClient() throws Exception {
        MinioClient client = new MinioClient(minioProp.getEndpoint(), minioProp.getAccesskey(), minioProp.getSecretkey());
        return client;
    }

}
