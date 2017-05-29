package com.digia.fileapp.store;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.HashOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope; 

@Repository
@Scope("singleton")
public class RedisStoreImpl {
    
    private static final String KEY = "Application";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private HashOperations hashOps;

    public RedisStoreImpl() { }

    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }

}