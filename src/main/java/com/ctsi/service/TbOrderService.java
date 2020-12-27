package com.ctsi.service;

import com.ctsi.config.Constant;
import com.ctsi.controller.UserRestController;
import com.ctsi.entity.TbOrder;
import com.ctsi.mapper.TbOrderMapper;
import com.ctsi.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TbOrderService {

    @Autowired
    private TbOrderMapper tbOrderMapper;
    @Autowired
    private UserRestController userRestController;


    //添加一个新订单
    public void addOrder(TbOrder tbOrder) {

        //为订单设置编号
        tbOrder.setOrderCode(UUIDUtil.generateShortUuid().toUpperCase());
        //订单生成时间
        tbOrder.setCreateTime(new Date());
        //订单初始化，未接单状态
        tbOrder.setStatus(Constant.ORDER_STATUS_NOT_SEND);

        //保存
        tbOrderMapper.insert(tbOrder);
    }

    //根据用户id查询订单详情
    public TbOrder getOrderByUserId(Integer userId) {

        return null;
    }


}