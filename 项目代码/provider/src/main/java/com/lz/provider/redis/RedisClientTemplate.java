package com.lz.provider.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisClientTemplate {

    private static final Logger log = LoggerFactory.getLogger(RedisClientTemplate.class);

    @Autowired
    private JedisClusterConfig jedisClusterConfig;

    public boolean setToRedis(String key,Object value){
        try {
            jedisClusterConfig.getJedisCluster().set(key, String.valueOf(value));
            return true;
        } catch (Exception e){
            log.error("setToRedis:{Key:"+key+",value:"+value+"}",e);
        }
        return false;
    }

    public Object getRedis(String key){
        String str = null;
        try {
            str = jedisClusterConfig.getJedisCluster().get(key);
        } catch (Exception e){
            log.error("getToRedis:{Key:"+key+"}",e);
        }
        return str;
    }
}
