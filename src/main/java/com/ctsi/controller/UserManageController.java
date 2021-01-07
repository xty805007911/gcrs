package com.ctsi.controller;

import com.ctsi.config.Constant;
import com.ctsi.entity.TbUser;
import com.ctsi.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: Tianyu Xiao
 * @CreateDate: 2021/1/7  20:58
 */
@Controller
public class UserManageController {
    @Autowired
    private TbUserService userService;

    // 查询接单员列表
    @RequestMapping("/manage/system/user/sendList")
    public String useSendList(HttpServletRequest request,Integer page,Integer size) {
        request.setAttribute("pageResult",userService.userListByRole(2,page, Constant.PAGE_SIZE));
        request.setAttribute("roleId",2);
        return "system-manage/user-list";
    }

    // 查询用户列表
    @RequestMapping("/manage/system/user/list")
    public String userList(HttpServletRequest request,Integer page,Integer size) {
        request.setAttribute("pageResult",userService.userListByRole(1,page, Constant.PAGE_SIZE));
        request.setAttribute("roleId",1);
        return "system-manage/user-list";
    }

    //更新用户状态
    @RequestMapping("/manage/system/user/{userId}/setStatus/{enabled}")
    public String setUserEnabled(@PathVariable Integer enabled,@PathVariable Integer userId) {
        TbUser user = userService.getUserById(userId);
        user.setEnabled(enabled);
        userService.updateUserInfo(user);
        if(user.getRoleId() == 2) {
            return "redirect:/manage/system/user/sendList";
        }else {
            return "redirect:/manage/system/user/list";
        }
    }
}
