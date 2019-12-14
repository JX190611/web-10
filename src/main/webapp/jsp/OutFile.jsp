<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/20 0020
  Time: 上午 12:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String casspsths=request.getContextPath()+"/css/";
	String caspsths=request.getContextPath()+"/layui/css/";
	String path = application.getContextPath();
	String layuiPath = request.getContextPath()+"/layui/";
	String JsPath = application.getContextPath()+"/js/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Layui</title>

	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href=<%=casspsths+"layui.css"%>>
	<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<button type="button" class="layui-btn" id="test3"><i class="layui-icon"></i>上传文件</button>
<script type="text/javascript" src=<%=layuiPath+"layui.js"%>></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
	layui.use('upload', function(){
		var $ = layui.jquery
			,upload = layui.upload;
		upload.render({
			elem: '#test3'
			,url: '<%=path+"/upload.action"%>'
			,accept: 'file' //普通文件
			,done: function(json){
				alert(json.code);
				if(json.code === 0){
					return layer.msg('上传失败');
				}
				//上传成功
				if(json.code > 0) {
					return layer.msg('上传成功');
				}
				console.log(json)
			}
		});
	});
</script>
	</body>

</html>
