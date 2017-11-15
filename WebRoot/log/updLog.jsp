<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <title>My JSP 'beforeAddType.jsp' starting page</title>
    <link rel="stylesheet" href="util/Validform_v5.3.2/Validform_v5.3.2/demo/css/style.css" type="text/css"/>
	<link href="css/demo.css" type="text/css" rel="stylesheet" />
    
    <style>
		.Validform_checktip{margin-left:10px;}
	</style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script language="javascript" type="text/javascript" src="util/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="util/Validform_v5.3.2/Validform_v5.3.2/demo/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="util/Validform_v5.3.2/Validform_v5.3.2/demo/js/Validform_v5.3.2_ncr_min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".demoform").Validform({
				showAllError:true,
				tiptype:3,
				beforeSubmit:function(curform){
					var logName = $("#curLogName").val();
					if(confirm("您确定要修改 "+logName+" 吗？")){
						window.parent.closeAndRefresh();
						return true;
					}else{
						return false;
					}
				}
			})
		})		
		
		function closeSonPage(logId){
			var logName = $("#curLogName_"+logId).val();
			if(confirm("您确定要修改 "+logName+" 吗？")){
				$("form").attr("onsubmit","true");
				window.parent.closeAndRefresh();
				return true;
			}else{
				$("form").attr("onsubmit","false");
				return false;
			}
		}		
		/*
		function closeSonPage(logId,logName){
			//var logName = $("#curLogName_"+logId).val();
			if(confirm("您确定要修改 "+logName+" 吗？")){
				$("form").attr("onsubmit","true");
				window.parent.closeAndRefresh();
				return true;
			}else{
				$("form").attr("onsubmit","false");
				return false;
			}
		}*/
		/*	
		function closeSonPage(){
			window.parent.closeAndRefresh();
			return true;
		}
		*/
	</script>
  </head>
  
  <body style="background: white;">
    <form action="logAction!updateLog.do" id="demoform" class="demoform" method="post" onsubmit="false">
    	<input type="hidden" name="log.logId" value="${log.logId}"/>
    	</br>
	  	<table align="center" >
	  		<tr>
	  			<th>日志名称</th>
	  			<td><input id="curLogName"  name="log.logName" value="${log.logName }" placeholder="请输入2-8位字符" datatype="s2-8" errormsg="请输入2-8位字符" nullmsg="日志名称不能为空"/></td>  
	  		</tr>
	  		<tr>
	  			<th>日志内容</th>
	  			<td><input name="log.logContent" value="${log.logContent }" placeholder="请输入3-140位字符" datatype="s3-140" errormsg="请输入3-140位字符" nullmsg="日志内容不能为空"/></td>  
	  		</tr>
	  		<tr>
	  			<th>日志创建者</th>
	  			<td><input name="log.logAuthor" value="${log.logAuthor }" placeholder="请输入2-6位字符" datatype="s2-6" errormsg="请输入2-6位字符" nullmsg="日志创建者姓名不能为空"/></td>  
	  		</tr>
	  		<tr>
	  			<th>日志创建时间</th>
	  			<td><input id="d12" name="log.logCreateTime"  datatype="*"  type="text"  value="${log.logCreateTime}" readonly="readonly"/></td> 
	  		</tr>
	  		<tr>
	  			<th>最新更新时间</th>
	  			<td><input id="d12" name="log.logUpdTime"  datatype="*"  type="text"  value="<%=time %>" readonly="readonly"/></td> 
	  		</tr>
	  		<tr></tr>
	  		<tr></tr>
	  		<tr></tr>
	  		<tr></tr>
	  		<tr></tr>
	  		<tr></tr>
	  		<tr></tr>
	  		<tr>
	  			<td>
		  			&nbsp;&nbsp;&nbsp;&nbsp;
		  			&nbsp;&nbsp;&nbsp;&nbsp;
		  			&nbsp;&nbsp;&nbsp;&nbsp;
		  			<!-- 两种不同方式：onclick="return closeSonPage(${log.logId});"
		  			onclick="return closeSonPage(${log.logId},'${log.logName}');"
		  			后者注意第二个参数传日志名称的时候，要在${log.logName}外加单引号，
		  			因为该参数为字符串类型，不加单引号或双引号就是数值类型，也就不能
		  			将日志名称参数成功传至js函数体重，因此要特别注意这点 -->
		  			<input type="submit" value="提交" style="height: 28;width: 55" />
		  			<!--<input type="submit" value="提交" style="height: 28;width: 55" onclick="return closeSonPage(${log.logId},'${log.logName}');" />-->
	  			</td>
	  			<td>
		  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  			<input type="reset" value="重置" style="height: 28;width: 55"/>
	  			</td>
	  		</tr>
	  	</table>
	  </form>
  </body>
</html>
