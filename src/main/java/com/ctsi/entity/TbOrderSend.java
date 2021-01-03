package com.ctsi.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName : TbOrderSend
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-31 14:22
 */
@Data
public class TbOrderSend {
    private Integer id;//orderid
    private Integer sendId;
    private String sendRealname;
    private Float pointX;
    private Float pointY;
    private Date sendStartTime;
    private Date sendEndTime;
    private String sendAddress;
    private String status;
}
