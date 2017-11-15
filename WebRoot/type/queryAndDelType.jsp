<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'queryLogList.jsp' starting page</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="util/jquery-1.8.3.js"></script>
	<script>
	   	function delSelect(){
	   	      var nodes = document.getElementsByName("select");
	   	      for ( var i = 0; i < nodes.length; i++) {
				nodes[i].checked = !nodes[i].checked;
			}
	   	}
	   	
	   	function del(){
	   	     var ids = "";
	   	     var nodes = document.getElementsByName("select");
	   	     var selcount = 0;
	   	     for ( var i = 0; i < nodes.length; i++) {
	   	     	if(nodes[i].checked){
	   	     		ids += nodes[i].value+";";
	   	     		selcount++;
	   	     	}
			}
			if(confirm("您确定要删除选中的 "+selcount+" 条分类记录吗？")){
				window.location.href="typeAction!deleteAll.do?ids="+ids;
				return true;
			}else{
				return false;
			}
	   	}
	   	
	   	function delSingleType(typeId){
	   		var typeName = $("#curTypeName_"+typeId).val();
			if(confirm("您确定要删除 "+typeName+" 吗？")){
				window.location.href="typeAction!deleteType.do?type.typeId="+typeId;
				return true;
			}else{
				return false;
			}
	   	}
	</script>
  </head>
  
  <body>
    <table   id="t1"  width="100%" border=1>
    			<s:if test="(#session.limitsCode&1)==1">
	    	 		<tr>
   							<td colspan="4" style="border: none;text-align: center">----------- 删除分类-----------</td>
	    	 				<td align="center" style="border: none" colspan="1">
	    	 					    <button onclick="return del();"/>批量删除</button>
	    	 				</td>
	    	 	   	</tr>
    	 	   	</s:if>
    	 		<tr>
    	 			<th align="center" width="6%"><input id="delSe" type="checkbox" onclick="delSelect();"/>&nbsp;全选</th>
    	 			<th>分类id</th>
    	 			<th>分类名称</th>
    	 			<th>分类描述</th>
    	 			<th>操作</th>
    	 		</tr>
    	 		<s:iterator  value="typeList"  var="t"> 
    	 			<tr>
    	 				<td align="center"><input name="select" type="checkbox" value="${t.typeId }"/></td>
    	 				<td style="text-align: center"><s:property  value="#t.typeId"/></td>
    	 				<td style="text-align: center">
	    	 				<s:property  value="#t.typeName"/>
	    	 				<input id="curTypeName_${t.typeId}" type="hidden" value="${t.typeName }"/>
    	 				</td>
    	 				<td style="text-align: center"><s:property  value="#t.typeDesc"/></td>
    	 				<td style="text-align: center">
    	 					<s:if test="(#session.limitsCode&1)==1">
    	 						<button onclick="return delSingleType(<s:property  value='#t.typeId'/>);"/>删除分类</button>
    	 						<!--<a href="typeAction!deleteType.do?type.typeId=<s:property  value='#t.typeId'/>">删除日志</a>-->
    	 					</s:if>
   	 				 	</td>
    	 			</tr>
    	 		</s:iterator>
    	 </table>
  </body>
</html>
