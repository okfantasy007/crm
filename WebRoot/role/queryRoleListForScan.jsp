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
	
	<script src="util/jquery-1.8.3.js"></script>
	<script >
		$(function(){
			var userId = "${param.userId }";
				$.ajax({
					   type: "POST",
					   url: "roleAction!queryRoleJsonArrayByUserId.do",
					   data: "userId="+userId,
					   success: function(msg){
					     eval("var roleArray="+msg);
					     for(var i = 0;i<roleArray.length;i++){
					     	var roleId = roleArray[i].roleId;//也可以是var roleId = roleArray[i]["roleId"];
					     	$("label").each(function(){
					     	     	if(roleId==$(this).attr("id")){
					     				$(this).html("✔");//注意给innerHTML赋值的方法
					     			}
					     	});
					     }
					   }
				});
		});
	</script>
  </head>
  
  <body>
		<input type="hidden"  name="user.userId" value="${param.userId }" />
   		<s:iterator   value="#application.roleList"  var="role">
    			<!--<input type="checkbox"  name="roleIds" value="<s:property  value='#role.roleId'/>" disabled="disabled"/>-->
    			<s:property  value='#role.roleName'/>
    			<label id="<s:property  value='#role.roleId'/>"></label>
    			<br/>
       	</s:iterator>
  </body>
</html>
