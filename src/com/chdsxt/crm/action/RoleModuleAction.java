package com.chdsxt.crm.action;

import com.chdsxt.crm.service.RoleModuleService;
import com.chdsxt.crm.service.impl.RoleModuleServiceImpl;

public class RoleModuleAction {
	private Integer moduleId;
	private Integer roleId;
	private Integer limitsCode;
	private Integer flag;//0:取消     1：选中
	private RoleModuleService roleModuleService= new RoleModuleServiceImpl();
	
	public void updateLimitsCodeByRoleAndModuleId(){
		System.out.println("----- "+moduleId+" --- "+roleId+" --- "+limitsCode+" --- "+flag+" -----");
		roleModuleService.updateLimitsCodeByRoleAndModuleId(moduleId,roleId,limitsCode,flag);
	}
	
	public RoleModuleService getRoleModuleService() {
		return roleModuleService;
	}

	public void setRoleModuleService(RoleModuleService roleModuleService) {
		this.roleModuleService = roleModuleService;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getModuleId() {
		return moduleId;
	}
	
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public Integer getLimitsCode() {
		return limitsCode;
	}
	
	public void setLimitsCode(Integer limitsCode) {
		this.limitsCode = limitsCode;
	} 
}
