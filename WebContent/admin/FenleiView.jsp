<%@page import="com.ys.entity.Fenlei,com.ys.biz.FenleiBiz,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ include file="head.jsp" %>
<%@include file="left.jsp" %> 
   <div class="content">
 
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>分类ID</th>
          <th>分类名</th>
          <th>上级分类</th>
          <th>显示与否</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${fenleis}" var="fenlei" >
      <tr>
      <td>${fenlei.id }</td>
      <td>${fenlei.title }</td>
      <td>${fenlei.fuFlId }</td>
      <td>
      <c:if test = "${fenlei.xianshiFlag == 0}">显示</c:if>
       <c:if test = "${fenlei.xianshiFlag == 1}">不显示</c:if>
      </td>
      <td>
              <a href="FenleiModify.jsp?shenme=${fenlei.id } "><i class="icon-pencil"></i></a>
              <a href="doFenleiNoShow?shenme=${fenlei.id } " role="button" ><i class="icon-remove"></i></a>
      </td>
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


