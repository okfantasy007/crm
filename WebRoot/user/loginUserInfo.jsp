<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="s"  uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'queryUserList.jsp' starting page</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="util/jquery-1.8.3.js"  ></script>
	<script type="text/javascript" src="util/wbox/jquery1.4.2.js"  ></script>
    <script type="text/javascript" src="util/wbox/wbox-min.js"  ></script>
    <link rel="stylesheet" type="text/css" href="util/wbox/wbox/wbox-min.css">
	
	<script type="text/javascript">
			var wbox;
    		function queryLimitsByRole(roleId){
    		var roleName = $("#curRoleName_"+roleId).val();//注意这里运用jquery获取roleName的方法
				 wbox = $().wBox({
				     title: "查看角色 ："+roleName+" 的权限",
					 requestType: "iframe",
					 iframeWH:{width:500,height:125},
					 target:"moduleAction!queryModuleListForScan.do?roleId="+roleId
					});
				 wbox.showBox();
			}
	</script>
  </head>
  
  <body>
   			 <table   id="t1"  width="100%" border=1>
   			 	<tr>
    				<td colspan="7" style="border: none;text-align: center">----------- 查看用户信息 -----------</td>
    			</tr>
    	 		<tr>
    	 			<td style="text-align: center" rowspan="${session.rListLenToLoginUser+3 }">当前登陆用户</td>
    	 			<th colspan="1">用户名称</th>
	    	 		<th colspan="1">邮箱</th>
	    	 		<th colspan="2">注册时间</th>
	    	 		<th colspan="2">密码更改时间</th>
    	 		</tr>	
    	 		<tr>
    	 			<td style="text-align: center" colspan="1"><s:property value="user.uname"/></td>
    	 			<td style="text-align: center" colspan="1"><s:property value="user.email"/></td>
    	 			<td style="text-align: center" colspan="2"><s:date name="user.registerTime" format="yyyy-MM-dd HH:mm:ss"/></td>
    	 			<td style="text-align: center" colspan="2"><s:date name="user.pwdUpdTime" format="yyyy-MM-dd HH:mm:ss"/></td>
    	 		</tr>
    	 		<tr>
	    	 		<td rowspan="${session.rListLenToLoginUser+1 }" align="center">当前登陆用户对应角色集</td>
	    	 		<th colspan="2">角色名称</th>
	    	 		<th colspan="4">角色描述</th>
    	 		</tr>
    	 		<s:iterator  value="#session.roleListToLoginUser"  var="r" > 
    	 				<tr>
	    	 				<td colspan="2" style="text-align: center">
		    	 				<span>
		    	 					<input id="curRoleName_<s:property  value='#r.roleId'/>" type="hidden" name="curRoleName" value="<s:property  value='#r.roleName'/>"/>
			    	 				<s:property  value="#r.roleName"/>
			    	 				&nbsp;&nbsp;
			    	 				<button onclick="queryLimitsByRole(<s:property  value='#r.roleId'/>);">查看角色权限</button>	
		    	 				</span>
	    	 				</td>
	    	 				<td colspan="4" style="text-align: center"><s:property  value="#r.roleDesc"/></td>
    	 				</tr>
    	 		</s:iterator>
    	 		<tr>
    	 			<td align="center" ><div style="color: red;">当前用户登陆角色</div></td>
    	 			<td align="center" colspan="6">
    	 				<div style="color: red;"><s:property value="#session.loginRole.roleName"/></div>
    	 			</td>
    	 		</tr>
    	 		<tr>
    	 			<td align="center" rowspan="6">当前登陆角色权限</td>
    	 			<th colspan="2" rowspan="2">模块名称</th>
	    	 		<th colspan="4">权限</th>
    	 		</tr>
    	 		<tr>
    	 			<td align="center">C | 增</td>
    	 			<td align="center">R | 查</td>
    	 			<td align="center">U | 改</td>
    	 			<td align="center">D | 删</td>
    	 		</tr>
    	 		<s:iterator value="#session.moduleList" var="m">
    	 		<tr>
    	 			<td colspan="2" align="center"><s:property value="#m.moduleName"/></td>
    	 			<td align="center">
    	 				<s:if test="(moduleLimitsMap[#m.moduleId]&8)==8">✔</s:if>
    	 			</td>
    	 			<td align="center">
    	 				<s:if test="(moduleLimitsMap[#m.moduleId]&4)==4">✔</s:if>
    	 			</td>
    	 			<td align="center">
    	 				<s:if test="(moduleLimitsMap[#m.moduleId]&2)==2">✔</s:if>	
    	 			</td>
    	 			<td align="center">
    	 				<s:if test="(moduleLimitsMap[#m.moduleId]&1)==1">✔</s:if>	
    	 			</td>
    	 		</tr>
    	 		</s:iterator>	
    	 </table>
  </body>
</html>
