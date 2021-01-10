e<%@ page language="java" contentType="text/html; charset=UTF-8"
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
            <h1>修改密码</h1>
            <div class="head">
                <img src="<%=path %>/static/img/user.png" alt="" />
            </div>
            <form action="changePassword" method="post">
                <input type="text" name="loginname" class="text" value="用户名"
                    onfocus="this.value = '';"
                    onblur="if (this.value == '') {this.value = '用户名';}">
                <input type="text" name="newpassword" value="密码"
                    onfocus="this.value = '';"
                    onblur="if (this.value == '') {this.value = '密码';}">
                <input type="text" name="newpasswordconfirm" value="确认密码"
                    onfocus="this.value = '';"
                    onblur="if (this.value == '') {this.value = '确认密码';}">
                <div class="submit">
                    <input type="submit" value="CHANGEPASSWORD">
                </div>
            </form>
        </div>
    </div>

</body>
</html>