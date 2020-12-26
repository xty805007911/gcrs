package com.ctsi.controller;

import com.ctsi.entity.TbUser;
import com.ctsi.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName : CommonController
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-26 13:24
 */
@Controller
public class CommonController {
    @Autowired
    private TbUserService userService;


    //用户登陆
    @RequestMapping("/login")
    public String login(String mobile, String password, HttpServletRequest request) {
        //根据手机号和密码查询
        TbUser dbUser = userService.getUserByMobileAndPassword(mobile, password);

        //检测用户是否存在
        if(dbUser == null) {
            request.setAttribute("msg","用户名或密码错误");
            return "login";
        }
        //检测当前账户是否可用
        if(dbUser.getEnabled() == null || dbUser.getEnabled() == 0) {
            request.setAttribute("msg","当前用户不可用，请联系管理员");
            return "login";
        }

        //将用户信息设置session
        request.getSession().setAttribute("sessionUser",dbUser);

        //跳转首页
        return "redirect:/";
    }

    //用户退出登陆
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("sessionUser");
        //跳转首页
        return "redirect:/";
    }

}
