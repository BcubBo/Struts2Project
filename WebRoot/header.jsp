<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
//登录
function doLogin(type) {
 	var name =  $('#loginName').val();//attr('value');
	var pw = $('#loginPassword').val();//attr('value');
	var url = 'user/login.action?user.username='+name+'&user.password='+pw; 
	if (name != null && name!='' && pw != null && pw!='') {
		//alert(name);
		//alert(pw);
		$.ajax({
			url: url,
			type:"post",
			dataType: "json",
			async: false,
			beforeSend: function(data) {
				$("#loginButton").attr("disabled", true);
			},
			success: function(data) {
				//alert(data.msg);
				 if(data.user!=null){
					 $("#msg").html(data.msg);	
					 $("#msg").css("color","yellowgreen");	 
					var html = "欢迎 &nbsp; "+data.user.username+
					"&nbsp;&nbsp;&nbsp;<label class='ui-green'>"+
					"<input type='button' name='search' value='退   出'"+
					" onclick='document.location=\"${pageContext.request.contextPath}/user\/logout.action\"'/>"+
					"</label>";
					$("#topLoginDiv").html(html);
					//document.getElementById('topLoginDiv').innerHTML = html;
				}else{
					$("#msg").html(data.msg);
					$("#msg").css("color","red");
				}
				
				$("#loginButton").attr("disabled", false);
			}
		});
	}else{
		alert("请输入用户名或密码！");
	} 
}
</script>

<div id="header" class="wrap">
	<div id="logo"><img src="<%=path%>/images/logo.gif" /></div>
	
	<div >
		<div id="msg" align="center">&nbsp;<br></div>
	</div>

	<div align="right">
		<form method="post" id="loginFrom" action="${pageContext.request.contextPath }/user/login.action">
			<div id="topLoginDiv" style="display: inline">
				用户名:&nbsp;<s:textfield name="user.name" id="loginName" required="true" size="15"/>
				&nbsp;密&nbsp;&nbsp;码:&nbsp;<s:password name="user.password"  id="loginPassword" required="true" size="15"/>
				<label class="ui-green">
					<input type="button" name="loginButton" id="loginButton"  value="登录" onclick="doLogin();" />
				</label>
				<label class="ui-green">
					<input type='button' value='注册' onclick='document.location="<%=path%>/register.jsp"'/>
				</label>
			</div>
			<div style="display: inline">
				<label class="ui-green">
					<input type="button" name="search" value="发布信息" 
					onclick="document.location='add_house.jsp'"
					/>
				</label>	
			</div>
		</form>
	</div>
</div>
<s:if test="#session.LOGIN_USER!=null">

	<script type="text/javascript">

		var html = "欢迎 &nbsp; ${sessionScope.LOGIN_USER.username}"+
		"&nbsp;&nbsp;&nbsp;<label class='ui-green'>"+
		"<input type='button' name='search' value='退   出'"+
		" onclick='document.location=\"${pageContext.request.contextPath}/user\/logout.action\"'/>"+
		"</label>";
		document.getElementById('topLoginDiv').innerHTML = html;
	</script>



</s:if>