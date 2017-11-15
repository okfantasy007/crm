package com.chdsxt.crm.service.impl;

import java.util.List;
import com.chdsxt.crm.dao.UserDao;
import com.chdsxt.crm.dao.impl.UserDaoImpl;
import com.chdsxt.crm.po.User;
import com.chdsxt.crm.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();

	public User getLoginValidate(User user) {
		// TODO Auto-generated method stub
		return userDao.getLoginValidate(user);
	}
	
	public User getUserById(Integer UserId) {
		// TODO Auto-generated method stub
		return userDao.getUserById(UserId);
	}

	public List<User> queryUserList() {
		// TODO Auto-generated method stub
		return userDao.queryUserList();
	}
	
	public void updateUserRole(Integer userId,Integer[] roleIds){
		userDao.updateUserRole(userId,roleIds);
	}

	public void updateUserPwd(User user,String userLoginPwd) {
		// TODO Auto-generated method stub
		userDao.updateUserPwd(user,userLoginPwd);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
