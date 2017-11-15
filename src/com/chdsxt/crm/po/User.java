package com.chdsxt.crm.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@SuppressWarnings("serial")
public class User implements Serializable{
	private Integer userId;
	private String uname;
	private String pwd;
	private String email;
	private Timestamp registerTime;
	private Timestamp pwdUpdTime;
	private Set<Role> roleSet;
	
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getPwdUpdTime() {
		return pwdUpdTime;
	}
	public void setPwdUpdTime(Timestamp pwdUpdTime) {
		this.pwdUpdTime = pwdUpdTime;
	}
	
}
