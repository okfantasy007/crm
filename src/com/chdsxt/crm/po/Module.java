package com.chdsxt.crm.po;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Module implements Serializable{
	private Integer moduleId;
	private String moduleCode;
	private String moduleName;
	private String moduleUrl;
	private Set<RoleModule> rmSet;
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleUrl() {
		return moduleUrl;
	}
	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}
	public Set<RoleModule> getRmSet() {
		return rmSet;
	}
	public void setRmSet(Set<RoleModule> rmSet) {
		this.rmSet = rmSet;
	}
}
