package com.chdsxt.crm.po;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@SuppressWarnings({ "serial", "unused" })
public class Type implements Serializable{
	private Integer typeId;
	private String typeName;
	private String typeDesc;
	private Timestamp typeCreateTime;
	private Timestamp typeUpdTime;
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public Timestamp getTypeCreateTime() {
		return typeCreateTime;
	}
	public void setTypeCreateTime(Timestamp typeCreateTime) {
		this.typeCreateTime = typeCreateTime;
	}
	public Timestamp getTypeUpdTime() {
		return typeUpdTime;
	}
	public void setTypeUpdTime(Timestamp typeUpdTime) {
		this.typeUpdTime = typeUpdTime;
	}
	
	
	
	
	
	
	
	
}
