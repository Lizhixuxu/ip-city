package com.lz.provider.controller;

import com.lz.provider.redis.RedisClientTemplate;
import com.lz.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @RequestMapping("/testSet")
    public Object testSet(){
        System.out.println("testSet");
        redisClientTemplate.setToRedis("lz","plmm");
        Object lz = redisClientTemplate.getRedis("lz");
        System.out.println(lz);
        return lz;
    }

}
