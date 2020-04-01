package com.mlandgt.controller;

import com.mlandgt.beans.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.UUID;

@RestController
@Slf4j
public class RedisController {

    @Autowired
    private JedisCluster jedisCluster;

    @GetMapping(value = "/redis/get")
    public void testRedis() {
        log.info("1");

        for (int i = 0; i < 1; i++) {
            String key = UUID.randomUUID().toString();
            jedisCluster.set(key, key);
            log.info("key: "+ jedisCluster.get(key));
        }
    }
}
