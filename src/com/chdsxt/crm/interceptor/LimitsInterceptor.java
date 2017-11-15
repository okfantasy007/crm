package com.chdsxt.crm.interceptor;

import java.util.Map;
import com.chdsxt.crm.po.Role;
import com.chdsxt.crm.service.RoleModuleService;
import com.chdsxt.crm.service.impl.RoleModuleServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class LimitsInterceptor extends AbstractInterceptor{

	private RoleModuleService roleModuleService = new RoleModuleServiceImpl();

	@Override
	public String intercept(ActionInvocation invoke) throws Exception {
		System.out.println("----- LimitsInterceptor -----");
		String actionName = invoke.getProxy().getActionName();
		System.out.println("----- LimitsInterceptor --- actionName : "+actionName+" -----");
		String method = invoke.getProxy().getMethod();
		System.out.println("----- LimitsInterceptor --- method : "+method+" -----");
		Map<String, Object>  session = ActionContext.getContext().getSession();		
		//Map<String, Integer> limitsMap = (Map<String, Integer>) session.get("limitsMap");
		Role role = (Role)session.get("loginRole");
		if("loginAction".equals(actionName)||"userAction".equals(actionName)||"moduleAction".equals(actionName)){
			System.out.println("----- 1 : "+actionName+" -----");
			invoke.invoke();
		}else{
			if("roleAction".equals(actionName)
				||"roleModuleAction".equals(actionName)
				||"logAction".equals(actionName)
				||"typeAction".equals(actionName)
				||"messageAction".equals(actionName)
				||"xlsExpAction".equals(actionName)
					){
				System.out.println("----- LimitsInterceptor actionName : "+actionName+" -----");
				Map<String, Integer> limitsMap = roleModuleService.queryModuleLimitsMapByRoleId(role.getRoleId());
				Integer limitsCode = limitsMap.get(actionName);
				System.out.println("----- LimitsInterceptor --- limitsCode : "+limitsCode+" -----");
				session.put("limitsCode", limitsCode);
				if(limitsMap==null){
					System.out.println("----- 2 -----");
					return "login";
				}else{
					if(role.getRoleId()==1){
						invoke.invoke();
					}else{
						if(limitsCode==null){
							System.out.println("----- 3 -----");
							return "nopower";
						}else{
							if(method.startsWith("add")){
								if((limitsCode&8)==8){
									System.out.println("----- 4 -----");
									invoke.invoke();
								}else{
									System.out.println("----- 5 -----");
									return "nopower";
								}
							}else if(method.startsWith("query")||method.startsWith("get")){
								if((limitsCode&4)==4){
									System.out.println("----- 6 -----");
									invoke.invoke();
								}else{
									System.out.println("----- 7 -----");
									return "nopower";
								}
							}else if(method.startsWith("update")){
								if((limitsCode&2)==2){
									System.out.println("----- 8 -----");
									invoke.invoke();
								}else{
									System.out.println("----- 9 -----");
									return "nopower";
								}
							}else if(method.startsWith("del")){
								if((limitsCode&1)==1){
									System.out.println("----- 10 -----");
									invoke.invoke();
								}else{
									System.out.println("----- 11 -----");
									return "nopower";
								}
							}
						}
					}	
				}
			}else{
				System.out.println("----- 12 -----");
				return "nopower";
			}
		}
		return null;
	}

	public RoleModuleService getRoleModuleService() {
		return roleModuleService;
	}

	public void setRoleModuleService(RoleModuleService roleModuleService) {
		this.roleModuleService = roleModuleService;
	}

	
}
