package com.master.service;

import com.master.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Creqated by Limingxuan on 2021/3/3
 */
public interface UserService {
    User queryUserByName(String userName);
}
