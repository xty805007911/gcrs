package com.ctsi.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName : TbOrderRating
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-31 14:30
 */
@Data
public class TbOrderRating {
    private Integer id;//orderid
    private Integer ratings;
    private String content;
    private Date createTime;
    private Integer userId;
    private Integer sendId;
}
