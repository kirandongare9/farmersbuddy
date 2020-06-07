<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
			<div class="card fill-screen">
				<div class="card-subject" style="padding-left:2%;">${question.getQuestion() }</div>
				<div class="card-body">
					<button class="button" nav="/Farmers-Buddy/answers/give/${question.getQuestionId() }" style="margin-top:0%;" >Give Answer</button>
					<div class="cards-list">
						<c:forEach items="${question.getAnswers()}"	var="answer">
							<div class="card" >
								<label> <c:out value="${answer.getAnswer()  }" /> </label>
								<div class="card-options">
									<span class="icon small like" nav="/Farmers-Buddy/answers/like/${answer.getAnswerId()}"></span><span class="like-count">${ answer.getLikes()}</span>
									<c:if test="${ username == answer.getCreatedBy() || role == 'officer' || role == 'admin' }">
										<button id="" class="button success" nav="/Farmers-Buddy/answers/edit/${answer.getAnswerId()}"> Edit </button>
									</c:if>
									<c:if test="${ username == answer.getCreatedBy() || role == 'officer' || role == 'admin' }">
										<button id="" class="button danger" nav="/Farmers-Buddy/answers/delete/${answer.getAnswerId()}"> Delete </button>
									</c:if>
								</div>
								
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
	</div>
    <script src="/Farmers-Buddy/resources/js/util.js"></script>
    <script src="/Farmers-Buddy/resources/js/autumn.js"></script> 
    <script src="/Farmers-Buddy/resources/lib/axios.js"></script>
    <script src="/Farmers-Buddy/resources/lib/sweetalert2.js"></script> 
</body>
</html>