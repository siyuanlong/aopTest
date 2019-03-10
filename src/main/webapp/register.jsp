<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户新增</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<form action="${pageContext.request.contextPath}/register" method="post">
		用户ID:<input type="text" name="userId"><span style="color: red">${userId}</span><br>  
		用户名:<input type="text" name="userName"><span style="color: red">${userName}</span><br> 
		密码:<input type="text" name="password"><span style="color: red">${password}</span><br> 
		密码:<input type="text" name="email"><span style="color: red">${email}</span><br> 
		<input type="submit" value="用户注册">
	</form>
</body>
</html>
