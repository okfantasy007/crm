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
			if(confirm("您确定要删除选中的 "+selcount+" 条日志记录吗？")){
				window.location.href="logAction!deleteAll.do?ids="+ids;
				return true;
			}else{
				return false;
			}
	   	}
	   	
	   	function delSingleLog(logId){
	   		var logName = $("#curLogName_"+logId).val();
			if(confirm("您确定要删除 "+logName+" 吗？")){
				window.location.href="logAction!deleteLog.do?log.logId="+logId;
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
   							<td colspan="7" style="border: none;text-align: center">----------- 删除日志 -----------</td>
	    	 				<td align="center" style="border: none" colspan="1">
	    	 					    <button onclick="return del();"/>批量删除</button>
	    	 				</td>
	    	 	   	</tr>
    	 	   	</s:if>
    	 		<tr>
    	 			<th align="center" width="6%"><input id="delSe" type="checkbox" onclick="delSelect();"/>&nbsp;全选</th>
    	 			<th>日志id</th>
    	 			<th>日志名称</th>
    	 			<th>日志内容</th>
    	 			<th>日志创建者</th>
    	 			<th>日志创建时间</th>
    	 			<th>最后更新时间</th>
    	 			<th>操作</th>
    	 		</tr>
    	 		<s:iterator  value="logList"  var="l"> 
    	 			<tr>
    	 				<td align="center"><input name="select" type="checkbox" value="${l.logId }"/></td>
    	 				<td style="text-align: center"><s:property  value="#l.logId"/></td>
    	 				<td style="text-align: center">
    	 					<s:property  value="#l.logName"/>
    	 					<input id="curLogName_${l.logId}" type="hidden" value="${l.logName }"/>
    	 				</td>
    	 				<td style="text-align: center"><s:property  value="#l.logContent"/></td>
    	 				<td style="text-align: center"><s:property  value="#l.logAuthor"/>  </td>
    	 				<td style="text-align: center"><s:date name="#l.logCreateTime" format="yyyy-MM-dd HH:mm:ss"/></td>
    	 				<td style="text-align: center">
	    	 					<s:date name="#l.logUpdTime" format="yyyy-MM-dd HH:mm:ss"/>
    	 				</td>
    	 				<td style="text-align: center">
    	 					<s:if test="(#session.limitsCode&1)==1">
    	 						<button onclick="return delSingleLog(<s:property  value='#l.logId'/>);"/>删除日志</button>
    	 						<!--<a href="logAction!deleteLog.do?log.logId=<s:property  value='#l.logId'/>">删除日志</a>-->
    	 					</s:if>
   	 				 	</td>
    	 			</tr>
    	 		</s:iterator>
    	 </table>
  </body>
</html>
