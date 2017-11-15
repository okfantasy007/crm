package com.chdsxt.crm.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.chdsxt.crm.po.Menu;
import com.chdsxt.crm.po.Module;
import com.chdsxt.crm.po.Role;
import com.chdsxt.crm.po.User;
import com.chdsxt.crm.service.MenuService;
import com.chdsxt.crm.service.ModuleService;
import com.chdsxt.crm.service.RoleModuleService;
import com.chdsxt.crm.service.RoleService;
import com.chdsxt.crm.service.UserService;
import com.chdsxt.crm.service.impl.MenuServiceImpl;
import com.chdsxt.crm.service.impl.ModuleServiceImpl;
import com.chdsxt.crm.service.impl.RoleModuleServiceImpl;
import com.chdsxt.crm.service.impl.RoleServiceImpl;
import com.chdsxt.crm.service.impl.UserServiceImpl;
import com.chdsxt.crm.util.MD5Util;
import com.opensymphony.xwork2.ActionContext;

/**
 * 登陆进来 验证 用户名 和密码 验证码 if(验证码!=null){ if(uname&&pwd！=null){ 查数据库 返回一个 user对象
 * if(user!=null){ 跳转到main.jsp }else{ unameAndPwdMess="用户名密码错误"; 跳转到登陆页面; }
 * }else{ 跳转到登陆页面; unameAndPwdMess="不能为空"; } }else{ 跳转到登陆页面;
 * chkNumberMsgNull="不能为空"; }
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("unused")
public class LoginAction {
	private UserService userService = new UserServiceImpl();
	private RoleService roleService = new RoleServiceImpl();
	private User user;
	private String userMessage;
	private String chkNumberMessage;
	private String chknumber;
	private Integer roleId;
	private List<Role> roleListToLoginUser = new ArrayList<Role>();
	private Integer rListLenToLoginUser;
	private Map<String, Integer>  limitsMap;
	private Map<Integer,Integer> limitsAndModuleMap;
	private MenuService menuService = new MenuServiceImpl();
	private RoleModuleService roleModuleService = new RoleModuleServiceImpl();
	private ModuleService moduleService = new ModuleServiceImpl();
	
	public String getLoginValidate(){
		Map<String, Object>  session = ActionContext.getContext().getSession();
		/*
		 * 在image.jsp中已经将rand装入到session中
		 * 将认证码存入session
		 * session.setAttribute("rand",sRand); 
		 * chknumber为从index.jsp中获取的输入的验证码
		 * 将其与系统自动生成的验证码进行比对 
		 */
		String chkResult = (String)session.get("rand");
		if(chknumber!=null&&!"".equals(chknumber.trim())){
					if(chknumber.toLowerCase().equals(chkResult.toLowerCase())){
						if(user.getUname()!=null&&user.getPwd()!=null&&!"".equals(user.getUname().trim())
								&&!"".equals(user.getPwd().trim())){
							//密码加密
							String userLoginPwd = user.getPwd().trim();
							user.setPwd(MD5Util.convertToMD5(user.getPwd()));
							User userResult = userService.getLoginValidate(user);
				  			if(userResult!=null){
				  				session.put("userId", userResult.getUserId());
				  				session.put("userName",userResult.getUname());	
				  				session.put("userLoginPwd", userLoginPwd);
				  				List<Module> moduleList = moduleService.queryModuleList();
				  				 /*
				  				 * 去service 内 调用二个方法  获取当前用户 对应的菜单权限
				  				 * 根据roleId获取当前用户应该在main.jsp上显示的菜单
				  				 */
				  				if(roleId!=null){
				  					Role loginRole = roleService.findRoleById(roleId);
				  					session.put("loginRole", loginRole);
				  					Set<Role> roleSet = new HashSet<Role>();
				  					roleSet = (Set<Role>) userResult.getRoleSet();
				  					boolean flag = false;
				  					for (Role role : roleSet) {
										System.out.println("----- "+role.getRoleName()+" -----");
										if(role.getRoleId()==roleId){
											flag = true;
										}
										roleListToLoginUser.add(role);
									}
				  					System.out.println("---- flag : "+flag+" -----");
				  					if(flag){
				  						List<Menu>  menuList = menuService.queryMenuListByRoleId(roleId);
						  				/*limitsMap = roleModuleService.queryModuleLimitsMapByRoleId(roleId);
						  				limitsAndModuleMap = roleModuleService.queryRoleModuleMapByRoleId(roleId);;*/
						  				rListLenToLoginUser = userResult.getRoleSet().size();
						  				 /* 
						  				  * 此处不应该将登陆用户对应角色的访问权限装入map中
						  				 * 然后装入session中
						  				 * 如下所示：
						  				 * limitsMap = roleModuleService.queryModuleLimitsMapByRoleId(roleId);
						  				 * 上述limitsMap就是根据登陆用户以及登陆角色获取的权限map
						  				 * 应该考虑到授权是对不同角色进行授权
						  				 * session.put("limitsMap", limitsMap);
						  				 * 授权的时候应该是对每个角色都可以授权
						  				 * 所以需要根据角色roleId进行授权
						  				 * 需要在moduleAction中装moduleLimitsMap
						  				 * 这个moduleLimitsMap是对应每个roleId的不同的权限
						  				 * 也不能把moduleLimitsMap放入session中
						  				 * 因为随着授权的进行，角色对应模块的权限也会发生动态变化
						  				 * 因此每次都需要查询数据库的limitsCode
						  				 * 返回到jsp页面时哪些功能或菜单应该出现在页面上需要根据这个动态的
						  				 * 随时可能发生变化的limitsCode进行判断
						  				 * */
						  				session.put("roleListToLoginUser", roleListToLoginUser);
						  				session.put("rListLenToLoginUser", rListLenToLoginUser);
						  				/*session.put("limitsMap", limitsMap);
						  				session.put("limitsAndModuleMap",limitsAndModuleMap);*/
						  				session.put("menuList", menuList);
						  				session.put("moduleList", moduleList);
						  				return "main";
				  					}else{
				  						userMessage = "该用户不能使用角色 : "+loginRole.getRoleName()+"  登陆";
				  						return "login";
				  					}
				  				}else{
				  					userMessage="没有选择角色";
				  					return "login";
				  				}
				 			}else{
				 				userMessage="用户名密码错误";
				  				return "login";
				 			}
				  		}else{
				  			userMessage="用户名和密码不能为空";
				  			return "login";
				  		}
					}else{
						chkNumberMessage="验证码不正确";
				  		return "login";
					}
			 }else{
				    chkNumberMessage="验证码不能为空";
			  		return "login";
			 }
	}
	
	public RoleModuleService getRoleModuleService() {
		return roleModuleService;
	}

	public void setRoleModuleService(RoleModuleService roleModuleService) {
		this.roleModuleService = roleModuleService;
	}

	public Map<String, Integer> getLimitsMap() {
		return limitsMap;
	}

	public void setLimitsMap(Map<String, Integer> limitsMap) {
		this.limitsMap = limitsMap;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getChknumber() {
		return chknumber;
	}

	public void setChknumber(String chknumber) {
		this.chknumber = chknumber;
	}
	public User getUser() {
		return user;
	}

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getChkNumberMessage() {
		return chkNumberMessage;
	}

	public void setChkNumberMessage(String chkNumberMessage) {
		this.chkNumberMessage = chkNumberMessage;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	public Map<Integer, Integer> getLimitsAndModuleMap() {
		return limitsAndModuleMap;
	}

	public void setLimitsAndModuleMap(Map<Integer, Integer> limitsAndModuleMap) {
		this.limitsAndModuleMap = limitsAndModuleMap;
	}

	public List<Role> getRoleListToLoginUser() {
		return roleListToLoginUser;
	}

	public void setRoleListToLoginUser(List<Role> roleListToLoginUser) {
		this.roleListToLoginUser = roleListToLoginUser;
	}

	public Integer getrListLenToLoginUser() {
		return rListLenToLoginUser;
	}

	public void setrListLenToLoginUser(Integer rListLenToLoginUser) {
		this.rListLenToLoginUser = rListLenToLoginUser;
	}
	
	
	
	
	
	
}
