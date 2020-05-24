<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

	<title>FBuddy | Login</title>
	
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" charset="ISO-8859-1">
        <link rel="stylesheet" href="../resources/css/autumn.css"/>
        <link rel="stylesheet" href="../resources/css/home.css"/>
        <link rel="stylesheet" href="../resources/css/icons.css"/>
        <link rel="stylesheet" href="../resources/css/public/login.css"/>
        
</head>
<body>
	<div id="login-top-back"></div>
	<jsp:include page="../header.jsp" />
	  
        <div class="body login">
		<!-- form -->
		<form:form method="post" modelAttribute="user" action="login">
		<div class="login-form form fit">
                <div class="form-header">
                    <div class="title"> Login  </div>
                    <div class="desc">Login with your username and password to get answer of query</div>
                </div>
                <div class="form-body box center inline"> 
                	<div class="inline-body">                   
                    <div class="element inline">
                        <div class="label"> Username </div>
                        <div class="control">
                            <form:input type="text" path="userName" class="textbox"/>
                        </div>
                    </div>
                    <div class="element inline">
                        <div class="label"> Password </div>
                        <div class="control">
                            <form:input type="password" path="pswd" class="textbox"/>
                        </div>
                    </div>
                    </div>
                    <div class="inline-body" id="sigup-form-body">
                    	<div class="element inline">
                    	<div class="control">
           					<div class="filled-outlined-btn" 
           					nav="/Farmers-Buddy/users/signup" style="width:90%">Join Farmers Buddy</div>
       					</div>
       					</div>
       					<div class="element inline">
       						<div class="control">
            					<div class="filled-outlined-btn" 
            					nav="/Farmers-Buddy/officers/signup" style="width:90%">Agricultural Officer Registration</div>
        					</div>
       					</div>
                    </div>
                </div>
                <div class="form-footer box center">
                    <div class="element">
                        <div class="control">
                            <input type="submit" value="Login" id="login" class="button" />
                        </div>
                    </div>
                    
                        <div class="control">
                            <label class="link" nav='/Farmers-Buddy/officers/signup' > Forgot Password?</label>
                        </div>
                </div>
            </div> 
            </form:form>
    </div>
    

           
            <script src="../resources/js/util.js"></script>
            <script src="../resources/js/autumn.js"></script>
            <script src="../resources/js/login.js"></script>  
            <script src="../resources/lib/axios.js"></script>
            
</body>
</html>