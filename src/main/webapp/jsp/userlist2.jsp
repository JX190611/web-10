<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/12 0012
  Time: 下午 4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String casspsths=request.getContextPath()+"/css/";
	String layuiPath = request.getContextPath()+"/layui/";
	String JsPath = application.getContextPath()+"/js/";

%>
<html>
<head>
	<meta charset="utf-8">
	<title>前台登录</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href=<%=casspsths+"layui.css"%>>
	<script type="text/javascript" src=<%=layuiPath+"layui.all.js"%>></script>
	<script type="text/javascript" src=<%=layuiPath+"layui.js"%>></script>
</head>
<body>

</body>
</html>
