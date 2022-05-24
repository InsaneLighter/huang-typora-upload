package com.huang.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Time 2022-04-22 11:53
 * Created by Huang
 * className: MinioProperties
 * Description:
 */
@Data
@Component
@PropertySource("app.properties")
public class MinioProperties {
    /**
     * 连接地址
     */
    @Value("${endpoint}")
    private String endpoint;
    /**
     * 用户名
     */
    @Value("${accessKey}")
    private String accessKey;
    /**
     * 密码
     */
    @Value("${secretKey}")
    private String secretKey;
    /**
     * 域名
     */
    @Value("${nginxHost}")
    private String nginxHost;
}