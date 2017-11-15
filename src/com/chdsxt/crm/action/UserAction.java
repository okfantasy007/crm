package com.chdsxt.crm.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.chdsxt.crm.po.User;
import com.chdsxt.crm.service.UserService;
import com.chdsxt.crm.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	public List<User> userList;
	private UserService userService = new UserServiceImpl();
	private Integer[] roleIds;
	private User user;
	private String password;
	private String errMessage;
	private String chkCodeMessage;
	private String userOrgnalPwd;
	private String chkCode;
	private String userLoginPwd;
	private Timestamp pwdUpdTime;
	private Integer userId;
	
	public String queryUserList(){
		userList = userService.queryUserList();
		return "queryUserList";
	}
	
	public String updateUserPwd(){
		System.out.println("----- UserAction updateUserPwd -----");
		Map<String, Object>  session = ActionContext.getContext().getSession();
		String chkResult = (String)session.get("sRand");
		Integer updUserId = (Integer)session.get("userId");
		System.out.println("----- 图片验证码为："+chkResult+" -----");
		System.out.println("----- 用户ID为："+updUserId+" -----");
		System.out.println("----- 密码更改时间为："+pwdUpdTime+" -----");
		if(chkCode!=null&&!"".equals(chkCode.trim())){
				System.out.println("----- 从页面上输入的验证码为："+chkCode+" -----");
				if(chkCode.toLowerCase().equals(chkResult.toLowerCase())){
					System.out.println("----- 用户在页面上输入的原始密码为："+userOrgnalPwd.trim()+" -----");
					System.out.println("----- 实际上用户的原始密码为："+userLoginPwd.trim()+" -----");
					System.out.println("----- 页面上输入的新密码为："+password+" -----");
					if(userLoginPwd.trim().equals(userOrgnalPwd.trim())){
						if(password.trim().equals(userLoginPwd.trim())){
							errMessage = "用户新密码与原密码相同，请重新输入";
							return "updatePwd";
						}else{
							User updPwdUser = new User();
							updPwdUser.setPwd(password);
							updPwdUser.setUserId(updUserId);
							updPwdUser.setPwdUpdTime(pwdUpdTime);
							user = userService.getUserById(updUserId);
							userService.updateUserPwd(updPwdUser,userLoginPwd);
							return "updPwdSuccess";
						}	
					}else{
						errMessage = "用户原始密码输入错误，请重新输入";
						return "updatePwd";
					}
				}else{
					chkCodeMessage = "验证码错误";
					return "updatePwd";
				}
		}else{
			chkCodeMessage = "验证码不能为空";
			return "updatePwd";
		}
	}
	
	public String getUserInfoById(){
		System.out.println("----- UserAction getUserInfoById -----");
		user = userService.getUserById(userId);
		return "getUserInfoById";	
	}
	
	public String updateUserRole(){
		userService.updateUserRole(user.getUserId(),roleIds);
		return queryUserList();
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Integer[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}
	
	public List<User> getUserList() {
		return userList;
	}
	
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public String getChkCodeMessage() {
		return chkCodeMessage;
	}

	public void setChkCodeMessage(String chkCodeMessage) {
		this.chkCodeMessage = chkCodeMessage;
	}

	public String getUserOrgnalPwd() {
		return userOrgnalPwd;
	}

	public void setUserOrgnalPwd(String userOrgnalPwd) {
		this.userOrgnalPwd = userOrgnalPwd;
	}

	public String getChkCode() {
		return chkCode;
	}

	public void setChkCode(String chkCode) {
		this.chkCode = chkCode;
	}

	public String getUserLoginPwd() {
		return userLoginPwd;
	}

	public void setUserLoginPwd(String userLoginPwd) {
		this.userLoginPwd = userLoginPwd;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getPwdUpdTime() {
		return pwdUpdTime;
	}

	public void setPwdUpdTime(Timestamp pwdUpdTime) {
		this.pwdUpdTime = pwdUpdTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
