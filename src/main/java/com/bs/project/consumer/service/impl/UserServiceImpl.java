package com.bs.project.consumer.service.impl;

import com.bs.project.consumer.dao.UserRepository;
import com.bs.project.consumer.model.User;
import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nominal on 2018/3/20 0020.
 * 微博：@Mr丶Li_Anonym
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findAll(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Integer save() {
        return null;
    }
}
