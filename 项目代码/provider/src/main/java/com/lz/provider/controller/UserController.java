package com.lz.provider.controller;

import com.lz.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findCityByIp/{ip}")
    public String findCityByIp(@PathVariable("ip") String ip){
        System.out.println("ip:"+ip);
        return userService.findCityByIp(ip);
    }

}
