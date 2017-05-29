package com.digia.fileapp.store; 

import java.util.ResourceBundle;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
 
@Configuration 
public class RedisConfiguration {

    private static final String PROPERTIES_FILENAME = "APPFILEAPI";

    private static ResourceBundle propertiesBundle;

    static {
       propertiesBundle = ResourceBundle.getBundle(PROPERTIES_FILENAME);
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        String hostName = propertiesBundle.getString("fileapi.redishostname");
        String hostPort = propertiesBundle.getString("fileapi.redishostport");
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName(hostName);
        jedisConFactory.setPort(Integer.parseInt(hostPort));
        return jedisConFactory;
    }

    // @Bean
    // JedisConnectionFactory jedisConnectionFactory() {
    //     return new JedisConnectionFactory();
    // }
 
    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> template = new RedisTemplate<String, String>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}