<%@page import="com.ys.biz.WenzhangBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.ys.common.*,com.ys.entity.*,java.util.*"%>   
 <!DOCTYPE html>
<html lang="en">
  
 <%@ include file="head.jsp" %>
<%@include file="left.jsp" %> 
   <div class="content">
<% 
    String p = request.getParameter("p");
    if(Common.isNotANumber(p)){
    p="1";
     }
     String biaoqian3 = request.getParameter("biaoqian");
     
     
    
     List<Wenzhang> wenzhangs = new WenzhangBiz().findWenzhangByPage(Integer.parseInt(p));
     int WenzhangTotal =  new WenzhangBiz().findCount();
     double TempPageAmount = Math.ceil((double)WenzhangTotal/Common.ADMIN_WenzhangPERPAGE_NUM);
     int pageAmount = (int)TempPageAmount;
     if(pageAmount<1){
    	 pageAmount=1;
     }
%>        
            
                    

<div class="well">
    <table class="table">
      <thead>
        <tr>
          
          <th>题目</th>
          <th>摘要</th>
          <th>作者</th>
          <th>写作时间</th>
          <th>浏览数</th>
          <th>评论数</th>
          <th>文章分类</th>
          <th>标签</th>
          <th style="width: 20px;"></th>
        </tr>
      </thead>
      <tbody>
      <% for(Wenzhang wenzhang:wenzhangs){ %>  
          <tr>
          <td><%=wenzhang.getTitle()%></td>
          <td><%=wenzhang.getZaiyao()%></td>
          <td><%=wenzhang.getZuozhe()%></td>
          <!--TODO 写作时间  -->
          <td><%=wenzhang.getLiulanshu()%></td>
          <td><%=wenzhang.getPinglunshu()%></td>
          <td><%=wenzhang.getFenlei()==-1?"无":wenzhang.getFenlei()%></td>
          <td><%=wenzhang.getBiaoqian()%></td>
          <td>
              <a href="FenleiModify.jsp?shenme=<%=wenzhang.getId() %>"><i class="icon-pencil"></i></a>
              <a href="doFenleiNoShow?shenme=<%=wenzhang.getId() %>" role="button" ><i class="icon-remove"></i></a>
          </td>
        </tr> 
      <% }%>  
       </tbody>
    </table>
</div>     
  <!--页码  -->    
 <div class="pagination"  > 
    <ul>
        <%if((Integer.parseInt(p)) != 1){ %>
        <li><a href="WenzhangView.jsp?p=<%=Integer.parseInt(p)-1%>" >上一页</a></li>
        <%} %>
        <%for(int i = 1;i <= pageAmount;i++){ %>
        <li><a href="WenzhangView.jsp?p=<%=i%>" style="background:#666"><%=i%></a></li>
        <%} %>
        <%if((Integer.parseInt(p)) < pageAmount){ %>
        <li><a href="WenzhangView.jsp?p=<%=Integer.parseInt(p)+1%>" >下一页</a></li>
        <%} %>
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


