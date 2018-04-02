package com.bs.project;

import com.bs.project.consumer.model.SysUser;
import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nominal on 2018/4/2 0002.
 * 微博：@Mr丶Li_Anonym
 */

public class Test {
   @Autowired
    UserService userService;


    @org.junit.Test
   public void test(){
        userService.save(new SysUser("room","room","room"));
}

}
