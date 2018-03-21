package com.bs.project.consumer.service;

import com.bs.project.consumer.dao.UserRepository;
import com.bs.project.consumer.model.Role;
import com.bs.project.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    User findAll(String name);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer save(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    Integer delete(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer edit(User user);

    /**
     * 修改权限
     * @param user
     * @param role
     * @return
     */
    Integer editRole(User user, Role role);

    List<User> find();

}
