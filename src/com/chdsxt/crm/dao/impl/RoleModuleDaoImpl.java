package com.chdsxt.crm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.chdsxt.crm.dao.RoleModuleDao;
import com.chdsxt.crm.po.Role;
import com.chdsxt.crm.po.RoleModule;
import com.chdsxt.crm.util.HibUtil;

public class RoleModuleDaoImpl implements RoleModuleDao {

	public List<RoleModule> queryRoleModuleListByRoleId(Integer roleId) {
		Session session = HibUtil.getSession();
		Role role = (Role)session.get(Role.class, roleId);	
		return new ArrayList<RoleModule>(role.getRmSet());
	}

	public void addRoleModule(RoleModule roleModule) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(roleModule);
		tx.commit();
	}

	public void deleteRoleModule(RoleModule roleModule) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(roleModule);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public RoleModule queryRoleModuleByRoleAndModuleId(Integer roleId,
			Integer moduleId) {
		Session session = HibUtil.getSession();
		Query query = session.createQuery("	from RoleModule rm where rm.role.roleId=:roleId and rm.module.moduleId=:moduleId");
		query.setInteger("roleId",roleId );
		query.setInteger("moduleId", moduleId);
		List<RoleModule>  rmList = query.list();
		return (rmList!=null&&rmList.size()>0)?rmList.get(0):null;
	}

	public void updateRoleModule(RoleModule roleModule) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(roleModule);
		tx.commit();
	}

	public Integer queryLimitsByRoleAndModuleId(Integer roleId, Integer moduleId) {
		// TODO Auto-generated method stub
		RoleModule rm = queryRoleModuleByRoleAndModuleId(roleId,moduleId);
		return rm.getLimitsCode();
	}

}
