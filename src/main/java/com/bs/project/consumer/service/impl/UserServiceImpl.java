package com.bs.project.consumer.service.impl;

import com.bs.project.consumer.dao.UserRepository;
import com.bs.project.consumer.model.Role;
import com.bs.project.consumer.model.User;
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
    public User findAll(String name) {
        return userRepository.findByUsername(name);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public Integer save(User user) {
        //加密输入的密码
        String encodePwd=encoder.encode(user.getPassword());
        System.out.println("加密后"+encodePwd);
        user.setPassword(encodePwd);
        //定义头像目录
        user.setAvatar("/images/avatar/avatar" + new Random().nextInt(10) + ".jpg");
        //注册时间
        user.setJoinTime(new Date());
        List<Role> roles=new ArrayList<>();

        roles.add(new Role("ROLE_USER"));
        user.setRoles(roles);
        User user1=userRepository.save(user);
        System.out.println(user1);
        return null;
    }

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    @Override
    public Integer delete(User user) {
        return null;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public Integer edit(User user) {
        return null;
    }

    /**
     * 修改权限
     *
     * @param user
     * @param role
     * @return
     */
    @Override
    public Integer editRole(User user, Role role) {
        return null;
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<User> find(){
        return userRepository.findAll();
    }
}
