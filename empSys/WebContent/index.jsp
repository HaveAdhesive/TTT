<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>Examples</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		
		<meta name="description" content="">
		<meta name="keywords" content="">
		<link href="" rel="stylesheet">
</head>
<body>

	<script type="text/javascript" src="js/xiantiao.js" ></script>
	
	<h1>欢迎使用！！！管理系统</h1>
	
	<hr width="95%">
	 
	<c:if test="${sessionScope.emp == null }">
		<a href="${pageContext.request.contextPath }/register.jsp">注册</a>
		<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
	</c:if>
	
	<c:if test="${sessionScope.emp != null }">
		<a href="${pageContext.request.contextPath }/EmpListServlet">员工列表</a>
		<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
		
		<div>上次登录时间：${requestScope.lastTime }</div>
	</c:if>

</body>
</html>