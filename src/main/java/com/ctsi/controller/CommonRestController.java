package com.ctsi.controller;

import com.alibaba.fastjson.JSONObject;
import com.ctsi.entity.TbOrder;
import com.ctsi.rpc.BaiduRpc;
import com.ctsi.util.PageResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Description: 公共controller接口
 * @Author: Tianyu Xiao
 * @CreateDate: 2020/12/26  7:00
 */
@RestController
public class CommonRestController {

    //根据客户端ip获取地址详情
    @GetMapping("/api/address/detail")
    public HashMap getAddressByIp(String ip) {
        return BaiduRpc.getAddressByIp(ip);
    }

    //根据经纬度获取地址详情
    @GetMapping("/api/address/detail/xy")
    public String getAddressByXY(Float x,Float y) {
        HashMap result = BaiduRpc.getAddressByXY(x, y);
        JSONObject jsonObj = (JSONObject) result.get("result");
        String formattedAddress = (String) jsonObj.get("formatted_address");
        String business = (String) jsonObj.get("business");
        if(formattedAddress == null) {
            formattedAddress = "";
        }
        if(business == null) {
            business = null;
        }
        return formattedAddress.toString().concat(" ").concat(business);
    }

    //查询所有的订单
    @GetMapping("/order/listAll/status/{status}")
    public PageResult<TbOrder> getAllOrder(String status) {

        return null;
    }
}
