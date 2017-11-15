package com.chdsxt.crm.po;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Role implements Serializable{
	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private Set<User> userSet;
	private Set<RoleModule> rmSet;
	
	public Set<RoleModule> getRmSet() {
		return rmSet;
	}
	public void setRmSet(Set<RoleModule> rmSet) {
		this.rmSet = rmSet;
	}
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
