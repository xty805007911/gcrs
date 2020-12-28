package com.ctsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Description:页面跳转
 * @Author: Tianyu Xiao
 * @CreateDate: 2020/12/26  6:51
 */
@Controller
public class PageToController {

    //重定向的index页面
    @RequestMapping("/")
    public String toInde() {
        return "redirect:/user/index";
    }

    //用户首页地图展示
    @RequestMapping("/user/index")
    public String userMapIndex(HttpServletRequest request,@RequestParam(required = false) Integer login) {
        return "user/user-index";
    }

    //派单员地图展示
    @RequestMapping("/send/index")
    public String sendMapIndex() {
        return "send/send-index";
    }

    //去登陆页面
    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request) {
        request.setAttribute("msg","");
        return "login";
    }

}
