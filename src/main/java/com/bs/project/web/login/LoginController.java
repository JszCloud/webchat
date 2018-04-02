package com.bs.project.web.login;

import com.bs.project.consumer.model.SysUser;
import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * Created by Nominal on 2018/3/19 0019.
 * 微博：@Mr丶Li_Anonym
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String to_index(){
        return "index";
    }

    @GetMapping("head")
    public String head(){
        return "head";
    }


    @RequestMapping("/chat")
    public String index(Principal principal,Model model){
        SysUser sysUser =userService.findAll(principal.getName());
        model.addAttribute("sysUser", sysUser);
        System.out.println(principal);
        List<SysUser> friends=userService.find();
        friends.remove(sysUser);
        for (SysUser friend : friends) {
            System.out.println(friend);
        }
        model.addAttribute("friends",friends);
        return "chat";
    }
}
