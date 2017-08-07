<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@  page import="com.ys.biz.*,com.ys.entity.*,java.util.*" %>    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head><meta charset="utf-8"/>
	<title>榆槡导读-${requestScope.wenzhang.title}</title>
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
	<script>
		$(function(){
			$("#pinglunbtn").click(function(){
				
				$.post("addcomment",{wzid:$("#wzid").val(),nr:$("#nr").val()},function(data){
					$(".latests").prepend(data);
					
				});
			});
			//点赞
			$(".zan-href").click(function(){
				
				var _el = $(this);
				
				$.post("zan",{id:_el.attr("data-id")},function(data){
					
					if(data == "ok"){
						_el.prev().text(parseInt(_el.prev().text())+1);
					}
				});
			});
		});
	</script>
</head>
<body>

<!--头 -->
<div class="header">
    <div class="layout">
    <!--logo图片 -->
	
		<img src="images/yusang.png">

	<!--菜单栏 -->
    
	<ul class="menu">
	<li class="current"><a href="#">首页</a></li>
	
	<c:forEach items="${sessionScope.menus}" var="menu" varStatus="sts">
	<c:if test="${ sts.index % 2 ==1}">
	<li><a href="${menu.url}"> ${menu.title} </a></li>
	</c:if>
	<c:if test="${sts.index % 2 !=1 }">
	<li><a href="${menu.url}" style="color:#f00;"> ${menu.title} </a></li>
	</c:if>
	</c:forEach>
	</ul>
    </div>
</div>	 
		  
<!--中间大框子 -->
<div class="layout">
   
    <!--中间的内容 -->
    <div class="content">
         <!--主内容 -->
        <div class="cnt-main">
         <h3>${requestScope.wenzhang.title}</h3>	
         <div class="wznr">
         <p>${requestScope.wenzhang.neirong}</p>
        
         <h4 class="">最热评论</h4>
         <ul class="comment-list hots">
         <c:forEach items="${requestScope.hots }" var="comment">
         <li class="pinglun">
         <p class="title">
          <span  class="nicheng">${comment.yonghu.nicheng }</span>
          <span class="shijian">${comment.shijian }</span>
         </p>
         <p class="nr">${comment.neirong}</p>
         <p class="zan">
         <span class="zan">${ comment.zan}</span>
         <a href="javascript:void(0)" class="zan-href" data-id="${comment.id }">赞</a>
         
    
         </p>
        
         </li>
         </c:forEach>
         </ul>
         <h4>最新评论</h4>
         <ul class="comment-list latests">
         <c:forEach items="${requestScope.latests }" var="comment">
         <li class="pinglun">
         <p class="title">
          <span  class="nicheng">${comment.yonghu.nicheng }</span>
          <span class="shijian">${comment.shijian }</span>
         </p>
         <p class="nr">${comment.neirong}</p>
         <p class="zan">
         <span class="zan">${ comment.zan}</span>
         <a href="javascript:void(0)" class="zan-href" data-id="${comment.id }">赞</a>
         
    
         </p>
        
         </li>
         </c:forEach>
         </ul>
         
         <div class="comment-form">
         <c:if test="${empty sessionScope.yonghu}">
         <p style="text-align:center;padding:10px;">请先<a href="loginForUser.jsp?callback=articledetails?id=43" style="color:#000">登录</a>再评论</p>
         </c:if>
        <c:if test="${not empty sessionScope.yonghu }">
        <h3>哥要评论</h3>
        <form style="text-align:center;">
        <textarea style="width:680px;height:120px;" id="nr"></textarea>
        <input type="hidden" id="wzid" name="wzid" value="${param.id }" />
        <input type="button" value="评论" id="pinglunbtn"/>
        </form>
        </c:if>
         </div>
         </div>
         </div>
        
         
         
    	<!--子内容 -->
    	<div class="cnt-sub">
        <!--搜索框 -->
        <div class="search">
        <form action="#" method="post" class="sou" > 
            <input type="text" class="search-cnt" name="search-cnt" placeholder="请输入要搜索的内容" ><input type="submit" class="sousuo" name="sousuo" value="搜索">
            </form>
        </div>
