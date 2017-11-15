<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.chdsxt.crm.po.Type"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    java.util.Date currentTime = new java.util.Date();  
    String time = simpleDateFormat.format(currentTime).toString();   
%>
<%
	List<Type> typeList = (List<Type>)request.getAttribute("typeList");
	/*
	for(int i=0;i<typeList.size();i++){
		Type type = typeList.get(i);
		out.print("----- "+type.getTypeName()+" -----");
	}
	*/
  	session.setAttribute("typeList",typeList);//将typeList放入session，在Action中就可以获取到了
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryTypeList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<script src="util/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="util/wbox/jquery1.4.2.js"  ></script>
    <script type="text/javascript" src="util/wbox/wbox-min.js"  ></script>
    <link rel="stylesheet" type="text/css" href="util/wbox/wbox/wbox-min.css">
	
	<script type="text/javascript">
			var wbox;
    		function addType(){
				 wbox = $().wBox({
				 	 title: "新增分类",
					 requestType: "iframe",
					 iframeWH:{width:600,height:180},
					 target:"type/addType.jsp"
					});
				 wbox.showBox();
			}
			
			function updateType(typeId){
				 var typeName = $("#curTypeName_"+typeId).val();
				 wbox = $().wBox({
				 	 title: "修改 "+typeName,
					 requestType: "iframe",
					 iframeWH:{width:600,height:180},
					 target:"typeAction!updateBeforeType.do?type.typeId="+typeId
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
    <table   id="t1"  width="100%"  border=1>
    			<tr>
    				<td colspan="6" style="border: none;text-align: center">----------- 查看/修改分类 -----------</td>
    			</tr>
    	 		<tr>
    	 			<th>分类id</th>
    	 			<th>分类名称</th>
    	 			<th>分类描述</th>
    	 			<th>分类创建时间</th>
    	 			<th>最后更新时间</th>
    	 			<th>操作</th>
    	 		</tr>
    	 		<s:iterator  value="typeList"  var="t"> 
    	 			<tr>
    	 				<td style="text-align: center">
	    	 				<s:property  value="#t.typeId"/>
    	 				</td>
    	 				<td style="text-align: center">
    	 					<s:property  value="#t.typeName"/>
    	 					<input id="curTypeName_<s:property  value='#t.typeId'/>" type="hidden" value="<s:property  value='#t.typeName'/>"/>
    	 				</td>
    	 				<td style="text-align: center"><s:property  value="#t.typeDesc"/></td>
    	 				<td style="text-align: center"><s:date name="#t.typeCreateTime" format="yyyy-MM-dd HH:mm:ss"/></td>
    	 				<td style="text-align: center"><s:date name="#t.typeUpdTime" format="yyyy-MM-dd HH:mm:ss"/></td>
    	 				<td style="text-align: center">
    	 					<s:if test="(#session.limitsCode&2)==2">
    	 						<button onclick="updateType(<s:property  value='#t.typeId'/>);" >修改分类</button>
    	 						<!--<a href="typeAction!updateBeforeType.do?type.typeId=<s:property  value='#t.typeId'/>">修改分类</a>-->
    	 					</s:if>	
   	 				 	</td>
    	 			</tr>
    	 		</s:iterator>
    	 		<tr>
	    	 		<s:if test="(#session.limitsCode&8)==8">
    	 				<td align="center" style="border: none;">
    	 						<button onclick="addType();" >新增分类</button>
    	 					    <!--<a href="typeAction!addBeforeType.do">新增分类</a>-->
    	 				</td>
	    	 		</s:if>
	    	 			<td style="border: none;"></td>
	    	 			<td style="border: none;"></td>
	    	 			<td style="border: none;"></td>
	    	 			<td style="border: none;"></td>
 	 					<td colspan="1" align="center" style="border: none;">
   	 						<button onclick="window.location.href='xlsExpAction.do';" >导出</button>
   	 					</td>
    	 		</tr>
    	 </table>
  </body>
</html>
