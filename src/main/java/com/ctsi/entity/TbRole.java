package com.ctsi.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class TbRole {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String name;
	private String code;
	private String enabled;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	public String getEnabled() {
		return this.enabled;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        TbRole that = (TbRole) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "TbRole{" +
				"id=" + id +
						",name='" + name + "'" + 
						",code='" + code + "'" + 
						",enabled='" + enabled + "'" + 
		                '}';
    }
	
}