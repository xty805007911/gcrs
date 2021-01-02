package com.ctsi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctsi.config.Constant;
import com.ctsi.controller.UserRestController;
import com.ctsi.entity.TbOrder;
import com.ctsi.entity.TbOrderSend;
import com.ctsi.mapper.TbOrderMapper;
import com.ctsi.mapper.TbOrderSendMapper;
import com.ctsi.mapper.TbUserMapper;
import com.ctsi.util.PageResult;
import com.ctsi.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TbOrderService {

    @Autowired
    private TbOrderMapper tbOrderMapper;
    @Autowired
    private UserRestController userRestController;
    @Autowired
    private TbOrderSendMapper orderSendMapper;
    @Autowired
    private TbUserMapper userMapper;


    //添加一个新订单
    public void addOrder(TbOrder tbOrder) {

        //为订单设置编号
        tbOrder.setOrderCode(UUIDUtil.generateShortUuid().toUpperCase());
        //订单生成时间
        Date currentDate = new Date();
        tbOrder.setCreateTime(currentDate);
        tbOrder.setStartTime(currentDate);
        if(tbOrder.getEndTime() == null) {
            tbOrder.setEndTime(currentDate);
        }
        //订单初始化，未接单状态
        tbOrder.setStatus(Constant.ORDER_STATUS_NOT_SEND);

        //保存
        tbOrderMapper.insert(tbOrder);
    }

    //接单员添加订单
    @Transactional
    public void addSendOrder(TbOrder order,Integer currentUserId,Float pointX,Float pointY) {
        order.setStatus(Constant.ORDER_STATUS_SENDING);//修改为正在配送的状态
        tbOrderMapper.updateById(order);

        //添加接单信息
        TbOrderSend orderSend = new TbOrderSend();
        orderSend.setId(order.getId());//orderSend的id就是order的id
        orderSend.setSendStartTime(new Date());
        orderSend.setSendId(currentUserId);
        orderSend.setPointX(pointX);
        orderSend.setPointY(pointY);
        orderSend.setSendRealname(userMapper.selectById(currentUserId).getRealname());
        orderSendMapper.insert(orderSend);

    }

    // 根据id查询订单
    public TbOrder getOrderById(Integer orderId) {
        TbOrder tbOrder = tbOrderMapper.selectById(orderId);
        //查询下单者
        return tbOrder;
    }

    //根据条件分页查询，查询用户的订单
    public PageResult<TbOrder> orderListForUserByPage(TbOrder qbcOrder,Integer page) {

        if(page == null || page<=0) {
            page = 1;
        }
        PageHelper.startPage(page,Constant.PAGE_SIZE);
        QueryWrapper<TbOrder> queryWrapper = new QueryWrapper<>();
        if(qbcOrder.getStatus() != null ) {
            queryWrapper.eq("status",qbcOrder.getStatus());
        }
        queryWrapper.eq("user_id",qbcOrder.getUserId());
        queryWrapper.orderByDesc("create_time");
        List<TbOrder> orderList = tbOrderMapper.selectList(queryWrapper);
        PageInfo<TbOrder> pageInfo = new PageInfo<>(orderList);
        PageResult<TbOrder> pageResult = new PageResult<>(pageInfo);
        return pageResult;
    }

    //根据状态查询所有订单
    public PageResult<TbOrder> getOrderPageListByStatus(String status,Integer page,Integer size) {
        if(page == null || page <= 0) {
            page = 1;
        }

        PageHelper.startPage(page,size);
        QueryWrapper<TbOrder> queryWrapper = new QueryWrapper<>();

        //如果不是查询所有，则根据状态码查询
        if(!status.equals("all")) {
            queryWrapper.eq("status",status);
        }

        queryWrapper.orderByDesc("id");
        List<TbOrder> orderList = tbOrderMapper.selectList(queryWrapper);

        PageInfo<TbOrder> pageInfo = new PageInfo<>(orderList);
        PageResult<TbOrder> pageResult = new PageResult<>(pageInfo);

        return pageResult;
    }



}