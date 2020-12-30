package com.ctsi.controller;

import com.ctsi.entity.TbOrder;
import com.ctsi.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Tianyu Xiao
 * @CreateDate: 2020/12/27  19:40
 */
@RestController
public class OrderRestController {

    @Autowired
    private TbOrderService orderService;

    //查询订单详情
    @GetMapping("/api/order/detail/{orderId}")
    public TbOrder getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

}
