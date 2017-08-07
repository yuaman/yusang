
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ys.biz.FenleiBiz,com.ys.entity.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
 <%@ include file="head.jsp" %>

  <%@include file="left.jsp" %> 
   
    <div class="content">
  <div class="container-fluid">
   <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" id="saveform"><i class="icon-save"></i> 添加</button>
</div>
<div class="well">
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
      
    <form id="addfenleiform" action="doFenleiAdd" method="post">
        <input type="hidden" name="tk" value="${tk}"/>
        <label>分类标题</label>
        <input type="text" name="title" class="input-xlarge">  
        <label>上级分类</label>
        <select name="fuid" id="DropDownTimezone" class="input-xlarge">
          <option value="-1">------顶级分类-----</option>	
          <c:forEach items="${requestScope.fenleis}" var="fenlei" >
          <option value="${fenlei.id}">${fenlei.title }</option>
          </c:forEach>
    	</select>      
        <label>描述</label>
        <textarea rows="3" class="input-xlarge" name="miaoshu"></textarea>
    </form>
    
      </div>     
  </div>

</div>
<footer>
    <hr>
    <p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
   <p>&copy; 霖哥 <a href="#" target="_blank">2016</a></p>
  </footer>  
 </div>
</div>
    </div>    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
            
            $('#saveform').click(function(){
            	
            	$("#addfenleiform").submit();
            });
        });
    </script>
    
  </body>
</html>


    