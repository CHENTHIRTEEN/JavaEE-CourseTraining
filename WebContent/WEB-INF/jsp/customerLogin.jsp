<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</style>
<meta charset="utf-8">
<link href="<%=path %>/static/css/userLogStyle.css" rel='stylesheet'
	type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
</script>
</head>
<body>
	<!-----start-main---->
	<div class="main">
		<div class="login-form">
			<h1>客户登录</h1>
			<div class="head">
				<img src="<%=path %>/static/img/user.png" alt="" />
			</div>
			<form action="cusLogin" method="post">
				<input type="text" name="loginname" class="text" value="USERNAME"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'USERNAME';}">
				<input type="password" name="password" value="Password"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Password';}">
				<div class="submit">
					<input type="submit" value="LOGIN">
				</div>
				<p>
					<a href="toRegister">新用户注册</a>
				</p>
				<p>
					<a href="toChangePassword">忘记密码?</a>
				</p>
				<p>
					<a href="#">管理员登录 
				</p>
			</form>
		</div>
	</div>

</body>
</html>