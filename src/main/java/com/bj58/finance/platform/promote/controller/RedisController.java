package com.bj58.finance.platform.promote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testRedis")
public class RedisController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("setKey")
    public void set(){

        for(int i = 0; i < 10000; i ++){
            redisTemplate.opsForValue().set("myKey" + i,"myValue" + i);
        }

//        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }
}
