<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	    <base href="<%=basePath%>">
	<!--Title-->
	<title>哈哈</title>
	<!--Basic page styles-->
	<style>
	html {
		font-family: 'Open Sans', Helvetica, Arial, sans-serif;
		background-color: #fff;
		font-weight: 300;
	}
	body {
		margin: 0px;
		padding: 0px;
	}
	.documentation {
		width: 800px;
		margin: 0px auto;
		padding: 100px 0px;
	}
	.documentation h3, p {
		text-align: center;
	}
	.documentation h3 {
		margin: 0px 0px 20px 0px;
		font-weight: 300;
		font-size: 2em;
	}
	a, a:visited {
		color: #E54028;
		text-decoration: none;
	}
	a:hover {
		color: #c22d18;
		text-decoration: underline;
		cursor: pointer;
	}
	</style>
	<!--Required libraries-->
	<script src="js/min/jquery-v1.10.2.min.js" type="text/javascript"></script>
	<script src="js/min/modernizr-custom-v2.7.1.min.js" type="text/javascript"></script>
	<script src="js/min/jquery-finger-v0.1.0.min.js" type="text/javascript"></script>
	<!--Include flickerplate-->
	<link href="css/flickerplate.css"  type="text/css" rel="stylesheet">
	<script src="js/min/flickerplate.min.js" type="text/javascript"></script>
	<!--Execute flickerplate-->
		<script>
			$(document).ready(function(){
				$('.flicker-example').flicker();
			});
		
		  	function pe(event){
		  	 	var eve = window.event || event;
		  	 	var key = eve.keyCode || eve.charCode;
		  	 	if(key == 27){
		  	 		//alert("asdasd");
		  	     	//window.location.href = "PhotoServlet?opt=list&aid="+${aid};
		  	     	//window.location.href = "PhotoServlet?opt=list&aid="+1;
		  	     	window.location.href = "http://www.baidu.com";
		  	 	}
		  	}
		</script>
	</head>

	<body onkeydown="pe(event);" style="width: 100%;height: 100%;" >
	<!--Basic example-->
		<div class="flicker-example" data-block-text="false">
		  	<ul>
		  		<s:iterator value="#application.photoList" var="p">
		  			<li data-background="${p }">
				    </li>
		  		</s:iterator>				  
	  		</ul>
		</div>
		<!--Documentation link-->
		<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
		</div>
	</body>
</html>