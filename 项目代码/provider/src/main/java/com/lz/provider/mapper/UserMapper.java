package com.lz.provider.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("select des from data where ip1 = #{ip}")
    String findCityByIp(@Param("ip") String ip);
}
