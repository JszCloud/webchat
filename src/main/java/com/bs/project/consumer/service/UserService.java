package com.bs.project.consumer.service;

import com.bs.project.consumer.model.SysRole;
import com.bs.project.consumer.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nominal on 2018/3/19 0019.
 * 微博：@Mr丶Li_Anonym
 */
@Service
public interface UserService {
    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    SysUser findAll(String name);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    Integer save(SysUser sysUser);

    /**
     * 删除用户
     * @param sysUser
     * @return
     */
    Integer delete(SysUser sysUser);

    /**
     * 修改用户信息
     * @param sysUser
     * @return
     */
    Integer edit(SysUser sysUser);

    /**
     * 修改权限
     * @param sysUser
     * @param sysRole
     * @return
     */
    Integer editRole(SysUser sysUser, SysRole sysRole);

    List<SysUser> find();

}
