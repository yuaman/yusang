<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@  page import="com.ys.biz.*,com.ys.entity.*,java.util.*" %>    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
<head><meta charset="utf-8"/>
	<title>榆槡导读--前台首页</title>
	<link rel="stylesheet" type="text/css" href="css/main.css">
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
    <!--轮播 -->
    <div class="slider">
    	<!--一个大图片 -->
        <img src="images/Annie/1160_560_1.jpg">
        <ul class="bar">
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    <!--中间的内容 -->
    <div class="content clear">
         <!--主内容 -->
         
        
    	<div class="cnt-main">
           <!--父分类 -->
            
           <% 
           Map<Fenlei,List<Fenlei>> fenleimap = (Map<Fenlei, List<Fenlei>>)request.getAttribute("fenleimap");
           Set<Fenlei> keys = fenleimap.keySet();
           for(Fenlei key:keys){
        
           %> 
           <div class="article ">
            <!--次分类 -->
          <div class="hd">
          <h3><%=key.getTitle()%> </h3>
            <ul class="menu">
            <!--根据key取得value：List  -->
            <%List<Fenlei> list = fenleimap.get(key);
                   for(Fenlei fenlei:list){
            %>>
            <li><a href="shenme.jsp?id=<%=fenlei.getId()%>"><%=fenlei.getTitle() %></a></li>
             <li class="split">/</li>
            <%} %> 
           </ul>
           <a href="#" class="more">more</a>   
           </div>
            <!--文章部分三大框 -->
            <div class="layout2">
            <!--第三分之一框 -->
               <div class="layout3">
               
                <a href="wen1.html"><img src="images/Annie/20150115114439292.jpg" width="283px" alt="时光如流沙般从直接划过" height="330px"></a>
                <p>要亲密，但不要无间。人与人之间必须有一定的距离，相爱的人也不例外，婚姻之所以容易变成悲剧，就是因为在客观上破坏了……</p>
             </div> 
             <!--第三分之二框 -->  
             <div class="layout4">
                      
               <dl class="info1">
                    <dt class="info1_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116114548989.jpg"></a></dt>
                    <div class="info1_2">
                    <dd><a href="wen2.html"><strong>把烦恼写在沙滩上</strong></dd>
                    <dd>有一个中年人，年轻时追求的家庭……</dd>
                    </div>
                </dl>
                <dl class="info2">
                    <dt class="info2_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116114550150.jpg"></a></dt>
                    <div class="info2_2">
                    <dd><a href="wen2.html"><strong>爱的距离</strong></dd>
                    <dd>要亲密，但不要无间，人与人之间……</dd>
                    </div>
                </dl>
                <dl class="info3">
                    <dt class="info3_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116114550533.jpg"></a></dt>
                    <div class="info3_2">
                    <dd><a href="wen2.html"><strong>生活是我们自己的事情</strong></dd>
                    <dd>生活是我们自己的事情，未来的路……</dd>
                    </div>
                </dl>
                <dl class="info4">
                    <dt class="info4_1"><a href="wen2.html"><img src="images/Annie/thumb_80_60_20150116125038233.jpg"></a></dt>
                    <div class="info4_2">
                    <dd><a href="wen2.html"><strong>浮躁</strong></dd>
                    <dd>秋日的阳光那么温暖，秋叶金黄飘……</dd>
                    </div>
                </dl>
             </div>
             <!--第三分之三框 -->     
             <div class="layout5">
               <ul>
                   <li><a href="wen2.html">[人生哲理]把烦恼写在沙滩上</a></li>
                   <li><a href="wen2.html">[人生哲理]爱的距离</a></li>
                   <li><a href="wen2.html">[人生哲理]生活是我们自己的事情</a></li>
                   <li><a href="wen2.html">[人生哲理]浮躁</a></li>
                   <li><a href="wen2.html">[人生哲理]人要怎么活着</a></li>
                   <li><a href="wen2.html">[人生哲理]写给自己，送给别人</a></li>
                   <li><a href="wen2.html">[人生哲理]人的一生</a></li>
                   <li><a href="wen2.html">[人生哲理]及时表达你的爱</a></li>
                   <li><a href="wen2.html">[人生哲理]爱情能否专一</a></li>
                   <li><a href="wen2.html">[人生哲理]简单</a></li>
               </ul>
             </div>

            </div>
             <div class="advertise">
            <!--广告 -->
                <img src="images/Annie/865_100_1.jpg">
            </div>   
            </div>
      <%} %> 
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
</div>
            </div>
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