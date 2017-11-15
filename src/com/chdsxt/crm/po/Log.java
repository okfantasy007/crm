package com.chdsxt.crm.po;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@SuppressWarnings({ "serial", "unused" })
public class Log implements Serializable{
	private Integer logId;
	private String logName;
	private String logContent;
	private Timestamp logCreateTime;
	private String logAuthor;
	private Timestamp logUpdTime;
	
	public Integer getLogId() {
		return logId;
	}
	
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	
	public String getLogName() {
		return logName;
	}
	
	public void setLogName(String logName) {
		this.logName = logName;
	}
	
	public String getLogContent() {
		return logContent;
	}
	
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public Timestamp getLogCreateTime() {
		return logCreateTime;
	}

	public void setLogCreateTime(Timestamp logCreateTime) {
		this.logCreateTime = logCreateTime;
	}

	public String getLogAuthor() {
		return logAuthor;
	}

	public void setLogAuthor(String logAuthor) {
		this.logAuthor = logAuthor;
	}

	public Timestamp getLogUpdTime() {
		return logUpdTime;
	}

	public void setLogUpdTime(Timestamp logUpdTime) {
		this.logUpdTime = logUpdTime;
	}
	
	

	
	
	
	
	
	
	
}
