package com.ctsi.controller;

import com.ctsi.entity.TbOrder;
import com.ctsi.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName : OrderController
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-26 14:46
 */
@Controller
public class OrderController {

    @Autowired
    private UserRestController userRestController;
    @Autowired
    private TbOrderService orderService;

    //保存新订单
    @RequestMapping("/order/add")
    public String saveOrder(TbOrder order, HttpServletRequest request) {
        Integer currentUserId = userRestController.getCurrentUser(request).getId();
        //设置当前下单者id
        order.setUserId(currentUserId);

        //保存数据
        orderService.addOrder(order);

        return "redirect:/";
    }

    //根据用户id查询订单详情
    @RequestMapping("/order/detail/user/{userId}")
    public String getOrderDetailByUserId() {

        return null;
    }


}
