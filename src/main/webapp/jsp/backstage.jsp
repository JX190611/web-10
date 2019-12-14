
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/17 0017
  Time: 下午 10:24
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/14 0014
  Time: 上午 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<% String casspsths=request.getContextPath()+"/css/";
	String layuiPath = request.getContextPath()+"/layui/";
	String layuiPath1 = request.getContextPath()+"/js/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>layout 后台大布局 - Layui</title>
	<link rel="stylesheet" href=<%=casspsths+"layui.css"%>>
	<link rel="stylesheet" href=<%=casspsths+"backstyle.css"%>>
	<script type="text/javascript" src=<%=layuiPath+"layui.all.js"%>></script>
	<script type="text/javascript" src=<%=layuiPath+"layui.js"%>></script>
	<script type="text/javascript" src=<%=layuiPath1+"jquery.js"%>></script>
	<script type="text/javascript" src=<%=layuiPath1+"backstage.js"%>></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	<div class="layui-header">
		<div class="layui-logo">layui 后台布局</div>
		<!-- 头部区域（可配合layui已有的水平导航） -->
		<ul class="layui-nav layui-layout-left">
			<li class="layui-nav-item"><a href="">控制台</a></li>
			<li class="layui-nav-item"><a href="">商品管理</a></li>
			<li class="layui-nav-item"><a href="">用户</a></li>
			<li class="layui-nav-item">
				<a href="javascript:;">其它系统</a>
				<dl class="layui-nav-child">
					<dd><a href="">邮件管理</a></dd>
					<dd><a href="">消息管理</a></dd>
					<dd><a href="">授权管理</a></dd>
				</dl>
			</li>
		</ul>
		<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item">
				<a href="javascript:;">
					<img src="http://t.cn/RCzsdCq" class="layui-nav-img">
					${username}
				</a>
				<dl class="layui-nav-child">
					<dd><a href="">基本资料</a></dd>
					<dd><a href="">安全设置</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item"><a href="">退了</a></li>
		</ul>
	</div>

	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
			<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
			<ul class="layui-nav layui-nav-tree"  lay-filter="test">
				<%--<li class="layui-nav-item layui-nav-itemed">
					<a class="" href="javascript:;">用户管理</a>
					<dl class="layui-nav-child">
						<dd><a >管理员登录</a></dd>
						<dd><a href="userlist.action"target="myFrameName">用户查询</a></dd>
						<dd><a href="javascript:;">用户管控</a></dd>
						<dd><a href="jsp/Quanxian.jsp;"target="myFrameName">权限管理</a></dd>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:">文档管理</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;">文档审核</a></dd>
						<dd><a href="javascript:;">文档配置</a></dd>

					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:">日志管理</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;">日志列表</a></dd>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:">系统管理</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;">上传奖励配置</a></dd>
						<dd><a href="javascript:;">注册奖励配置</a></dd>
						<dd><a href="jsp/OutFile.jsp;"target="myFrameName">上传文件</a></dd>
					</dl>
				</li>--%>
				<c:if test="${menumap !=null}">
			<c:forEach items="${menumap}" begin="0" step="1" var="x">
				<li class="layui-nav-item">
					<a class="" href="javascript:;">${x.key}</a>
					<dl class="layui-nav-child">
					<c:forEach items="${x.value}" begin="0" step="1" var="Y">
					<dd><a title="${Y.link}" href="javascript:void(0)" target="myFrameName" onclick="changeURL(this)">${Y.chindname}</a></dd>
					</c:forEach>
					</dl>
				</li>
			</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>

	<div class="layui-body" style="width: 100%;height: 100%;padding-left: 220px">
		<!-- 内容主体区域 -->
				<iframe src="" id="myFrameName" name="myFrameName" scrolling="no" frameborder="0" style="width: 68.5%;height: 90%;padding-top:100px;"></iframe>
	</div>


</div>
<script type="text/javascript" src=<%=layuiPath+"layui.js"%>></script>
<script>
	//JavaScript代码区域
	layui.use('element', function(){
		var element = layui.element;

	});
</script>
<script>
	function changeURL(node){
		var url=$(node).attr("title");
		$("#myFrameName").attr("src",$(node).attr("title"));
		$(node).attr("title",url);
	}
</script>
</body>
</html>
