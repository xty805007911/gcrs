package com.ctsi.config;

/**
 * @ClassName : MinioProp
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-09 08:48
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "minio")
@Component
public class MinioProp {
    private String endpoint;
    private String accesskey;
    private String secretkey;
}
