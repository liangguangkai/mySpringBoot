package com.lgk.myspringboot.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author liangguangkai
 * @version 1.0
 * @date 2022/8/31
 */
@RequestMapping("test")
@RestController
public class TestRedisController {


    @Resource
    RedisTemplate<String, String> redisTemplate;


    @GetMapping("add")
    public String addInt(){

        if(!redisTemplate.hasKey("count")){
            redisTemplate.opsForValue().set("count", "0", 1, TimeUnit.DAYS);
        }


        redisTemplate.opsForValue().increment("count");
        return null;
    }

    @GetMapping("get")
    public String getInt(){

        redisTemplate.opsForValue().get("count");
        return null;
    }


}
