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
    
    <title>My JSP 'queryRoleList.jsp' starting page</title>
    
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
					 iframeWH:{width:500,height:120},
					 target:"moduleAction!queryModuleListForScan.do?roleId="+roleId
					});
				 wbox.showBox();
			}
	</script>
  </head>
  
  <body>
  		<table  id="t1"  width="100%"  border=1>
  				<tr>
    				<td colspan="4" style="border: none;text-align: center">----------- 角色模块授权 -----------</td>
    			</tr>
    	 		<tr>
    	 			<th>角色id</th>
    	 			<th>角色名称</th>
    	 			<th>角色描述</th>
    	 			<th>操作</th>
    	 		</tr>
    	 		<s:iterator   value="#application.roleList"  var="role"> 
    	 			<tr>
    	 				<td style="text-align: center"><s:property  value="#role.roleId"/></td>
    	 				<td style="text-align: center">
    	 					<span>
	    	 					<input id="curRoleName_<s:property  value='#role.roleId'/>" type="hidden" name="curRoleName" value="<s:property  value='#role.roleName'/>"/>
		    	 				<s:property  value="#role.roleName"/>
		    	 				&nbsp;&nbsp;
		    	 				<button onclick="queryLimitsByRole(<s:property  value="#role.roleId"/>);">查看角色权限</button>
    	 					</span>
    	 				</td>
    	 				<td style="text-align: center"><s:property  value="#role.roleDesc"/></td>
    	 				<td style="text-align: center">
    	 					<a href="moduleAction.do?roleId=<s:property  value='#role.roleId'/>">授权</a>
    	 				</td>
    	 			</tr>
    	 		</s:iterator>
    	 </table>
  </body>
</html>
