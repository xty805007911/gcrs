package com.ctsi.controller;

import com.ctsi.entity.TbOrder;
import com.ctsi.service.TbOrderService;
import com.ctsi.util.PageResult;
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
    @RequestMapping("/order/user/detail/{userId}")
    public String getOrderDetailByUserId() {

        return "user/user-order-detail";
    }

    //查询用户订单
    @RequestMapping("/order/user/list")
    public String orderListForUser(HttpServletRequest request,TbOrder qbcOrder,Integer page) {
        //设置查询的用户id
        qbcOrder.setUserId(userRestController.getCurrentUser(request).getId());
        PageResult<TbOrder> pageResult = orderService.orderListForUserByPage(qbcOrder, page);
        request.setAttribute("pageResult",pageResult);
        return "user/user-order-list";
    }




}
