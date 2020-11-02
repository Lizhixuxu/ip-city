package com.lz.provider.service;

import com.lz.provider.mapper.UserMapper;
import com.lz.provider.redis.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String findCityByIp(String ip) {
        Object val = redisClientTemplate.getRedis(ip);
        System.out.println("val:"+val);
        if(val!=null){
            System.out.println("从缓存查询");
            return val.toString();
        }
        System.out.println("从数据库查询");
        String city = userMapper.findCityByIp(ip);
        redisClientTemplate.setToRedis(ip,city);
//        System.out.println(city);
        return city;
    }
}
