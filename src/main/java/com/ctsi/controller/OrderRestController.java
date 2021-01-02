package com.ctsi.controller;

import com.ctsi.entity.TbOrder;
import com.ctsi.service.TbOrderService;
import com.ctsi.util.PageResult;
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

    //分页查询订单列表
    @GetMapping("/api/order/pageList/status/{status}")
    public PageResult<TbOrder> getOrderList(@PathVariable String status,Integer page) {
        return orderService.getOrderPageListByStatus(status,page,20);
    }


}
