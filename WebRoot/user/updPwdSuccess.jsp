<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePsw.jsp' starting page</title>
 
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body> 
  		<div><label>恭喜您！</label></div>
    	<div><label>用户：${user.uname }</label></div>
    	<div>您的登陆密码已由原密码：<label style="color: gray;">${userLoginPwd }</label></div>
    	<div>成功改为新密码：<label style="color: red;">${password }</label></div>
    	<div>密码更改时间为：<label style="color: green;"><s:date name="pwdUpdTime" format="yyyy-MM-dd HH:mm:ss"/></label></div>
    	<div><button onclick="window.location.href='right.jsp'">单击返回主页面</button></div>
  </body>
</html>
