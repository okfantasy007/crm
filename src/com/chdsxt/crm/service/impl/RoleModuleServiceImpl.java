package com.chdsxt.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.chdsxt.crm.dao.ModuleDao;
import com.chdsxt.crm.dao.RoleDao;
import com.chdsxt.crm.dao.RoleModuleDao;
import com.chdsxt.crm.dao.impl.ModuleDaoImpl;
import com.chdsxt.crm.dao.impl.RoleDaoImpl;
import com.chdsxt.crm.dao.impl.RoleModuleDaoImpl;
import com.chdsxt.crm.po.Module;
import com.chdsxt.crm.po.RoleModule;
import com.chdsxt.crm.service.RoleModuleService;

public class RoleModuleServiceImpl implements RoleModuleService {
	
	private RoleModuleDao roleModuleDao = new RoleModuleDaoImpl();
	private RoleDao roleDao = new RoleDaoImpl();
	private ModuleDao  moduleDao= new ModuleDaoImpl();
	
	public Map<String, Integer> queryModuleLimitsMapByRoleId(Integer roleId) {
		System.out.println("----- RoleModuleServiceImpl -----");
		List<RoleModule> rmList = roleModuleDao.queryRoleModuleListByRoleId(roleId);
		System.out.println("----- "+rmList.size()+" -----");
		Map<String, Integer> map = new  HashMap<String, Integer>();
		 for(RoleModule rm:rmList){ 
			Module m =  moduleDao.queryModuleById(rm.getModule().getModuleId());
			System.out.println("----- "+m.getModuleId()+" -----");
			System.out.println("----- "+m.getModuleUrl()+" -----");
			if(m.getModuleUrl()!=null){
				System.out.println("----- queryModuleLimitsMapByRoleId "+m.getModuleUrl()+" -----");
				System.out.println("----- m.getModuleUrl() : "+m.getModuleUrl()+" -----");
				System.out.println("----- rm.getLimitsCode() : "+rm.getLimitsCode()+" -----");
				map.put(m.getModuleUrl(), rm.getLimitsCode());//装的键key是模块url，键值value是授权码
			}
		 }
		return map;
	}
	
	public Map<Integer, Integer> queryRoleModuleMapByRoleId(Integer roleId) {
		List<RoleModule>  rmList = roleModuleDao.queryRoleModuleListByRoleId(roleId);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for(RoleModule rm:rmList){
			 map.put(rm.getModule().getModuleId(),rm.getLimitsCode());
		 }
		return map;
	}
	
	/**1:先根据   roleId  和    moduleId 去  crm_Role_Module 查对应数据
	 * 	没有  有
	 * if(flag==1){
	 * 	  if(表中无数据){
	 * 			往中间表查一条记录   对应 code 码直接填进去就行
	 * 		}else{
	 * 			就用位或操作即可
	 * 		}
	 * }else if(flag=0){
	 * 		if(码 == 对应的记录的码){
	 * 			删除记录
	 * 		}else{
	 * 			就用异或操作即可
	 * 		}
	 * }
	 */
	public void updateLimitsCodeByRoleAndModuleId(Integer moduleId,
			Integer roleId, Integer limitsCode, Integer flag) {
		RoleModule rm = roleModuleDao.queryRoleModuleByRoleAndModuleId(roleId, moduleId);
		if(flag==1){//flag=1表示勾选当前勾选框
			/*
			 * 如果原来没有找到对应角色和模块的rm记录
			 * 但是又有变化
			 * 则需要插入新的权限
			 */
			if(rm==null){
				RoleModule newRm = new RoleModule();
				newRm.setRole(roleDao.queryRoleById(roleId));
				newRm.setModule(moduleDao.queryModuleById(moduleId));
				newRm.setLimitsCode(limitsCode);
				roleModuleDao.addRoleModule(newRm);
			}else{
				System.out.println("----- "+limitsCode+" : "+rm.getLimitsCode()+" -----");
				System.out.println("----- "+(limitsCode|rm.getLimitsCode())+" -----");
				rm.setLimitsCode(limitsCode|rm.getLimitsCode());
				roleModuleDao.updateRoleModule(rm);
			}
		}else if(flag==0){//flag=0表示取消当前勾选框
			if(rm!=null){
				if(rm.getLimitsCode().intValue() == limitsCode.intValue()){
					//对应原来只有一个勾，后来又把这个勾取消了的情况
					roleModuleDao.deleteRoleModule(rm);
				 }else{
					 //对应原来不止有一个勾的情况
					 System.out.println("----- "+limitsCode+" : "+rm.getLimitsCode()+" -----");
					 System.out.println("----- "+(limitsCode^rm.getLimitsCode())+" -----");
					 rm.setLimitsCode(limitsCode^rm.getLimitsCode());
					 roleModuleDao.updateRoleModule(rm);
				}
			}
		}
	}
	
	public RoleModuleDao getRoleModuleDao() {
		return roleModuleDao;
	}
	
	public void setRoleModuleDao(RoleModuleDao roleModuleDao) {
		this.roleModuleDao = roleModuleDao;
	}
	
	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public ModuleDao getModuleDao() {
		return moduleDao;
	}

	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

}
