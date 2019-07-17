package com.cqjtu.wlw.controller;

import com.cqjtu.wlw.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(UserInfo a, HttpSession session) {
        System.out.println("用户:" + a.getUserId() +"\t密码：" + a.getUserPassword()+"\t身份："+ a.getUserIdentity());
        session.setAttribute("user", a);

        String user_page = a.getUserIdentity();//client、manager、worker
        return user_page;
    }

}
