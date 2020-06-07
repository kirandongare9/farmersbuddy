<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" charset="ISO-8859-1">
	
        <link rel="stylesheet" href="../../resources/css/home.css"/>
        <link rel="stylesheet" href="../../resources/css/autumn.css"/>
        <link rel="stylesheet" href="../../resources/css/icons.css"/>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="body answer">
		<form:form modelAttribute="answer" method="post" action="../give">
			<div class="card fill-screen">
				<div class="card-header">Give Answer</div>
				<div class="card-subject">Enter your answer here</div>
				<div class="card-body">
					<div id="answer-div" contenteditable="true" class="input-box fill-screen" ></div>
					<form:hidden id="answer-value" path="answer" value=""/>
					<form:hidden id="answer-value" path="questionId"/>
					<button class="button bold">Post Answer</button>
				</div>
			</div>
		</form:form>
	</div>
    
    <script src="/Farmers-Buddy//resources/js/util.js"></script>
    <script src="/Farmers-Buddy//resources/js/autumn.js"></script> 
    <script src="/Farmers-Buddy//resources/lib/axios.js"></script>
    <script src="/Farmers-Buddy//resources/lib/sweetalert2.js"></script> 
    <script>
    	$("#answer-div").addEventListener("keyup",(e)=>{
    		$("#answer-value").value = $("#answer-div").textContent;
    	});
    </script>
    
</body>
</html>