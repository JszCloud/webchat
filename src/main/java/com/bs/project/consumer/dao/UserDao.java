package com.bs.project.consumer.dao;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Nominal on 2018/3/27 0027.
 * 微博：@Mr丶Li_Anonym
 */
@Component
public interface UserDao {
    @Modifying
    @Transactional
    @Query("update SysUser as s set s.username=:username,s.nikename=:nikename,s.password=:password where s.id = :id")
    Integer updateNameById(@Param("id") Long id,@Param("username") String username,@Param("nikename") String nikename,@Param("password") String password);

}
