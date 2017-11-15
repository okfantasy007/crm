<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib  prefix="s"  uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"  />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="js/js.js"></script>
<script src="util/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function changeChknumber(obj){
		$(obj).attr("src","image.jsp?random="+new Date().getTime());
	}
	setInterval(function(){
		changeChknumber($("#randomImg"));
	},1000*60*30);
	function formSubmit(){
		$("#loginForm").submit();
	}
	function formReset(){
		$("#loginForm").get(0).reset();
	}
</script>
</head>
<body>
<div id="top"> </div>
<form id="loginForm" name="loginForm" action="loginAction.do" method="post">
  <div id="center">
    <div id="center_left"></div>
    <div id="center_middle"  style="width:260px;">
      <div class="chknumber">
        <label>用户名：
        <input type="text" name="user.uname" id="uname"   value='${user.uname}'  />
        </label>
      </div>
      <div class="chknumber">
        <label>密　码：
        	<input type="password" name="user.pwd" id="pwd"   />
        </label><br/>
        <label>角&nbsp;&nbsp;&nbsp;&nbsp;色：
        	<select name="roleId"  style="width:105px;" >
        		<s:iterator   value="#application.roleList"  var="role">
        			<option  value="<s:property  value='#role.roleId'/>"><s:property  value='#role.roleName'/></option>
        		</s:iterator>
        	</select>
        </label>
      </div>
      <div class="chknumber">
          	<span>
		       <label>验证码：
		        	<input name="chknumber" type="text" id="chknumber" maxlength="4"   />
		       </label>
		       <label>
	       	   		<img id="randomImg" src="image.jsp?random=<%=new Date().getTime() %>"  id="safecode" onclick="changeChknumber(this);"  />
	       	   </label> 
   			</span>
        <br/><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label style="color: red">${userMessage}${chkNumberMessage}</label>
      </div>
    </div>
    <div id="center_middle_right"></div>
    <div id="center_submit">
      <div class="button"> <img src="images/dl.gif" width="57" height="20" onclick="formSubmit()" /> </div>
      <div class="button"> <img src="images/cz.gif" width="57" height="20" onclick="formReset()" /> </div>
    </div>
    <div id="center_right"></div>
  </div>
</form>
<div id="footer"></div>
</body>
</html>