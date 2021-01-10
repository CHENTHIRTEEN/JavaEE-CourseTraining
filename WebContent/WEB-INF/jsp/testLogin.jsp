<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎：${requestScope.account.loginname }
<br>account对象名称：${requestScope.account.loginname }<br/>
<br>account对象密码：${sessionScope.account.password }<br/>
</body>
</html>