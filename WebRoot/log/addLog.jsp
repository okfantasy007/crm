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
	<!--<script src="util/jquery-1.8.3.js"></script>-->
	<!-- 上述 jquery-1.8.3.js不能与
	Validform_v5.3.2/demo/js/jquery-1.9.1.min.js共存
	因为两个js会发生冲突，在需要表单验证的前提下
	保留Validform_v5.3.2/demo/js/jquery-1.9.1.min.js
	function closeSonPage()可以运用在不需要表单验证的情况下-->
	<script type="text/javascript">
		$(function(){
			$(".demoform").Validform({
				showAllError:true,
				tiptype:3,
				beforeSubmit:function(curform){
				    //在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。
				    //这里明确return false的话表单将不会提交;	
					var logName = $("#newLogName").val();
					if(confirm("您确定要新增 "+logName+" 吗？")){
						window.parent.closeAndRefresh();
						return true;
					}else{
						return false;
					}
				}
			})
		})		
		
		function closeSonPage(){
			var logName = $("#newLogName").val();
			if(confirm("您确定要新增 "+logName+" 吗？")){
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
  
  <body style="background: white;">
    <form action="logAction!addLog.do" id="demoform" class="demoform" method="post" onsubmit="false">
    </br>
	  	<table align="center" >
	  		<tr>
	  			<th>日志名称</th>
	  			<td><input id="newLogName" name="log.logName" placeholder="请输入2-8位字符" datatype="s2-8" errormsg="请输入2-8位字符" nullmsg="日志名称不能为空"/></td>  
	  		</tr>
	  		<tr>
	  			<th>日志内容</th>
	  			<td><input name="log.logContent" placeholder="请输入3-140位字符" datatype="s3-140" errormsg="请输入3-140位字符" nullmsg="日志内容不能为空"/></td>  
	  		</tr>
	  		<tr>
	  			<th>日志创建者</th>
	  			<td><input name="log.logAuthor" placeholder="请输入2-6位字符" datatype="s2-6" errormsg="请输入2-6位字符" nullmsg="日志创建者姓名不能为空"/></td>  
	  		</tr>
	  		<tr>
	  			<th>日志创建时间</th>
	  			<td>
		  			<input id="d12" name="log.logCreateTime"  datatype="*"  type="text" placeholder="请点击右侧小日历输入日志创建时间" nullmsg="日志创建时间不能为空"/>
		  			<img onclick="WdatePicker({el:'d12'})" src="util/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
	  			</td> 
	  		</tr>
	  		<tr>
	  			<th>最后更新时间</th>
	  			<td><input id="d12" name="log.logUpdTime"  datatype="*"  type="text"  value="<%=time %>" readonly="readonly"/></td> 
	  		</tr>
	  		<tr></tr>
	  		<tr></tr>
	  		<tr></tr>
	  		<tr></tr>
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
		  			<input type="submit" value="提交" style="height: 27;width: 45"/>
	  			</td>
	  			<td>
		  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  			<input type="reset" value="重置" style="height: 27;width: 45"/>
	  			</td>
	  		</tr>
	  	</table>
	  </form>
  </body>
</html>
