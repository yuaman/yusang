<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ys.biz.*,com.ys.entity.*,java.util.*" %>
<%
	String flId = request.getParameter("shenme");

	Fenlei oldFenlei = new FenleiBiz().findById(Integer.parseInt(flId));
	
	
	List<Fenlei> fenleis = new FenleiBiz().findAllShownRoot();
%>
<!DOCTYPE html>
<html lang="en">
  

<%@include file="head.jsp" %>
<%@include file="left.jsp" %>
    

    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Edit User</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">Home</a> <span class="divider">/</span></li>
            <li><a href="users.html">Users</a> <span class="divider">/</span></li>
            <li class="active">User</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" id="saveform"><i class="icon-save"></i> 修改</button>
    <a href="#myModal" data-toggle="modal" class="btn">Delete</a>
  <div class="btn-group">
  </div>
</div>
<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">Profile</a></li>
      <li><a href="#profile" data-toggle="tab">Password</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
    <form id="addfenleiform" action="doFenleiModify" method="post">
    	<input type="hidden" name="id" value="<%=oldFenlei.getId() %>"/>
        <label>分类标题</label>
        <input type="text" name="title" value="<%=oldFenlei.getTitle() %>" class="input-xlarge">  
        <label>上级分类</label>
        <select name="fuid" id="DropDownTimezone" class="input-xlarge">
          <option value="-1">------顶级分类-----</option>
          <%for(Fenlei fenlei:fenleis){ 
          	if(oldFenlei.getFuFlId() == fenlei.getId()){
          		%>
              	<option value="<%=fenlei.getId()%>" selected="selected"><%=fenlei.getTitle() %></option>
              	<%
          	} else{
          	%>
          	<option value="<%=fenlei.getId()%>"><%=fenlei.getTitle() %></option>
          	<%}
          } %>
    	</select>      
        <label>描述</label>
        <textarea rows="3" class="input-xlarge" name="miaoshu"><%=oldFenlei.getMiaoshu() %></textarea>
    </form>
      </div>     
  </div>

</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">Delete Confirmation</h3>
  </div>
  <div class="modal-body">
    
    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
    <button class="btn btn-danger" data-dismiss="modal">Delete</button>
  </div>
</div>


                    
                    <footer>
                        <hr>

                        
                        <p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>

                        <p>&copy; 2012 <a href="#" target="_blank">Portnine</a></p>
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


    