<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ys.biz.*,com.ys.entity.*,java.util.*" %>
<%  Wenzhang wenzhang = new Wenzhang();
    WenzhangBiz wenzhangBiz = new WenzhangBiz();
     FenleiBiz fenleiBiz = new FenleiBiz();
	
     
	List<Biaoqian> bqs = wenzhangBiz.findAllBiaoqian();
	List<Fenlei> fenleis = new FenleiBiz().findAllShownRoot();
%>
<!DOCTYPE html>
<html lang="en">
  
<%@include file="head.jsp" %>
<%@include file="left.jsp" %>
   
    <div class="content">
        
        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" id="saveform"><i class="icon-save"></i> 添加</button>
  <div class="btn-group">
  </div>
</div>
<div class="well">

    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
      
    <form id="addAdminform" action="doAdminAdd" method="post">	   
		<lable>登录名:</lable>
		<input type="text" name="dengluming"/><br/>
		
		<lable>登录密码：</lable>
	    <input type="text" name="denglumima"/><br/>
			
		<lable>权限：</lable>
		<input type="text" name="quanxian"/><br/>
		
		<lable>名字：</lable>
		<input type="text" name="mingzi"/><br/>


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
            	
            	$("#addAdminform").submit();
            });
        });
    </script>
    
  </body>
</html>


    

                    
            
    


    