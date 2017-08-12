<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>
    <title>XX租房 - 用户注册</title>
    <link type="text/css" rel="stylesheet" href="/Struts2Project/css/style.css" />
    <script type="text/javascript" src="/Struts2Project/js/jquery-3.2.1.js"></script>
</head>
<script type="text/javascript">
    function validateName(tag) {
        var name = $("#name").attr('vName'); // 获取输入框信息
        var url = '/user/validatename?user.username=' + name;
        alert(name);
        $.ajax({
            url: url,
            //data:"user.name:"+name,
            dataType: "json",
            success: function(data) {
                //alert(data);
                if (data == 'true') {
                    if (tag == 'submit') {
                        $("#formasdf").submit();
                    } else {
                        $("#validateName").html("用户名可以使用");
                        $("#validateName").css("color", "green");
                    }
                } else {
                    $("#validateName").html("用户名已存在");
                    $("#validateName").css("color", "red");
                }
            }




        }); //结尾

    }
</script>

<body>



    <script type="text/javascript" src="/Struts2Project/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        //登录
        function doLogin(type) {
            var name = $('#loginName').attr('value');
            var pw = $('#loginPassword').attr('value');
            var url = 'login.action?user.username=' + name + '&user.password=' + pw;
            if (name != null && name != '' && pw != null && pw != '') {

                $.ajax({
                    url: url,
                    type: "post",
                    dataType: "json",
                    async: false,
                    beforeSend: function(data) {
                        $("#loginButton").attr("disabled", true);
                    },
                    success: function(data) {
                        if (data.user != null) {
                            $("#msg").html("&nbsp;<br>");
                            var html = "欢迎 &nbsp; " + data.user.username + "&nbsp;&nbsp;&nbsp;<label class='ui-green'><input type='button' name='search' value='退   出' onclick='document.location=\"logout.action\"'/></label>";
                            $("#topLoginDiv").html(html);
                        } else {
                            $("#msg").html(data.msg);
                            $("#msg").css("color", "red");
                        }

                        $("#loginButton").attr("disabled", false);
                    }
                });
            } else {
                alert("请输入用户名或密码！");
            }
        }
    </script>

    <div id="header" class="wrap">
        <div id="logo"><img src="/images/logo.gif" /></div>

        <div>
            <div id="msg" align="center">&nbsp;<br></div>
        </div>

        <div align="right">
            <form method="post" id="loginFrom" action="user!login.action">
                <div id="topLoginDiv" style="display: inline">
                    用户名:&nbsp;
                    <tr>
                        <td class="tdLabel"></td>
                        <td><input type="text" name="user.name" size="15" value="" id="loginName" required="true" /></td>
                    </tr>


                    &nbsp;密&nbsp;&nbsp;码:&nbsp;
                    <tr>
                        <td class="tdLabel"></td>
                        <td><input type="password" name="user.password" size="15" id="loginPassword" required="true" /></td>
                    </tr>


                    <label class="ui-green">
					<input type="button" name="loginButton" id="loginButton"  value="登录" onclick="doLogin();" />
				</label>
                    <label class="ui-green">
					<input type='button' value='注册' onclick='document.location="/Struts2Project/jsp/register.jsp"'/>
				</label>
                </div>
                <div style="display: inline">
                    <label class="ui-green">
					<input type="button" name="search" value="发布信息" />
				</label>
                </div>
            </form>
        </div>
    </div>
    <div id="regLogin" class="wrap">
        <div class="dialog">
            <dl class="clearfix">
                <dt>新用户注册</dt>
                <dd class="past">填写个人信息</dd>
            </dl>
            <div class="box">
                <form id="formasdf" name="formasdf" action="/user/register" method="post">
                    <div class="infos">
                        <table>
                            <tr>
                                <td class="field">用 户 名：</td>
                                <td><input type="text" name="user.username" value="" id="name" class="text" onblur="validateName()" />&nbsp;
                                    <font color="#c00fff">*</font>
                                </td>
                                <td>
                                    <font color="red">
                                        <div id="validateName"></div>
                                    </font>
                                </td>
                            </tr>
                            <tr>
                                <td class="field">密　　码：</td>
                                <td><input type="password" name="user.password" id="formasdf_user_password" class="text" />&nbsp;
                                    <font color="#c00fff">*</font>
                                </td>
                                <td>
                                    <font color="red"></font>
                                </td>
                            </tr>
                            <tr>
                                <td class="field">确认密码：</td>
                                <td><input type="password" name="repassword" id="formasdf_repassword" class="text" />&nbsp;
                                    <font color="#c00fff">*</font>
                                </td>
                                <td>
                                    <font color="red"></font>
                                </td>
                            </tr>
                            <tr>
                                <td class="field">电　　话：</td>
                                <td><input type="text" name="user.telephone" value="" id="formasdf_user_telephone" class="text" /> </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="field">用户姓名：</td>
                                <td><input type="text" name="user.realname" value="" id="formasdf_user_realname" class="text" /> </td>
                            </tr>
                        </table>
                        <div class="buttons"><input type="button" value="立即注册" onclick="validateName('submit')" /></div>
                    </div>
                    <input type="hidden" name="struts.token.name" value="token" />
                    <input type="hidden" name="token" value="GGKRC3M7GWJSIBOZOMZT22Z2TNFKLHZK" />
                </form>



            </div>
        </div>
    </div>


    <div id="footer" class="wrap">
        <dl>
            <dt>XX租房 &copy; 2010 XXXX 京ICP证1000001号</dt>
            <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
        </dl>
    </div>

</body>

</html>