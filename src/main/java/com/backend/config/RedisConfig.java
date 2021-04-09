package com.backend.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 13:07 2021/4/7
 */
@Configurable
@Configuration
public class RedisConfig {
    @Bean
    public Jedis getRedis(){
        return new Jedis("127.0.0.1", 6379);
    }
}
