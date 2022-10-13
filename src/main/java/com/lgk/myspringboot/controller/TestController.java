package com.lgk.myspringboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lgk.myspringboot.entity.Man;
import com.lgk.myspringboot.service.impl.ManService;
import com.lgk.myspringboot.utils.OssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liangguangkai
 * @version 1.0
 * @date 2022/8/17
 */
@Api(tags="测试模块")
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
    @ApiOperation(value="用户登录",notes="随边说点啥")
    @GetMapping("/add/man")
    public void testAddMan(){
        Man lgk1 = new Man(null, "lgk1", 12, null);
        redisTemplate.opsForValue().set("man-" + lgk1 , lgk1);
        manService.save(lgk1);

    }

    @ApiOperation(value="用户登录",notes="随边说点啥")
    @GetMapping("/man/{id}")
    public void testGet(@PathVariable(value = "id") Integer id){

        Man byId = manService.getById(id);
        System.out.println(byId);

    }

    public static void main(String[] args) {
        Man lgk1 = new Man(null, "lgk1", 12, null);
        String s = JSON.toJSONString(lgk1);
        System.out.println(s);
        Man man = JSON.parseObject(s, Man.class);
        System.out.println(man);
    }
}
