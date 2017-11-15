package com.chdsxt.crm.dao.impl;

import java.util.HashSet;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.chdsxt.crm.dao.UserDao;
import com.chdsxt.crm.po.Role;
import com.chdsxt.crm.po.User;
import com.chdsxt.crm.util.HibUtil;
import com.chdsxt.crm.util.MD5Util;

@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao {
	
	public User getLoginValidate(User user){
		Session session = HibUtil.getSession();
		Query query = session.createQuery("from User u where u.uname=:uname and u.pwd=:pwd");
		query.setString("uname", user.getUname());
		query.setString("pwd", user.getPwd());
		List<User> userList = query.list();
		return (userList!=null&userList.size()>0)?userList.get(0):null;
	}
	
	public List<User> queryUserList(){
		Session session = HibUtil.getSession();
		Query query = session.createQuery(" from User u order by userId ");
		List<User> userList = query.list();
		return userList;
	}
	
	public void updateUserRole(Integer userId,Integer[] roleIds){
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		User u = (User)session.get(User.class,userId);
		/*
		 * 每次更新对应用户的roleSet都需要先将之前的roleSet完全清除
		 * 然后再根据从授权页面获取的roleIds遍历每个roleId
		 * 对应的角色再重新装入roleSet中
		 */
		u.getRoleSet().clear();
		HashSet<Role> roleSet = new HashSet<Role>();
		for(int i = 0;i<roleIds.length;i++){
			Role r = (Role)session.get(Role.class,roleIds[i]);
			roleSet.add(r);
		}
		u.setRoleSet(roleSet);
		tx.commit();
	}

	public void updateUserPwd(User user,String userLoginPwd) {
		// TODO Auto-generated method stub
		//User updUser = getUserById(user.getUserId());
		System.out.println("----- UserDaoImpl updateUserPwd -----");
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		User updUser = (User)session.get(User.class, user.getUserId());
		System.out.println("----- 原密码 : "+userLoginPwd+" -----");
		System.out.println("----- 新密码 : "+user.getPwd()+" -----");
		updUser.setPwd(MD5Util.convertToMD5(user.getPwd()));
		updUser.setPwdUpdTime(user.getPwdUpdTime());
		session.update(updUser);
		tx.commit();
	}
	
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		Session session = HibUtil.getSession();
		Query query = session.createQuery("from User u where u.userId=:userId");
		query.setInteger("userId", userId);
		List<User> userList = query.list();
		return (userList!=null&userList.size()>0)?userList.get(0):null;
	}

}
