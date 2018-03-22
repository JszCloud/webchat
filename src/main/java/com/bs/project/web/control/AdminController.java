package com.bs.project.web.control;

import com.bs.project.consumer.model.SysRole;
import com.bs.project.consumer.model.SysUser;
import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Nominal on 2018/3/21 0021.
 * 微博：@Mr丶Li_Anonym
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String admin(Model model){
        List<SysUser> sysUsers=userService.find();
        System.out.println(sysUsers);
        model.addAttribute("sysUser",sysUsers);
        return "admin_control";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        return "";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){

        return "edit";
    }
}
