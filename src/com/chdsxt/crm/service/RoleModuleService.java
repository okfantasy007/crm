package com.chdsxt.crm.service;

import java.util.Map;

public interface RoleModuleService {
	public Map<Integer, Integer> queryRoleModuleMapByRoleId(Integer roleId);
	public Map<String, Integer> queryModuleLimitsMapByRoleId(Integer roleId);
	public void updateLimitsCodeByRoleAndModuleId(Integer moduleId,Integer roleId,Integer limitsCode,Integer flag);
}
