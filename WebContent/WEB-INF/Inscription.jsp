<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" /> 
<title>Role Based Access Control in Java Web Application Example</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.12.4-jquery.min.js" type="text/javascript"></script>
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        

<style type="text/css">
label.error
{
	color:red;
	font-family:Times New Roman;
	font-size:17px;
}		
</style>

<script src="js/validate.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
   $('#registerForm').validate({
        rules:
            {
                txt_firstname:
                {
                    required:true
                },
                txt_lastname:
                {
                    required:true
                },
                txt_email:
                {
                    required:true,
                    email:true
                },
                txt_password:
                {
                    required:true,
                    minlength:6,
                    maxlength:12
                },
                txt_role:
                {
                    required:true				
                }
            },
        messages:
            {
                txt_firstname:
                {
                    required:"enter firstname" 
                },
                txt_lastname:
                {
                    required:"enter lastname" 
                },
                txt_email:
                {
                    required:"enter proper email address"  
                },
                txt_password:
                {
                    required:"enter password 6 to 12"
                },
                txt_role:
                {
                    required:"please select role"
                }
            }
   }); 
});
</script>
<!--valiadtion css & js end here-->

</head>

<body>
<nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
          </button>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <div class="wrapper">
	<div class="container">
	
		<div class="col-lg-12">
		<%
		if(request.getAttribute("errorMsg")!=null)
        {
        %>
        	<div class="alert alert-danger">
        		<strong>WRONG! <% out.println(request.getAttribute("errorMsg")); %></strong>
            </div>
       <%
        }
        if(request.getAttribute("successMsg")!=null)
        {
        %>
        	<div class="alert alert-success">
            	<strong>SUCCESS! <% out.println(request.getAttribute("successMsg")); %></strong>
            </div>
        <%
        }
        %>
		<h2>Register Page</h2>
		<form method="post" id="registerForm" class="form-horizontal">
					
        	<div class="form-group">
            <label class="col-sm-3 control-label">Firstname</label>
            <div class="col-sm-6">
            <input type="text" name="nom" class="form-control" placeholder="enter firstname" />
            </div>
            </div>
                    
            <div class="form-group">
            <label class="col-sm-3 control-label">Lastname</label>
            <div class="col-sm-6">
            <input type="text" name="prenom" class="form-control" placeholder="enter lastname" />
            </div>
            </div>
                    
            <div class="form-group">
            <label class="col-sm-3 control-label">Email</label>
            <div class="col-sm-6">
            <input type="text" name="login" class="form-control" placeholder="enter email" />
            </div>
            </div>
			
            <div class="form-group">
            <label class="col-sm-3 control-label">Password</label>
            <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="enter passowrd" />
            </div>
            </div>
				
            <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9 m-t-15">
            <input type="submit" name="btn_register" class="btn btn-primary" value="Register">
            </div>
            </div>
			
			<div class="form-group">
            <div class="col-sm-offset-3 col-sm-9 m-t-15">
            You have a account login here? <a href="index.jsp"><span class="text-info">Login Account</span></a>		
            </div>
            </div>
				
		</form>
		</div>
	</div>
	</div>
    
</body>
</html>