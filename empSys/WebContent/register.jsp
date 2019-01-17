<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
		姓名：<input type="text" name="name" id="name" >
		<br>
		密码：<input type="password" name="password" id="password">
		<br>
		性别： <label><input type="radio" name="gender"  value="男">男</label>
			 <label><input type="radio" name="gender"  value="女">女</label>
		<br>
		 年龄：<input type="text" name="age" id="age">
		 <br>
		 入职时间：<input type="date" name="hirdate" id="hirdate">
		 <br>
		 薪资：<input type="text" name="salary" id="salary">
		 <br>
		 电话：<input type="text" name="phone" id="phone">
		 <br>
		 邮箱：<input type="text" name="emali" id="emali">
		 <br>
		 <input type="reset" value="清空">
		 <input type="submit" value="注册">
	</form>
	
</body>
</html>