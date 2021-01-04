package com.ctsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @ClassName : TestController
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-25 11:38
 */
@Controller
public class TestController {

    @GetMapping("/test")
    public String test(HttpServletRequest request,@RequestParam(required = false) Integer login) {
        request.setAttribute("test","test succ");
        if(login != null && login == 1) {
            HashMap<String,String> map = new HashMap<>();
            map.put("realname","xty111");
            System.out.println();
            map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            request.getSession().setAttribute("sessionUser",map);
    }
        return "user/user-index.html";
    }

}
