package com.ctsi.config;

/**
 * @ClassName : Constant
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-09 19:16
 */
public class Constant {

    //分页条数
    public static final Integer PAGE_SIZE = 10;

    //订单状态
    public static final String ORDER_STATUS_NOT_SEND = "NOT_SEND";//未接单
    public static final String ORDER_STATUS_SENDING = "SENDING";//已接单，正在配送
    public static final String ORDER_STATUS_SUCCESS = "SUCCESS";//已完成
    public static final String ORDER_STATUS_CANCELED = "CANCELED";//已取消


}
