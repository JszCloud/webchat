package com.bs.project.consumer.service;

import com.bs.project.consumer.dao.UserRepository;
import com.bs.project.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Nominal on 2018/3/19 0019.
 * 微博：@Mr丶Li_Anonym
 */
@Service
public interface UserService {

    User findAll(String name);

    Integer save();


}
