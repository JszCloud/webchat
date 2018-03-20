package com.bs.project.consumer.dao;

import com.bs.project.consumer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Nominal on 2018/3/19 0019.
 * 微博：@Mr丶Li_Anonym
 */
@Component
public interface UserRepository extends JpaRepository<User,Long>{
    //根据输入的用户名查询用户信息
    User findByUsername(String username);
}
