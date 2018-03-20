package com.bs.project.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.applet.resources.MsgAppletViewer;

/**
 * Created by Nominal on 2018/3/19 0019.
 * 微博：@Mr丶Li_Anonym
 */
@Controller
public class LoginController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
