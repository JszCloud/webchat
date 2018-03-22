package com.bs.project.consumer.service.impl;

import com.bs.project.consumer.dao.UserRepository;
import com.bs.project.consumer.model.SysRole;
import com.bs.project.consumer.model.SysUser;
import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Nominal on 2018/3/20 0020.
 * 微博：@Mr丶Li_Anonym
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    //这里我们还要判断密码是否正确，实际应用中，我们的密码一般都会加密，以Md5加密为例

    BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();


    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    @Override
    public SysUser findAll(String name) {
        return userRepository.findByUsername(name);
    }

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @Override
    public Integer save(SysUser sysUser) {
        //加密输入的密码
        String encodePwd=encoder.encode(sysUser.getPassword());
        System.out.println("加密后"+encodePwd);
        sysUser.setPassword(encodePwd);
        //定义头像目录
        sysUser.setAvatar("/images/avatar/avatar" + new Random().nextInt(10) + ".jpg");
        //注册时间
        sysUser.setJoinTime(new Date());
        List<SysRole> sysRoles =new ArrayList<>();

        sysRoles.add(new SysRole(2L));
        sysUser.setSysRoles(sysRoles);
        SysUser sysUser1 =userRepository.save(sysUser);
        System.out.println(sysUser1);
        return null;
    }

    /**
     * 删除用户
     *
     * @param sysUser
     * @return
     */
    @Override
    public Integer delete(SysUser sysUser) {
        return null;
    }

    /**
     * 修改用户信息
     *
     * @param sysUser
     * @return
     */
    @Override
    public Integer edit(SysUser sysUser) {
        return null;
    }

    /**
     * 修改权限
     *
     * @param sysUser
     * @param sysRole
     * @return
     */
    @Override
    public Integer editRole(SysUser sysUser, SysRole sysRole) {
        return null;
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<SysUser> find(){
        return userRepository.findAll();
    }
}
