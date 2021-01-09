package com.ctsi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName : TbChat
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2021-01-08 15:39
 */
@Data
public class TbChat {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer fromUserId;
    private Integer toUserId;
    private String message;
    private Date createTime;

    @TableField(exist = false)
    private TbUser toUser;
    @TableField(exist = false)
    private TbUser fromUser;
    // html页面中class名称
    @TableField(exist = false)
    private String tplClass;
    @TableField(exist = false)
    private String time;

}
