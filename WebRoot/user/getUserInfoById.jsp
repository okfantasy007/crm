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
  </head>
  
  <body>
   			 <table   id="t1"  width="100%" border=1>
    	 		<tr>
    	 			<td style="text-align: center" rowspan="6">当前登陆用户</td>
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
    	 </table>
  </body>
</html>
