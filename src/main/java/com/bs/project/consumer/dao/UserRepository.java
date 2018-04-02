package com.bs.project.consumer.dao;

import com.bs.project.consumer.model.SysUser;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Nominal on 2018/3/19 0019.
 * 微博：@Mr丶Li_Anonym
 */
public interface UserRepository extends JpaRepository<SysUser, Long> {
    //根据输入的用户名查询用户信息
    SysUser findByUsername(String username);

    SysUser findByIdEquals(Long id);

    Integer deleteSysUserById(Long id);



}
