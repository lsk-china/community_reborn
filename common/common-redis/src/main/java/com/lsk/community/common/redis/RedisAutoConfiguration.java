package com.lsk.community.common.redis;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@ComponentScan
@RequiredArgsConstructor
@EnableAutoConfiguration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfiguration {
    private final RedisProperties redisProperties;

    @Bean
    @ConditionalOnMissingBean(JedisPool.class)
    public JedisPool jedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxWaitMillis(10000);
        String password = redisProperties.getPassword();
        int database = redisProperties.getDatabase();
        if (password == null || password.equals("")) {
            return new JedisPool(jedisPoolConfig, redisProperties.getHost(), redisProperties.getPort(), 2000, "", database);
        } else {
            return new JedisPool(jedisPoolConfig, redisProperties.getHost(), redisProperties.getPort(), 2000, password, database);
        }
    }

    @Bean
    @ConditionalOnMissingBean(Gson.class)
    public Gson gson() { return new Gson(); }
}
