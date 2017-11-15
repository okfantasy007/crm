<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
    
    <title>My JSP 'updatePsw.jsp' starting page</title>
    <link rel="stylesheet" href="util/Validform_v5.3.2/Validform_v5.3.2/demo/css/style.css" type="text/css"/>
	<link href="util/Validform_v5.3.2/Validform_v5.3.2/demo/css/demo.css" type="text/css" rel="stylesheet" />
    <link href="plugin/jqtransform/jqtransform.css" type="text/css" rel="stylesheet" />
    <style>
		.Validform_checktip{margin-left:10px;}
	</style>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/js.js"></script>
	<script language="javascript" type="text/javascript" src="util/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="util/Validform_v5.3.2/Validform_v5.3.2/demo/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="util/Validform_v5.3.2/Validform_v5.3.2/demo/js/Validform_v5.3.2_ncr_min.js"></script>
	<script type="text/javascript" src="util/passwordStrength-min.js"></script>
	<script type="text/javascript">
		$(function(){
			//$(".registerform").Validform();  //就这一行代码！;
			$(".demoform").Validform({
				tiptype:2,
				usePlugin:{
					passwordstrength:{
						minLen:6,
						maxLen:18
					}
				}
			});
		})
		
		function changechkCode(obj){
			$(obj).attr("src","imageForUpdPwd.jsp?random="+new Date().getTime());
		}
		setInterval(function(){
			changeChknumber($("#randomImg"));
		},1000*60*30);
		function formSubmit(){
			$("#demoform").submit();
		}
		function formReset(){
			$("#demoform").get(0).reset();
		}
	</script>
	
	

  </head>
  
  <body style="background: white;"> 
    	<form action="userAction!updateUserPwd.do" id="demoform" class="demoform" method="post">
    		<input name="userLoginPwd" type="hidden" value=" <s:property value='#session.userLoginPwd'/>"/>
    		<input name="pwdUpdTime" type="hidden" value=" <%=time %>"/>
     				<table width="100%" style="table-layout:fixed;">
     						<tr>
			                    <td class="need" style="width:10px;">*</td>
			                    <td style="width:80px;height: 35px">原密码：</td>
			                    <td style="width:250px;">
			                        <input type="password" style="width: 223px;height: 30px;" class="inputxt"  name="userOrgnalPwd" value="${userOrgnalPwd}" datatype="*6-18" errormsg="密码至少6个字符,最多18个字符！" />       
			                    </td>
			                   	<td><div class="Validform_checktip"></div></td>
			                </tr>			           
			                <tr>
			                    <td class="need" style="width:10px;">*</td>
			                    <td style="width:80px;height: 35px">新密码：</td>
			                    <td style="width:250px;">
			                       	<input type="password" style="width: 223px;height: 30px;" value="${password}" name="password" class="inputxt" plugin="passwordStrength"  datatype="*6-18" errormsg="密码至少6个字符,最多18个字符！" />
                        			<div class="passwordStrength">密码强度： <span>弱</span><span>中</span><span class="last">强</span></div>
			                    </td>
			                   	<td><div class="Validform_checktip"></div></td>
			                </tr> 
			               	<tr></tr>
		                  	<tr></tr>
		                   	<tr></tr>
			                <tr>
			                    <td class="need">*</td>
			                    <td style="width:80px;height: 30px">确认密码：</td>
			                    <td>
			                    	<input type="password" style="width: 223px;height: 30px;"  name="repassword" value="${password}" class="inputxt" recheck="password"  datatype="*6-18" errormsg="两次输入的密码不一致！" />
			                    </td>
			                   	<td><div class="Validform_checktip"></div></td>
			                </tr>
			                <tr>
			                	<td class="need">*</td>
			                	<td style="width:80px;height: 30px">验证码：</td>
			                	<td colspan="2" style="height: 30px;">
									<input name="chkCode" type="text" id="chkCode" maxlength="4"  style="width: 223px;height: 30px;" datatype="*" nullmsg="验证码不能为空"/>
									<img id="randomImg" style="width:75px;height: 30px" src="imageForUpdPwd.jsp?random=<%=new Date().getTime() %>"  onclick="changechkCode(this);"  />			                    
								</td>
								<td><label class="Validform_checktip"></label></td>
			                </tr>
			                <tr>
			                	<td class="need"></td>
			                	<td style="width:80px;height: 30px"></td>
			                	<td colspan="10"><label style="color: red">${errMessage}${chkCodeMessage}</label></td>
			                </tr>
			                <tr>
			                    <td class="need"></td>
			                    <td></td>
			                    <td colspan="2" style="height: 30px;">
			                        <input type="submit" value="提 交" style="height: 40px;"/> 
			                        <input type="reset" value="重 置" style="height: 40px;"/>
			                    </td>
			                </tr>
		            </table>
		</form>     
  </body>
</html>
