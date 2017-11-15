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
	<script src="util/jquery-1.8.3.js"></script>
	<script>
		function changeLimitsCode(obj,moduleId,limitsCode){
			var flag = obj.checked?1:0;
			$.ajax({
				   type: "POST",
				   url: "roleModuleAction!updateLimitsCodeByRoleAndModuleId.do",
				   data: "roleId=${param.roleId}&moduleId="+moduleId+"&limitsCode="+limitsCode+"&flag="+flag
			});
		}
	</script>
  </head>
  
  <body>
  		<table   id="t1"  width="100%" border=1>
  				<tr><td colspan="8" align="center">----- 修改角色 ： ${roleName } 的权限 -----</td></tr>
    	 		<tr>
    	 			<th>模块id</th>
    	 			<th>模块编码</th>
    	 			<th>模块名称</th>
    	 			<th>模块url</th>
    	 			<th>C | 增</th>
    	 			<th>R | 查</th>
    	 			<th>U | 改</th>
    	 			<th>D | 删</th>
    	 		</tr>
    	 		<s:iterator   value="moduleList"  var="m"> 
    	 			<tr>
    	 				<td style="text-align: center"><s:property  value="#m.moduleId"/></td>
    	 				<td style="text-align: center"><s:property  value="#m.moduleCode"/></td>
    	 				<td style="text-align: center"><s:property  value="#m.moduleName"/></td>
    	 				<td style="text-align: center"><s:property  value="#m.moduleUrl"/></td>
    	 				<!--
    	 				moduleLimitsMap[#m.moduleId]即是limitsCode
    	 				获取map的键值方法：value=map[key]
    	 				单选框<input name="gender"  type="radio" value="0" checked="checked" />
    	 				复选框<input type="checkbox" name="checkbox1" value="checkbox" checked="checked"> 
    	 				changeLimitsCode点击复选框选项时就导致数据库rm发生变化
    	 				注意当是留言模块时，只拥有查看和删除的权限，
    	 				不应该具备增加和修改留言的权限
    	 				-->
    	 				<td align="center">
    	 					<input type="checkbox" name="cb_<s:property  value='#m.moduleId'/>" 
    	 					onclick="changeLimitsCode(this,<s:property  value='#m.moduleId'/>,8);"  
    	 					<s:if  test="#m.moduleId!=27&&(moduleLimitsMap[#m.moduleId]&8)==8">
	    	 					checked="checked"
    	 					</s:if>
    	 					<s:if test="#m.moduleId==27">
    	 						disabled="disabled"
    	 					</s:if>
    	 					value="8"  />
    	 				 </td>
    	 				 <td  align="center"> 
    	 					<input type="checkbox" name="cb_<s:property  value='#m.moduleId'/>" 
    	 					onclick="changeLimitsCode(this,<s:property  value='#m.moduleId'/>,4);" 
    	 					<s:if  test="(moduleLimitsMap[#m.moduleId]&4)==4">
    	 						checked="checked"
    	 					</s:if> 
    	 					value="4"  />
    	 				 </td>
    	 				 <td  align="center">
    	 				 	<input type="checkbox" name="cb_<s:property  value='#m.moduleId'/>"
    	 				 	onclick="changeLimitsCode(this,<s:property  value='#m.moduleId'/>,2);" 
    	 					<s:if  test="#m.moduleId!=27&&(moduleLimitsMap[#m.moduleId]&2)==2">
	    	 					checked="checked"
    	 					</s:if>
    	 					<s:if test="#m.moduleId==27">
    	 						disabled="disabled"
    	 					</s:if>
    	 					value="2"  />
    	 				 </td>
    	 				 <td  align="center">
    	 					<input type="checkbox" name="cb_<s:property  value='#m.moduleId'/>" 
    	 					onclick="changeLimitsCode(this,<s:property  value='#m.moduleId'/>,1);" 
    	 					<s:if  test="(moduleLimitsMap[#m.moduleId]&1)==1">
    	 						checked="checked"
    	 					</s:if> 
    	 					value="1"  />
    	 				 </td>
    	 			</tr>
    	 		</s:iterator>
    	 		<tr>
    	 		    <td colspan="7" style="border: none"></td>
    	 			<td align="center" colspan="1" style="border: none">
    	 				<a  href="javascript:void(0);"  onclick="javascript:history.go(-1);">完成</a>
    	 			</td>
    	 		</tr>
    	 </table>	
  </body>
</html>
