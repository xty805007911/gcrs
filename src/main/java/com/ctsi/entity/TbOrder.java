package com.ctsi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TbOrder {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String orderCode;
	private Date createTime;
	/** 未接单、已接单、已完成、已取消 */
	private String status;
	private Integer userId;
	private Integer sendId;
	private String address;
	private Float pointX;
	private Float pointY;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	private String receiverName;
	private String receiverMobile;
	private String content;
	private Float kg;

}