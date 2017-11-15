<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    java.util.Date currentTime = new java.util.Date();  
    String time = simpleDateFormat.format(currentTime).toString();   
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
	
	<script type="text/javascript" src="util/wbox/jquery1.4.2.js"  ></script>
    <script type="text/javascript" src="util/wbox/wbox-min.js"  ></script>
    <link rel="stylesheet" type="text/css" href="util/wbox/wbox/wbox-min.css">
	
	<script type="text/javascript">
			var wbox;
    		function addLog(){
				 wbox = $().wBox({
				     title: "新增日志",
					 requestType: "iframe",
					 iframeWH:{width:700,height:210},
					 target:"log/addLog.jsp"
					});
				 wbox.showBox();
			}
			
			function updateLog(logId){
				 var logName = $("#curLogName_"+logId).val();
				 wbox = $().wBox({
				 	 title: "修改 "+logName,
					 requestType: "iframe",
					 iframeWH:{width:700,height:210},
					 target:"logAction!updateBeforeLog.do?log.logId="+logId
					});
				 wbox.showBox();
			}
			
			function closeAndRefresh(){
				wbox.close();
				setTimeout(function(){
					window.location = window.location;//刷新父页面
				}, 1000);
			}
	</script>
  </head>
 
  <body>
    <table   id="t1"  width="100%" border=1>
    			<tr>
    				<td colspan="7" style="border: none;text-align: center">----------- 查看/修改日志 -----------</td>
    			</tr>
    	 		<tr>
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
    	 				<td style="text-align: center"><s:property  value="#l.logId"/>  </td>
    	 				<td style="text-align: center">
    	 					<s:property  value="#l.logName"/>  
    	 					<input id="curLogName_<s:property  value='#l.logId'/>" type="hidden" value="<s:property  value='#l.logName'/>"/>
    	 				</td>
    	 				<td style="text-align: center"><s:property  value="#l.logContent"/>  </td>
    	 				<td style="text-align: center"><s:property  value="#l.logAuthor"/>  </td>
    	 				<td style="text-align: center">
    	 					<s:date name="#l.logCreateTime" format="yyyy-MM-dd HH:mm:ss"/>
    	 				</td>
    	 				<td style="text-align: center">
    	 					<s:date name="#l.logUpdTime" format="yyyy-MM-dd HH:mm:ss"/>
    	 				</td>
    	 				<td style="text-align: center">
    	 					<s:if test="(#session.limitsCode&2)==2">
    	 						<button onclick="updateLog(<s:property  value='#l.logId'/>);" >修改日志</button>
    	 						<!--<a href="logAction!updateBeforeLog.do?log.logId=<s:property  value='#l.logId'/>">修改日志</a>-->
    	 					</s:if>
   	 				 	</td>
    	 			</tr>	
    	 		</s:iterator>
    	 		<s:if test="(#session.limitsCode&8)==8">
	    	 		<tr>
	    	 				<td align="center" style="border: none">
	    	 					    <button onclick="addLog();" >新增日志</button>
	    	 					    <!--<a href="logAction!addBeforeLog.do">新增日志</a>-->
	    	 				</td>
	    	 	   	</tr>
    	 	   	</s:if>
    	 </table>
  </body>
</html>
