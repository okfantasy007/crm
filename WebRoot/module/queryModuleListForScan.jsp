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
    <title>My JSP 'queryModuleList.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  		<table   id="t1"  width="100%" border=1>
    	 		<tr>
    	 			<th>模块id</th>
    	 			<th>模块名称</th>
    	 			<th>C | 增</th>
    	 			<th>R | 查</th>
    	 			<th>U | 改</th>
    	 			<th>D | 删</th>
    	 		</tr>
    	 		<s:iterator   value="moduleList"  var="m"> 
    	 			<tr>
    	 				<td style="text-align: center"><s:property  value="#m.moduleId"/></td>
    	 				<td style="text-align: center"><s:property  value="#m.moduleName"/></td>
    	 				<!--
    	 				moduleLimitsMap[#m.moduleId]即是limitsCode
    	 				获取map的键值方法：value=map[key]
    	 				单选框<input name="gender"  type="radio" value="0" checked="checked" />
    	 				复选框<input type="checkbox" name="checkbox1" value="checkbox" checked="checked"> 
    	 				changeLimitsCode点击复选框选项时就导致数据库rm发生变化
    	 				注意当是留言模块时，只拥有查看和删除的权限，
    	 				不应该具备增加和修改留言的权限
    	 				-->
    	 				 <td  align="center"> 
    	 					<s:if  test="(moduleLimitsMap[#m.moduleId]&8)==8">✔</s:if>
    	 				 </td>
    	 				 <td  align="center"> 
    	 					<s:if  test="(moduleLimitsMap[#m.moduleId]&4)==4">✔</s:if>
    	 				 </td>
    	 				 <td  align="center"> 
    	 					<s:if  test="(moduleLimitsMap[#m.moduleId]&2)==2">✔</s:if>
    	 				 </td>
    	 				  <td  align="center"> 
    	 					<s:if  test="(moduleLimitsMap[#m.moduleId]&1)==1">✔</s:if>
    	 				 </td>
    	 			</tr>
    	 		</s:iterator>
    	 </table>	
  </body>
</html>
