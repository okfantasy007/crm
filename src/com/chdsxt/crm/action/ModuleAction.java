package com.chdsxt.crm.action;

import java.util.List;
import java.util.Map;
import com.chdsxt.crm.po.Module;
import com.chdsxt.crm.po.User;
import com.chdsxt.crm.service.ModuleService;
import com.chdsxt.crm.service.RoleModuleService;
import com.chdsxt.crm.service.RoleService;
import com.chdsxt.crm.service.UserService;
import com.chdsxt.crm.service.impl.ModuleServiceImpl;
import com.chdsxt.crm.service.impl.RoleModuleServiceImpl;
import com.chdsxt.crm.service.impl.RoleServiceImpl;
import com.chdsxt.crm.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;

public class ModuleAction {
	private Integer roleId;
	private String roleName;
	private User user;
	private List<Module>  moduleList;
	private RoleService roleService = new RoleServiceImpl();
	private ModuleService  moduleService= new ModuleServiceImpl();
	private Map<Integer, Integer> moduleLimitsMap;
	private RoleModuleService roleModuleService = new RoleModuleServiceImpl();
	private UserService userService = new UserServiceImpl();
	
	public String queryModuleList(){
		System.out.println("----- ModuleAction queryModuleList -----");
		roleName = roleService.getRoleNameById(roleId);
		System.out.println("----- "+roleName+" -----");
		moduleList = moduleService.queryModuleList();
		moduleLimitsMap = roleModuleService.queryRoleModuleMapByRoleId(roleId);
		return "queryModuleList";
	}
	
	public String queryModuleListForScan(){
		System.out.println("----- ModuleAction queryModuleList -----");
		moduleList = moduleService.queryModuleList();
		moduleLimitsMap = roleModuleService.queryRoleModuleMapByRoleId(roleId);
		return "queryModuleListForScan";
	}
	
	public String queryModuleLimitsInfo(){
		System.out.println("----- ModuleAction queryModuleLimitsInfo -----");
		Map<String, Object>  session = ActionContext.getContext().getSession();
		Integer userId = (Integer)session.get("userId");
		user = userService.getUserById(userId);
		System.out.println("----- "+user.getPwdUpdTime()+" -----");
		moduleLimitsMap = roleModuleService.queryRoleModuleMapByRoleId(roleId);
		return "queryModuleLimitsInfo";
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Module> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}
	
	public ModuleService getModuleService() {
		return moduleService;
	}
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
	public Map<Integer, Integer> getModuleLimitsMap() {
		return moduleLimitsMap;
	}
	
	public void setModuleLimitsMap(Map<Integer, Integer> moduleLimitsMap) {
		this.moduleLimitsMap = moduleLimitsMap;
	}
	public RoleModuleService getRoleModuleService() {
		return roleModuleService;
	}
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setRoleModuleService(RoleModuleService roleModuleService) {
		this.roleModuleService = roleModuleService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
