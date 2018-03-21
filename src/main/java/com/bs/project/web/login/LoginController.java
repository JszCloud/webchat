package com.bs.project.web.login;

import com.bs.project.consumer.model.User;
import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.applet.resources.MsgAppletViewer;

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

    @RequestMapping("/chat")
    public String index(Principal principal,Model model){
        User user=userService.findAll(principal.getName());
        model.addAttribute("user",user);
        System.out.println(principal);
        List<User> friends=userService.find();
        friends.remove(user);
        for (User friend : friends) {
            System.out.println(friend);
        }
        model.addAttribute("friends",friends);
        return "chat";
    }
}
