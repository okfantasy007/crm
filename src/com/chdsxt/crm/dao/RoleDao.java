package com.chdsxt.crm.dao;

import java.util.List;
import com.chdsxt.crm.po.Role;

public interface RoleDao {
	public List<Role> queryRoleList();
	public List<Role> queryRoleListByUserId(Integer userId);
	public Role queryRoleById(Integer roleId);
}
