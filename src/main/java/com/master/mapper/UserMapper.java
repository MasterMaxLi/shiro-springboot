package com.master.mapper;

import com.master.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Creqated by Limingxuan on 2021/3/3
 */
@Repository
@Mapper
public interface UserMapper {

    User queryUserByName(@Param("userName") String userName);
}
