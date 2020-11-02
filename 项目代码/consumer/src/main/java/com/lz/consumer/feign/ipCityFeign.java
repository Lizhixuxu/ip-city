package com.lz.consumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider")
@Component
public interface ipCityFeign {

    @RequestMapping(value = "/user/loginUser/{name}/{pwd}")
    String loginUser(@PathVariable("name") String name, @PathVariable("pwd") String pwd);

    @RequestMapping(value = "/user/findCityByIp/{ip}")
    String findCityByIp(@PathVariable("ip") String ip);
}
