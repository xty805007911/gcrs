package com.ctsi.controller;

import com.ctsi.config.Constant;
import com.ctsi.entity.TbAvatar;
import com.ctsi.service.TbUserService;
import com.ctsi.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName : SystemManageController
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-31 15:03
 */
@Controller
public class SystemManageController {
    @Autowired
    private TbUserService userService;

    //用户头像列表
    @RequestMapping("/manage/system/user/avatarList")
    public String userAvatarPageList(Integer page, HttpServletRequest request) {
        PageResult<TbAvatar> pageResult = userService.avatarPageList(page, Constant.PAGE_SIZE);
        request.setAttribute("pageResult",pageResult);
        return "system-manage/avatar-list";
    }

    //用户头像添加
    @RequestMapping("/manage/system/user/avatar/add")
    public String userAvatarAdd(TbAvatar avatar,HttpServletRequest request) {
        userService.saveAvatar(avatar);
        return "redirect:/manage/system/user/avatarList";
    }
}
