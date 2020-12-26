package com.ctsi.controller;

import com.ctsi.rpc.BaiduRpc;
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
}
