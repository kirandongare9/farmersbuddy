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
	
        <link rel="stylesheet" href="../../resources/css/autumn.css"/>
        <link rel="stylesheet" href="../../resources/css/home.css"/>
        <link rel="stylesheet" href="../../resources/css/icons.css"/>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="body query">
		<form:form modelAttribute="question" method="post" action="../edit">
			<div class="card fill-screen">
				<div class="card-header">Edit Query</div>
				<div class="card-subject">Edit your query below.</div>
				<div class="card-body">
					<div id="question-div" contenteditable="true" class="input-box fill-screen" >
						${question.getQuestion() }
					</div>
					<form:hidden id="question-value" path="question" value=""/>
					<form:hidden id="question-value" path="questionId" value="${question.getQuestionId() }" />
					<button class="button bold">Update Question</button>
				</div>
			</div>
		</form:form>
	</div>
    <script src="../../resources/js/util.js"></script>
    <script src="../../resources/js/autumn.js"></script> 
    <script>
    	$("#question-div").addEventListener("keyup",(e)=>{
    		$("#question-value").value = $("#question-div").textContent;
    	});
    </script>
</body>
</html>