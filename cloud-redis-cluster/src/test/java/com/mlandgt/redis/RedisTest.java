package com.mlandgt.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mlandgt.beans.User;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisCluster;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {
    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void testRedis() throws InterruptedException {
        log.info("cluster node: " + jedisCluster.getClusterNodes());
        String key = "user:1";
        jedisCluster.set(key, new User(123, "123", 12).toString());
        Thread.sleep(2000L);
        jedisCluster.get(key);
        log.info("user: " + jedisCluster.get(key));
    }
}
