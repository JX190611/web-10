<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/8 0008
  Time: 下午 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String casspsths=request.getContextPath()+"/css/";
	String layuiPath = request.getContextPath()+"/layui/";
	String path =application.getContextPath();
%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>layout 后台大布局 - Layui</title>
	<link rel="stylesheet" href=<%=casspsths+"layui.css"%>>
	<script type="text/javascript" src=<%=layuiPath+"layui.all.js"%>></script>
	<script type="text/javascript" src=<%=layuiPath+"layui.js"%>></script>

</head>
<body>
<form class="layui-form" action="">
<div class="layui-form-item">
	<label class="layui-form-label">选择角色</label>
	<div class="layui-input-block">
		<select name="interest" lay-filter="aihao" id="xialakuang">
			<option value="2">二级管理员</option>
			<option value="3" >三级管理员</option>
		</select>
	</div>
</div>
	<div class="layui-btn-container">
		<button type="button" class="layui-btn layui-btn-sm" lay-demo="getChecked">确认分配</button>
		<button type="button" class="layui-btn layui-btn-sm" lay-demo="setChecked">勾选指定节点</button>
		<button type="button" class="layui-btn layui-btn-sm" lay-demo="reload">重载实例</button>
	</div>

	<div id="test12" class="demo-tree-more"></div>
<div id="test7" class="demo-tree"></div>

</form>>
<script>

	layui.use(['tree', 'util'], function(){
		var tree = layui.tree
			,layer = layui.layer
			,util = layui.util
			//模拟数据2
		layui.$.ajax({
			type:"POST",//提交7/的方式
			url:"<%=path+"/menutable.action"%>",//提交的地址
			/*data:"msg1="+shuju+"&msg2="+shuju2,//提交的数据*/
			dataType:"json",//希望返回的数据类型
			async: true,//异步操作
			success:function (msg) {//成功的方法  msg为返回数据
				var  ob=JSON.stringify(msg);
				tree.render({
					elem: '#test7'
					,data: msg
					,showCheckbox: true
					,id: 'demoId1'
					,isJump: true //是否允许点击节点时弹出新窗口跳转
					,click: function(obj){
						var data = obj.data;  //获取当前点击的节点数据
						layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
					}
				});

			}
			/*error:function () {//错误的方法
				alert("修改失败")
			}*/
		});
		//开启复选框

		//基本演示
		//按钮事件
		util.event('lay-demo', {
			getChecked: function(othis){
				var checkedData = tree.getChecked('demoId1'); //获取选中节点的数据
				var shuju=JSON.stringify(checkedData);
				var shuju2=layui.$("#xialakuang").val();
				layui.$.ajax({
					type:"POST",//提交7/的方式
					url:"<%=path+"/addrole.action"%>",//提交的地址
					data:"msg1="+shuju+"&msg2="+shuju2,//提交的数据
					dataType:"text",//希望返回的数据类型*/
					async: trualipaye,//异步操作
					success:function (msg) {//成功的方法  msg为返回数据

						layui.alert(msg);
					},
					error:function () {//错误的方法
						layui.alert("修改失败")
					}
				});
				console.log(checkedData);
			}
		});
	});


</script>
</body>
</html>
