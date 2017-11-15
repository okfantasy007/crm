package com.chdsxt.crm.service;

import java.util.List;
import com.chdsxt.crm.po.User;

public interface UserService {
	public User getLoginValidate(User user);
	public List<User>  queryUserList();
	public void updateUserRole(Integer userId,Integer[] roleIds);
	public void updateUserPwd(User user,String userLoginPwd);
	public User getUserById(Integer UserId);
 }
