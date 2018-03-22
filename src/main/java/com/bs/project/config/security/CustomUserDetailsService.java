package com.bs.project.config.security;


import com.bs.project.consumer.dao.ResourceDao;
import com.bs.project.consumer.dao.UserRepository;
import com.bs.project.consumer.model.Resource;
import com.bs.project.consumer.model.SysUser;
import com.bs.project.consumer.service.ResourceService;
import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nominal on 2018/3/20 0020.
 * 微博：@Mr丶Li_Anonym
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ResourceService resourceService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(username);

        if (user != null) {
            //如果没有问题，拿到userInfo的authorities集合
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            //登录已经成功，构建返回的用户登录成功的token（类似于session），需要传入userInfo，密码，权限集合三个参数
            return new User(user.getUsername(), user.getPassword(), authorities);
        }else {
            throw new UsernameNotFoundException("用户不存在！");
        }
    }



}
