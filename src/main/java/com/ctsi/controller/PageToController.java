package com.ctsi.controller;

import com.ctsi.entity.TbOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:页面跳转
 * @Author: Tianyu Xiao
 * @CreateDate: 2020/12/26  6:51
 */
@Controller
public class PageToController {
    @Autowired
    private OrderRestController orderRestController;
    @Autowired
    private UserRestController userRestController;

    //重定向的index页面
    @RequestMapping("/")
    public String toIndex() {
        return "redirect:/user/index";
    }

    //用户首页地图展示
    @RequestMapping("/user/index")
    public String userMapIndex(HttpServletRequest request) {
        request.setAttribute("order",new TbOrder());
        request.setAttribute("currentOrder",orderRestController.getUserCurrentOrder(request));
        request.setAttribute("msg","");
        return "user/user-index";
    }

    //用户订单详情
    @RequestMapping("/user/order/detail/{orderId}")
    public String userOrderDetail(HttpServletRequest request,@PathVariable Integer orderId) {
        request.setAttribute("orderId",orderId);
        return "user/user-order-detail";
    }

    //派单员订单详情
    @RequestMapping("/send/order/detail/{orderId}")
    public String sendOrderDetail(HttpServletRequest request,@PathVariable Integer orderId) {
        request.setAttribute("orderId",orderId);
        return "send/send-order-detail";
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

    //去注册页面
    @RequestMapping("/toRegister")
    public String toRegister(HttpServletRequest request) {
        request.setAttribute("msg","");
        return "register";
    }

    //管理员 去系统管理/头像添加
    @RequestMapping("/manage/system/user/avatar/toAdd")
    public String toUserAvatarAdd() {
        return "system-manage/avatar-add";
    }

    // 去聊天页面
    @RequestMapping("/chat/to/{toUserId}")
    public String toChat(HttpServletRequest request,@PathVariable Integer toUserId) {
        request.setAttribute("toUserId",toUserId);// test 5
        request.setAttribute("fromUserId",userRestController.getCurrentUser(request).getId());
        return "chat";
    }

}
