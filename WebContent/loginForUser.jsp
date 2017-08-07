<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>榆槡导读前台登陆页</title>
	<link rel="stylesheet" type="text/css" href="css/layout.css">
	<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript">
	$(function($){
		$(".txt").blur(function(){
			var _txtValue = $(this).val();
			if(_txtValue.length == 0){
				$("#error").text("内容不能为空");
			}
		});
		//判断是否有class对应的
		if($("li").hasClass("current")){
			//$("li").text("123");
			//如果找到，做自己想做的事
		}
	});
	</script>
</head>
<body>
	<div class="header">
		<div class="layout">
			<img src="images/logo.png">
			<ul class="menu">
				<li class="current"><a href="#">首页</a></li>
				<li class="abc"><a href="second.html">美文</a></li>
				<li><a href="#">日记</a></li>
				<li><a href="#">诗歌</a></li>
				<li><a href="#">散文</a></li>
				<li><a href="#">排行榜</a></li>
			</ul>
		</div>
	</div>
	<div class="layout">
		<div class="reg-form slider">
			<h3>用户注册</h3>
			<form name="loginForm" method="post" action="doLoginForUser">
				<input type="hidden" value="${param.callback }" name="callback"/>
				<p>用户名:<input type="text" name="username" class="txt" /></p>
				<p>密码:<input type="password" name="userpwd" class="txt"/></p>				
				<p><input type="submit" value="登录" class="btn"/></p>
				<span id="error" style="color:#F00;"></span>
			</form>			
		</div>
		<div class="footer">
			<p class="friends-link">
				<span>友情链接:</span>
				<a href="#">常来网</a>
				<a href="#">大鸟网</a>
				<a href="#">大脸网</a>
			</p>
			<p class="copy">
				&copy;榆槡版权所有 2016
			</p>
		</div>
	</div>
</body>
</html>