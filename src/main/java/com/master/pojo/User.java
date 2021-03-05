package com.master.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Creqated by Limingxuan on 2021/3/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Date birthday;
    private Character sex;
    private String address;
    private String perms;
}
