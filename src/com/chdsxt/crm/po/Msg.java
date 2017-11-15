package com.chdsxt.crm.po;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@SuppressWarnings({ "serial", "unused" })
public class Msg implements Serializable{
	private Integer msgId;
	private String msgName;
	private String msgContent;
	private Timestamp msgCreateTime;
	private String msgAuthor;
	
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getMsgName() {
		return msgName;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public Timestamp getMsgCreateTime() {
		return msgCreateTime;
	}
	public void setMsgCreateTime(Timestamp msgCreateTime) {
		this.msgCreateTime = msgCreateTime;
	}
	public String getMsgAuthor() {
		return msgAuthor;
	}
	public void setMsgAuthor(String msgAuthor) {
		this.msgAuthor = msgAuthor;
	}
	
	
	
	
}
