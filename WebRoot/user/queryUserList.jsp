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
    		function queryRoleListByUser(userId){
    			 var userName = $("#curUserName_"+userId).val();//注意这里运用jquery获取roleName的方法
				 wbox = $().wBox({
				     title: "查看用户 ："+userName+" 的角色集",
					 requestType: "iframe",
					 iframeWH:{width:200,height:105},
					 target:"role/queryRoleListForScan.jsp?userId="+userId
					});
				 wbox.showBox();
			}
			
			function updateRoleListByUser(userId){
    			 var userName = $("#curUserName_"+userId).val();//注意这里运用jquery获取roleName的方法
				 wbox = $().wBox({
				     title: "修改用户 ："+userName+" 的角色集",
					 requestType: "iframe",
					 iframeWH:{width:200,height:140},
					 target:"role/queryRoleList.jsp?userId="+userId+"&userName="+userName
					});
				 wbox.showBox();
			}
			
			function getUserInfo(userId,userName){
				wbox = $().wBox({
				     title: "查看用户 ："+userName+" 的基本信息",
					 requestType: "iframe",
					 iframeWH:{width:800,height:50},
					 timeout:3000,
					 target:"userAction!getUserInfoById.do?userId="+userId
					});
				 wbox.showBox();
			}
			
			function closeAndRefresh(){
				wbox.close();
				setTimeout(function(){
					window.location = window.location;//刷新父页面
				}, 3000);
			}
	</script>
  </head>
  
  <body>
   			 <table   id="t1"  width="100%" border=1>
   			 	<tr>
    				<td colspan="6" style="border: none;text-align: center">----------- 用户分配角色 -----------</td>
    			</tr>
    	 		<tr>
    	 			<th>用户id</th>
    	 			<th>用户名称</th>
    	 			<th>邮箱</th>
    	 			<th>注册时间</th>
    	 			<th>密码更改时间</th>
    	 			<th>操作</th>
    	 		</tr>
    	 		<s:iterator  value="userList"  var="u"> 
    	 			<tr>
    	 				<td style="text-align: center"><s:property  value="#u.userId"/></td>
    	 				<td style="text-align: center">
	    	 				<span>
	    	 					<input id="curUserName_<s:property  value='#u.userId'/>" type="hidden" name="curUserName" value="<s:property  value='#u.uname'/>"/>
	    	 					<label onmousemove="getUserInfo(<s:property  value='#u.userId'/>,'${u.uname }');"><s:property  value="#u.uname"/></label>
	    	 					&nbsp;&nbsp;
		    	 				<button onclick="queryRoleListByUser(<s:property  value='#u.userId'/>);">查看用户角色集</button>
	    	 				</span>
    	 				</td>
    	 				<td style="text-align: center"><s:property  value="#u.email"/></td>
    	 				<td style="text-align: center"><s:date name="#u.registerTime" format="yyyy-MM-dd HH:mm:ss"/></td>
   	 				    <td style="text-align: center"><s:date name="#u.pwdUpdTime" format="yyyy-MM-dd HH:mm:ss"/></td>
    	 				<td style="text-align: center">
    	 					<button onclick="updateRoleListByUser(<s:property  value="#u.userId"/>);" >分配角色</button>
    	 					<!--<a href="role/queryRoleList.jsp?userId=<s:property  value='#u.userId'/>">分配角色</a>-->
   	 				 	</td>
    	 			</tr>
    	 		</s:iterator>
    	 </table>
  </body>
</html>
