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
	<script type="text/javascript" src="util/Validform_v5.3.2/Validform_v5.3.2/demo/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="util/Validform_v5.3.2/Validform_v5.3.2/demo/js/Validform_v5.3.2_min.js"></script>
	<script src="util/jquery-1.8.3.js"></script>
	<script type="text/javascript">
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
			     	$("input[type=checkbox]").each(function(){
		     	     	if(roleId==$(this).attr("value")){
		     				$(this).attr("checked","checked");
		     			}
			     	});
			      }
		   		}
			});
		});
		function closeSonPage(){
			var userName = "${param.userName }";
			if(confirm("您确定要修改用户 : "+userName+" 的角色集吗？")){
				$("form").attr("onsubmit","true");
				window.parent.closeAndRefresh();
				return true;
			}else{
				$("form").attr("onsubmit","false");
				return false;
			}
		}
	</script>
  </head>
  
  <body>
    	<form action="userAction!updateUserRole.do" onsubmit="false">
    		<input type="hidden"  name="user.userId" value="${param.userId }" />
    		<s:iterator   value="#application.roleList"  var="role">
	    			<input type="checkbox"  name="roleIds" value="<s:property  value='#role.roleId'/>"/>
	    			<s:property  value='#role.roleName'/><br/>
        	</s:iterator>
        	<input type="submit" value="提交" onclick="return closeSonPage();"/><!--加个return更好控制-->
       	</form>
  </body>
</html>
