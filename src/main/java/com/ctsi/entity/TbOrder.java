package com.ctsi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

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
	private Date startTime;
	private Date endTime;
	private String receiverName;
	private String receiverMobile;
	private String content;
	private Float kg;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	public String getOrderCode() {
		return this.orderCode;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	
	public Integer getSendId() {
		return this.sendId;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setPointX(Float pointX) {
		this.pointX = pointX;
	}
	
	public Float getPointX() {
		return this.pointX;
	}
	
	public void setPointY(Float pointY) {
		this.pointY = pointY;
	}
	
	public Float getPointY() {
		return this.pointY;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getStartTime() {
		return this.startTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}
	
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	public String getReceiverName() {
		return this.receiverName;
	}
	
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	
	public String getReceiverMobile() {
		return this.receiverMobile;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setKg(Float kg) {
		this.kg = kg;
	}
	
	public Float getKg() {
		return this.kg;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        TbOrder that = (TbOrder) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "TbOrder{" +
				"id=" + id +
						",orderCode='" + orderCode + "'" + 
						",createTime='" + createTime + "'" + 
						",status='" + status + "'" + 
						",userId='" + userId + "'" + 
						",sendId='" + sendId + "'" + 
						",address='" + address + "'" + 
						",pointX='" + pointX + "'" + 
						",pointY='" + pointY + "'" + 
						",startTime='" + startTime + "'" + 
						",endTime='" + endTime + "'" + 
						",receiverName='" + receiverName + "'" + 
						",receiverMobile='" + receiverMobile + "'" + 
						",content='" + content + "'" + 
						",kg='" + kg + "'" + 
		                '}';
    }
	
}