package com.bs.project.consumer.dao;

import com.bs.project.consumer.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nominal on 2018/3/19 0019.
 * 微博：@Mr丶Li_Anonym
 */
public interface UserRepository extends JpaRepository<SysUser,Long>{
    //根据输入的用户名查询用户信息
    SysUser findByUsername(String username);

    //添加用户信息

}
