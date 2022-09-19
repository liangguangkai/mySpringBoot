package com.lgk.myspringboot.controller;

import com.lgk.myspringboot.entity.Man;
import com.lgk.myspringboot.service.impl.ManService;
import com.lgk.myspringboot.utils.OssUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liangguangkai
 * @version 1.0
 * @date 2022/8/17
 */
@RestController
@RequestMapping
public class TestController {
    @Resource
    OssUtil ossUtil;
    @Resource
    ManService manService;
    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("test")
    public void Test(){
        ossUtil.getObjectForeverUrl("aaa", "aaa");
    }

    @Transactional
    @GetMapping("/add/man")
    public void testAddMan(){
        Man lgk1 = new Man(null, "lgk1", 12);
        redisTemplate.opsForValue().set("man-" + lgk1 , lgk1);
        manService.save(lgk1);

    }

}
