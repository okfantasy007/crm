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
    <title>My JSP 'queryMessageList.jsp' starting page</title>
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
			if(confirm("您确定要删除选中的 "+selcount+" 条留言记录吗？")){
				window.location.href="messageAction!deleteAll.do?ids="+ids;
				return true;
			}else{
				return false;
			}
	   	}
	   	
	   	function delSingleMsg(msgId){
	   		var msgName = $("#curMsgName_"+msgId).val();
			if(confirm("您确定要删除 "+msgName+" 吗？")){
				window.location.href="messageAction!deleteMsg.do?msg.msgId="+msgId;
				return true;
			}else{
				return false;
			}
	   	}
	</script>
  </head>
  
  <body> 
    <table   id="t1"  width="100%" border=1>
    			<tr>
    				<td colspan="6" style="border: none;text-align: center">----------- 查看/删除留言 -----------</td>
    				<s:if test="(#session.limitsCode&1)==1">
    	 				<td align="center" style="border: none" colspan="1">
    	 					    <button onclick="return del();"/>批量删除</button>
    	 				</td> 	
    	 	   		</s:if>
    			</tr>
    	 		<tr>
    	 			<th align="center" width="6%"><input id="delSe" type="checkbox" onclick="delSelect();"/>&nbsp;全选</th>
    	 			<th>留言id</th>
    	 			<th>留言名称</th>
    	 			<th>留言内容</th>
    	 			<th>留言发表时间</th>
    	 			<th>留言发表者</th>
    	 			<th>操作</th>
    	 		</tr>
    	 		<s:iterator  value="msgList"  var="m"> 
    	 			<tr>
    	 				<td align="center"><input name="select" type="checkbox" value="${m.msgId }"/></td>
    	 				<td style="text-align: center"><s:property  value="#m.msgId"/></td>
    	 				<td style="text-align: center">
    	 					<s:property  value="#m.msgName"/>
    	 					<input id="curMsgName_${m.msgId }" type="hidden" value="${m.msgName }"/>
    	 				</td>
    	 				<td style="text-align: center"><s:property  value="#m.msgContent"/></td>
    	 				<td style="text-align: center"><s:date name="#m.msgCreateTime" format="yyyy-MM-dd HH:mm:ss"/></td>
    	 				<td style="text-align: center"><s:property  value="#m.msgAuthor"/></td>
    	 				<td style="text-align: center">
    	 					<s:if test="(#session.limitsCode&1)==1">
    	 						<button onclick="return delSingleMsg(<s:property  value='#m.msgId'/>);"/>删除留言</button>
    	 						<!--<a href="messageAction!deleteMsg.do?msg.msgId=<s:property  value='#m.msgId'/>">删除留言</a>-->
    	 					</s:if>
   	 				 	</td>
    	 			</tr>
    	 		</s:iterator>
    	 </table>
  </body>
</html>
