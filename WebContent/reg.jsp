<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>榆槡导读前台注册页</title>
	<link rel="stylesheet" type="text/css" href="css/layout.css">
	<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript">
	/* var xmlhttp;
	function checkUserName(){
		//创建对象
		try{
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e){
			try{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e){
				xmlhttp = new XMLHttpRequest();
			}
		}
		if (!xmlhttp) {
			alert("无呢");
			return false;
		}
		//这是回调函数
		xmlhttp.onreadystatechange = dealResult; 
		//打开连接，设置提交方式
		xmlhttp.open("post", "ajaxckname?username="+document.getElementById("username").value, true);
		//POST请求头
		xmlhttp.setRequestHeader("Content-type",
		"application/x-www-form-urlencoded");
		xmlhttp.send(null);
	}
	
	function dealResult(){
		
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			if(xmlhttp.responseText == "a"){
				document.getElementById("error").innerText = "用户名已经存在";
			}
		}
	} */
	
	//当鼠标移出登陆名选框，执行异步提交检查登录名是否已存在操作
	$(function($){
		$("#username").blur(function(){
			$.post("ajaxckname",{username:"username".val()},function(data){
				if(data=="a"){
					$("#error").text("用户名已经存在");
				}
			});
			});
		//上传头像
		$("#touxiang").change(function(){
			$("#upform").submit();
		/* //判断是否有class对应的
		if($("li").hasClass("current")){
			//$("li").text("123");
			//如果找到，做自己想做的事 */
		}
	});
	</script>
</head>
<body>
	<div class="header">
		<div class="layout">
			<img src="images/yusang.png">
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
			<form name="regForm" method="post" action="doreg" enctype="multipart/form-data" >
				<p>用户名:<input type="text" name="username" class="txt" /></p>
				<p>密码:<input type="password" name="userpwd" class="txt"/></p>
				<p>重复密码:<input type="password" name="userrepwd" class="txt"/></p>
				<p>昵称:<input type="text" name="nicheng" class="txt"/></p>
			    <p>性别:<input type="radio" name="xingbie" value="1" checked="checked"/>男
				<input type="radio" name="xingbie" value="0"/>女</p>
				<p>爱好:<input type="checkbox" name="aihao" value="sanwen"/>散文
				<input type="checkbox" name="aihao" value="shige"/>诗歌
				<input type="checkbox" name="aihao" value="wenyi"/>文艺
				<input type="checkbox" name="aihao" value="jiaoqing"/>伤感
				<input type="checkbox" name="aihao" value="zhonger"/>励志</p>
				<p><input type="submit" value="注册" class="btn"/></p>
				<span id="error" style="color:#F00;"></span>
			</form>	
			
			<form target="up" style="width:300px;height:300px;position:absolute;right:500px;top:250px;" id="upform" action="upload" method="post" enctype="multipart/form-data">
			
			<iframe src="image.jsp" name="up" width="200" height="200"></iframe>
			<input type="file" name="touxiang" class="txt"/>
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