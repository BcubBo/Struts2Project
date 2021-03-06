<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>XX租房 - 用户注册</title>
	<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
	<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.js"></script>
	<meta content="charset">
</head>
<script type="text/javascript">
	function validateName(tag){
		var name = $("#name").val();//attr('vName');// 获取输入框信息
		var url = 'user/validateName.action?user.username='+name;
		//alert(name);
		$.ajax({
			url: url,
			//data:"user.username:"+name,//所有的属性的命名必须和pojo中的一一对应
			dataType: "json",
			success: function(data) {
				
				//alert(data.checkResult);
				if(!data.checkResult){
					//小心布尔值的问题
					
					if(tag=='submit'){
						alert("进入提交方法前");
						$("#formasdf").submit();
					}else{ 
						$("#validateName").html("用户名可以使用");
						$("#validateName").css("color","yellowgreen");
					}
				}else{
					$("#validateName").html("用户名已存在");
					$("#validateName").css("color","red");
				} 
			}



		
		});//结尾
		
	}
</script>

<body>
	<s:include value="/header.jsp"></s:include>
	<div id="regLogin" class="wrap">
		<div class="dialog">
			<dl class="clearfix">
				<dt>新用户注册</dt>
				<dd class="past">填写个人信息</dd>
			</dl>
			<div class="box">
				<s:form action="user/register.action" id="formasdf"  theme="simple" >
					<div class="infos">
						<table>
							<tr>
								<td class="field">用 户 名：</td>
								<td><s:textfield  type="text" cssClass="text" name="user.username" id="name" onblur="validateName()" />&nbsp;<font color="#c00fff">*</font></td>
								<td><font color="red" ><s:fielderror fieldName="user.username" id ="vName"><div id="validateName"></div></s:fielderror></font></td>
							</tr>	
							<tr>
								<td class="field">密　　码：</td>
								<td><s:password type="password" cssClass="text" name="user.password" />&nbsp;<font color="#c00fff">*</font></td>
								<td><font color="red" ><s:fielderror fieldName="user.password" ></s:fielderror></font></td>
							</tr>				
							<tr>
							<td class="field">确认密码：</td>
							<td><s:password type="password" cssClass="text" name="repassword" />&nbsp;<font color="#c00fff">*</font> </td>
							<td><font color="red" ><s:fielderror fieldName="repassword" ></s:fielderror></font></td>
						</tr>	
						<tr>
							<td class="field">电　　话：</td>
							<td><s:textfield type="text" cssClass="text" name="user.telephone" /> </td>
							<td></td>
						</tr>
						<tr>
							<td class="field">用户姓名：</td>
							<td><s:textfield type="text" cssClass="text" name="user.realname" /> </td>
						</tr>
						</table>
						<div class="buttons"><input type="button"  value="立即注册" onclick="validateName('submit')" /></div>
					</div>
					<s:token/>
				</s:form>
			</div>
		</div>
	</div>
	<s:debug/>
	<s:include value="footer.jsp"></s:include>
</body>
</html>