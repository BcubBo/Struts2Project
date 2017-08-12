<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>XX租房 - 用户管理</title>
	<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
	<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.js"></script>
</head>
<body>
	<s:include value="/header.jsp"></s:include>
	<s:include value="/search_list.jsp"></s:include>
	<s:include value="/house_list.jsp"></s:include>
	<s:include value="/footer.jsp"></s:include>
</body>
</html>