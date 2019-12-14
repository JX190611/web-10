<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/17 0017
  Time: 下午 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
	String casspsths = request.getContextPath()+"/css/";
	String layuiPath = request.getContextPath()+"/layui/";
%>

<html>
<head>
	<meta charset="UTF-8">
	<title>后台登录</title>
	<link rel="stylesheet" type="text/css" href=<%=casspsths+"layui.css"%>>
	<script type="text/javascript" src=<%=layuiPath+"layui.all.js"%>></script>
	<script type="text/javascript" src=<%=layuiPath+"layui.js"%>></script>
</head>
<body>

<!-- 你的HTML代码 -->
<form class="layui-form" action="Login.action" method="post"  style="margin-left: 500px ;margin-top: 250px;">
	<div class="layui-form-item" style="margin-top: 130px">
		<label class="layui-form-label">账号</label>
		<div class="layui-input-block">
			<input type="text" name="username" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input" style="width: 200px">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">密码</label>
		<div class="layui-input-inline">
			<input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" style="width: 200px">
		</div>

	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>

		</div>
	</div>
</form>
<script>
	//Demo
	layui.use('form', function(){
		var form = layui.form;
		//监听提交
		form.on('submit(formDemo)', function(data){
			layer.msg(JSON.stringify(data.field));
			return false;
		});
	});
</script>

<script type="text/javascript" src=<%=layuiPath+"layui.js"%>></script>
<script>
	//一般直接写在一个js文件中
	layui.use(['layer', 'form'], function(){
		var layer = layui.layer
			,form = layui.form;

		layer.msg('管理员后台登录');
	});
</script>
</body>
</html>
