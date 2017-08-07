<%@page import="com.ys.biz.AdminBiz"%>
<%@page import="com.ys.biz.WenzhangBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.ys.common.*,com.ys.entity.*,java.util.*"%>  
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
 <!DOCTYPE html>
<html lang="en">
  
 <%@ include file="head.jsp" %>
<%@include file="left.jsp" %> 
   <div class="content">

<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>登录名</th>
          <th>登录密码</th>
          <th>权限</th>
          <th>名字</th>
          <th style="width: 20px;"></th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${ admins}" var="admin">
      <tr>
      <td>${admin.DENGLUMING }</td>
      <td>${admin.DENGLUMIMA }</td>
      <td>${admin.QUANXIAN }</td>
      <td>${admin.MINGZI }</td>
       </tr> 
      
      </c:forEach>  
       </tbody>
    </table>
</div>     
  <!--页码  -->    
 <div class="pagination"> 
    <ul>
        ${requestScope.pagelinkcnt}
    </ul>
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
        });
    </script>
    
  </body>
</html>


