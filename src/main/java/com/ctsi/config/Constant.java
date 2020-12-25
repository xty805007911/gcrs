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

    //与tb_file_url关联的表名称
    public static final String FILE_TB_NAME_ACTIVE = "tb_active";
    public static final String FILE_TB_NAME_USER = "tb_user";

    //活动标签tag
    public static final String ACTIVITY_TAG_HOT = "hot";//热门
    public static final String ACTIVITY_TAG_RECOMMEND ="recommend";//推荐

    //活动状态
    public static final String ACTIVITY_STATUS_PENDING = "Pending";//活动等待开始
    public static final String ACTIVITY_STATUS_IN_PROGRESS = "In Progress";//活动在进行中
    public static final String ACTIVITY_STATUS_ON_HOLD = "On Hold";//活动已结束


    //时间格式化类型
    public static final String DATA_FORMAT_TYPE1 = "dd/MM/yyyy";
}
