package com.bs.project.web.control;

import com.bs.project.consumer.model.SysUser;
import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Nominal on 2018/3/21 0021.
 * 微博：@Mr丶Li_Anonym
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("to_register")
    public String to_register(){
        return "register";
    }
    @PostMapping("do_register")
    public String do_register(SysUser sysUser){
        System.out.println(sysUser);
        userService.save(sysUser);
        return "redirect:/login";
    }

}
