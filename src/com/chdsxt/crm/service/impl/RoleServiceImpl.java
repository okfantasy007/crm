package com.chdsxt.crm.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.chdsxt.crm.dao.RoleDao;
import com.chdsxt.crm.dao.impl.RoleDaoImpl;
import com.chdsxt.crm.po.Role;
import com.chdsxt.crm.service.RoleService;
import com.chdsxt.crm.vo.RoleVo;
import com.google.gson.Gson;

public class RoleServiceImpl implements RoleService{
	private RoleDao roleDao = new RoleDaoImpl();
	
	public String getRoleNameById(Integer roleId) {
		// TODO Auto-generated method stub
		return roleDao.queryRoleById(roleId).getRoleName();
	}
	
	public List<Role> queryRoleList(){
		return roleDao.queryRoleList();
	}
	
	public String queryRoleJsonArrayByUserId(Integer userId){
		List<Role> roleList = roleDao.queryRoleListByUserId(userId);
		List<RoleVo> roleVoList = new ArrayList<RoleVo>();
		for(int i = 0;i<roleList.size();i++){
			RoleVo r = new RoleVo();
			r.setRoleId(roleList.get(i).getRoleId());
			r.setRoleName(roleList.get(i).getRoleName());
			r.setRoleDesc(roleList.get(i).getRoleDesc());
			roleVoList.add(r);
		}
		return new Gson().toJson(roleVoList);
	}
	
	public Role findRoleById(Integer roleId){
		return roleDao.queryRoleById(roleId);
	}
	
	public RoleDao getRoleDao() {
		return roleDao;
	}
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
}
