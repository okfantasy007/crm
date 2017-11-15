package com.chdsxt.crm.dao;

import java.util.List;
import com.chdsxt.crm.po.RoleModule;

public interface RoleModuleDao {
	public List<RoleModule>  queryRoleModuleListByRoleId(Integer roleId);
	public RoleModule queryRoleModuleByRoleAndModuleId(Integer roleId,Integer moduleId);
	public void addRoleModule(RoleModule roleModule);
	public void updateRoleModule(RoleModule roleModule);
	public void deleteRoleModule(RoleModule roleModule);
	public Integer queryLimitsByRoleAndModuleId(Integer roleId, Integer moduleId);
}
