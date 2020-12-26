package com.ctsi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class TbUser {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String username;
	private String password;
	private String mobile;
	private String address;
	private Date createTime;
	private Integer enabled;
	private String avatar;
	private Integer roleId;
	private String realname;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	public Integer getEnabled() {
		return this.enabled;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getAvatar() {
		return this.avatar;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	public String getRealname() {
		return this.realname;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        TbUser that = (TbUser) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "TbUser{" +
				"id=" + id +
						",username='" + username + "'" + 
						",password='" + password + "'" + 
						",mobile='" + mobile + "'" + 
						",address='" + address + "'" + 
						",createTime='" + createTime + "'" + 
						",enabled='" + enabled + "'" + 
						",avatar='" + avatar + "'" + 
						",roleId='" + roleId + "'" + 
						",realname='" + realname + "'" + 
		                '}';
    }
	
}