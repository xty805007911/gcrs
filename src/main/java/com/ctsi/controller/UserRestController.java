package com.ctsi.controller;

import com.ctsi.entity.TbUser;
import com.ctsi.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName : UserRestController
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-26 14:16
 */
@RestController
public class UserRestController {

    @Autowired
    private TbUserService userService;

    //根据用户id查询
    @GetMapping("/api/user/info/{userId}")
    public TbUser getCurrentUserInfo(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    //获取当前用户
    @GetMapping("/api/current/user")
    public TbUser getCurrentUser(HttpServletRequest request) {
        Object sessionUserObj = request.getSession().getAttribute("sessionUser");
        if(sessionUserObj == null) {
            return null;
        }
        return (TbUser) sessionUserObj;
    }
}