<!--关注框 -->
<div class="follow sub-block">
    <div class="bd">
            <ul class="clear">
                <li class="kaung1">
                <p class="pic"><a href="#">&nbsp</a></p>
                    <p class="title">新浪微博</p>
                </li >
                  <li class="kaung2">
                <p class="pic"><a href="#">&nbsp</a></p>
                    <p class="title">微信</p>
                </li >
                   <li class="kaung3">
                <p class="pic"><a href="#">&nbsp</a></p>
                    <p class="title">QQ</p>
                </li >
            </ul>
        </div>
    </div>
        <div class="ce1">
        <h3>安妮今日阅读</h3>
    		<ul>
            <li class="a">
                   <a href="wen1.html">推开窗，给心灵一片蓝天</a>
                   <span>39000次浏览</span>
                   </li>
            <li class="a" ><a href="wen1.html">悲伤他不说话</a><span>39000次浏览</span></li>
            <li class="a"><a href="wen1.html">牵挂，翻瘦了的童话</a><span>39000次浏览</span></li>
            <li class="a"><a href="wen1.html">走在自然里，即使一人，也不觉得孤独</a><span>39000次浏览</span></li>
            <li class="a"><a href="wen1.html">动情日，自控悲</a><span>39000次浏览</span></li>
            <li class="a"><a href="wen1.html">花开一半，肥了思念</a><span>39000次浏览</span></li>
            <li class="a"><a href="wen1.html">一些人，一些事，这一年渐渐的懂了</a><span>39000次浏览</span></li>
            <li class="a"><a href="wen1.html">他们口中的爱情</a><span>39000次浏览</span></li>
            <li class="a"><a href="wen1.html">生命</a><span>39000次浏览</span></li>
            <li class="a"><a href="wen1.html">一种深久的不肯</a><span>39000次浏览</span></li>
    
        </ul>
        </div>
        
        <div class="ce2">

            <h4>小编推荐阅读</h4>
            
             <dl class="info1">
                 <dt class="info1_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116010024194.jpg"></dt>
                 <dd class="info1_2"><strong><a href="wen2.html">写给自己</a></strong></dd>
                 <dd>天空中没有翱翔的痕迹，而我已飞过。时间如流沙般……</dd>
             </dl>
             <dl class="info2">
                 <dt class="info2_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116011153321.jpg"></dt>
                 <dd class="info2_2"><strong><a href="wen2.html">为什么一路在寻找，却一路</strong></a></dd>
                 <dd>最初我们恋恋不舍，最终我们始乱终弃，最初我们甜言蜜语……</dd>
             </dl>
             <dl class="info3">
                 <dt class="info3_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116014320393.jpg"></dt>
    
                 <dd class="info3_2"><strong><a href="wen2.html">朋友的爱情</a></strong></dd>
                 <dd>男孩遇上女孩，属于一次偶然。一次伟大的爱情历程……</dd>
             </dl>
             <dl class="info4">
                 <dt class="info4_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116014328230.jpg"></dt>
                 <dd class="info4_2"><strong><a href="wen2.html">忆，那一季爱情</a></strong></dd>
                 <dd>岁月悄悄走过，记忆慢慢沉淀。青春早已荒芜，忆那一季……</dd>
             </dl>
             <dl class="info5">
                 <dt class="info5_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116014329708.jpg"></dt>
                 <dd class="info5_2"><strong><a href="wen2.html">心路</a></strong></dd>
                  <dd>世人都会有迷茫的时候，圣人也不例外，站在人生的十字路口……</dd>
             </dl>
             <dl class="info6">
                 <dt class="info6_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116014331766.jpg"></a></dt>
                 <dd class="info6_2"><strong><a href="wen2.html">有你在就没有乱荡不安</a></strong></dd>
                 <dd>在我眼睛里你是如此单纯，你是如此和我像</dd>
             </dl>
             <dl class="info7">
                 <dt class="info7_1"><a href="wen2.html"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116014937771.jpg"></a></dt>
                 <dd class="info7_2"><strong><a href="wen2.html">那一缕，逝去的阳光</a></strong></dd>
                 <dd>清晨，推开窗户，依旧寒冷的空气……</dd>
             </dl>
             <dl class="info8">
                 <dt class="info8_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116014938119.jpg"></a></dt>
                 <dd class="info8_2"><strong><a href="wen2.html">日落，梦中的烟火</a></strong></dd>
                 <dd>微微的拉开窗帘，从叶缝中钻出一缕阳光……</dd>
             </dl>
       
    </div>
    </div>
	</div>
    </div>

</div>   </div>
            </div>
            </div>
            </div>
            </div>
            </div>
            </div>
            </div>
            </div>
<!--末尾：版权 -->
<div class="footer">
	<h2>&copy;——致于桑，霖哥版权所有2016</h2>
</div>
</body>
</html>