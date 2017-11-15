package com.chdsxt.crm.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.chdsxt.crm.service.RoleService;
import com.chdsxt.crm.service.impl.RoleServiceImpl;

public class RoleAction {
	private Integer userId;
	private InputStream inputStream;
	private RoleService roleService = new RoleServiceImpl();
	
	public String queryRoleJsonArrayByUserId() throws UnsupportedEncodingException{
		String result = roleService.queryRoleJsonArrayByUserId(userId);
		inputStream= new ByteArrayInputStream(result.getBytes("utf-8"));
		return "roleJsonArray";
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
