package com.chdsxt.crm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.chdsxt.crm.dao.RoleDao;
import com.chdsxt.crm.po.Role;
import com.chdsxt.crm.po.User;
import com.chdsxt.crm.util.HibUtil;

public class RoleDaoImpl implements RoleDao{
	
	@SuppressWarnings("unchecked")
	public List<Role> queryRoleList() {
		Session session = HibUtil.getSession();
		Query query = session.createQuery(" from Role r order by roleId ");
		List<Role> roleList = query.list();
		return roleList;
	}

	public List<Role> queryRoleListByUserId(Integer userId) {
		Session session = HibUtil.getSession();
		User u = (User)session.get(User.class, userId);
		return new ArrayList<Role>(u.getRoleSet());
	}

	public Role queryRoleById(Integer roleId) {
		Session session = HibUtil.getSession();
		return (Role) session.get(Role.class, roleId);
	}
	
}
