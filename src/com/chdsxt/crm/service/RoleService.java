package com.chdsxt.crm.service;

import java.util.List;
import com.chdsxt.crm.po.Role;

public interface RoleService {
	public List<Role> queryRoleList();
	public String queryRoleJsonArrayByUserId(Integer userId);
	public Role findRoleById(Integer roleId);
	public String getRoleNameById(Integer roleId);
}
