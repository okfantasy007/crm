package com.chdsxt.crm.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoleModule implements Serializable{
	private Integer rmId;
	private Role role;
	private Module module;
	private Integer limitsCode;
	
	public Integer getRmId() {
		return rmId;
	}
	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}
	public Integer getLimitsCode() {
		return limitsCode;
	}
	public void setLimitsCode(Integer limitsCode) {
		this.limitsCode = limitsCode;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
