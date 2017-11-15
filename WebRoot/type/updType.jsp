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
					var typeName = $("#curTypeName").val();
					if(confirm("您确定要修改 "+typeName+" 吗？")){
						window.parent.closeAndRefresh();
						return true;
					}else{
						return false;
					}
				}
			})
		})		
		
		function closeSonPage(typeId){
			var typeName = $("#curTypeName_"+typeId).val();
			if(confirm("您确定要修改 "+typeName+" 吗？")){
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
    <form action="typeAction!updateType.do" id="demoform" class="demoform" method="post" onsubmit="false">
    	<input type="hidden" name="type.typeId" value="${type.typeId}"/>
    	</br>
	  	<table align="center" >
	  		<tr>
	  			<th>分类名称</th>
	  			<td><input type="text" id="curTypeName" name="type.typeName" value="${type.typeName }" placeholder="请输入2-8位字符" datatype="s2-8" errormsg="请输入2-8位字符" nullmsg="分类名称不能为空"/></td>  
	  		</tr>
	  		<tr>
	  			<th>分类描述</th>
	  			<td><input name="type.typeDesc" value="${type.typeDesc }" placeholder="请输入分类描述" /></td>  
	  		</tr>
	  		<tr>
	  			<th>分类创建时间</th>
	  			<td><input id="d12" name="type.typeCreateTime"  datatype="*"  type="text" value="${type.typeCreateTime }" readonly="readonly"/></td> 
	  		</tr>
	  		<tr>
	  			<th>最后更新时间</th>
	  			<td><input id="d12" name="type.typeUpdTime"  datatype="*"  type="text"  value="<%=time %>" readonly="readonly"/></td> 
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
		  			<input type="submit" value="提交" style="height: 28;width: 55" />
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
