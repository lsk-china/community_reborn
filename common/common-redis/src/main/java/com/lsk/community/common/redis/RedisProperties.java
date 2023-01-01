package com.lsk.community.common.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("common.redis")
public class RedisProperties {
    private Integer database = 2;
    private String host = "localhost";
    private Integer port = 6379;
    private String password = "";
}
