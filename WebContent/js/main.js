function changeCnt(){

	//通过ID获取元素
	var el = document.getElementById("gaibian");
	//改变元素内容
	el.innerHTML = "<h1>人要舒服就想睡觉</h1>";
}

function outout(){

	//通过ID获取元素
	var el = document.getElementById("gaibian");
	//改变元素内容
	el.innerHTML = "<img src='images/865_100_1.jpg' style='width:100%;height:100px;'/>";

}


function ckAll(){

	var cks = document.getElementsByName("abc");

	for(var i = 0; i < cks.length; i ++){

		cks[i].checked = true;
	}
}

function ckFan(){

	var cks = document.getElementsByName("abc");

	for(var i = 0; i < cks.length; i ++){

		if(cks[i].checked != true){
			cks[i].checked = true;
		} else {
			cks[i].checked = false;
		}
	}

}

function ckGensui(){

	var fz = document.getElementById("fuzhu");

	var cks = document.getElementsByName("abc");

	for(var i = 0; i < cks.length; i ++){

		cks[i].checked = fz.checked;
	}
}


function displayTime(){

	//创建Date对象
	var now = new Date();

	//年月日
	var y = now.getFullYear();
	var M = now.getMonth() + 1;
	var d = now.getDate();

	//时分秒
	var h = now.getHours();
	
	h = (h < 10)?("0" + h):h;

	var m = now.getMinutes();

	if(m == 48){
		clearInterval(ival);
	}

	var s = now.getSeconds();



	var str = y + "/" + M + "/" + d + " " + h + ":" + m + ":" + s;


	document.getElementById("t").innerHTML = str;
}



function changeImgSize(img){

	var w = parseInt(img.style.width);
	var h = parseInt(img.style.height);

	img.style.width = w * 2 + "px";
	img.style.height = h * 2 + "px";
	img.style.top = -h / 2 + "px";
	img.style.left = -w / 2 + "px";
}


function changeClass(el){

	el.className = "contentarticlemdlactive";
}

/**************表单验证开始***************/
function checkUserName(){
	//document.表单名字.元素名字
	var userNameTxt = document.regForm.username;
	//得到对应控件的值
	var vUserName = userNameTxt.value;

	if(vUserName == null || "" == vUserName){

		document.getElementById("error").innerHTML = "用户名不能为空";

		return false;
	}

	return true;
}

function checkUserPwd(){

	var userPwd = document.regForm.userpwd;

	var vUserPwd = userPwd.value;

	if(vUserPwd.length < 6){

		document.getElementById("error").innerHTML = "密码长度要大于6";

		return false;
	}

	return true;
}

function checkForm(){

	if(checkUserName() && checkUserPwd()){
		return true;
	} else {
		return false;
	}
}

var count = 1;

function slide(){

	for(var i = 1; i <= 3; i ++){
		var pic = document.getElementById("s" + i);
		pic.style.display = "none";
	}

	document.getElementById("s" + (count%3+1)).style.display = "block";

	count ++;
}

setInterval("slide()",2000);