package com.ctsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        if(login != null && login == 1) {
            HashMap<String,String> map = new HashMap<>();
            map.put("realname","xty111");
            map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            request.getSession().setAttribute("sessionUser",map);
        }
        return "user/user-index";
    }

}
