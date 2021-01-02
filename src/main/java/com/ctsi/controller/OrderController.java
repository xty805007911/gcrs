package com.ctsi.controller;

import com.ctsi.config.Constant;
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
        if(order.getReceiverMobile() == null || order.getReceiverMobile().trim().equals("")) {
            request.setAttribute("msg","联系方式不能为空");
            request.setAttribute("order",order);
            return "user/user-index";
        }

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

    //订单员接单
    @RequestMapping("/order/send/add")
    public String orderSendAdd(Integer orderId,HttpServletRequest request,Float pointX,Float pointY) {

        //1.未选择订单
        if(orderId == null) {
            request.setAttribute("msg","未选择订单~");
            return "send/send-index";
        }

        //2.由于并发被其他接单员接走了单子
        TbOrder order = orderService.getOrderById(orderId);
        if(!order.getStatus().equals(Constant.ORDER_STATUS_NOT_SEND)) {
            request.setAttribute("msg","订单已被抢走了~");
            return "send/send-index";
        }

        //3.接到了自己的单子
        Integer currentUserId = userRestController.getCurrentUser(request).getId();
        if(order.getUserId() == currentUserId) {
            request.setAttribute("msg","不能接自己的订单哦~");
            return "send/send-index";
        }

        orderService.addSendOrder(order,currentUserId,pointX,pointY);

        return "send/send-sending";
    }




}
