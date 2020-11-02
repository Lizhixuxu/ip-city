package com.lz.consumer.controller;

import com.lz.consumer.feign.ipCityFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private ipCityFeign ipCityFeign;


    @RequestMapping(value = "/findCityByIp",method = RequestMethod.POST)
    public String findCityByIp(@RequestParam("ip") String ip){
//        System.out.println("ip:"+ip);
        String city = ipCityFeign.findCityByIp(ip);
//        System.out.println("city:"+city);
        return city;
    }
}