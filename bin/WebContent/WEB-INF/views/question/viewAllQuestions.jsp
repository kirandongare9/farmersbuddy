<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Farmers Buddy</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" charset="ISO-8859-1">
        <link rel="stylesheet" href="../resources/css/autumn.css"/>
        <link rel="stylesheet" href="../resources/css/home.css"/>
        <link rel="stylesheet" href="../resources/css/icons.css"/>
        
</head>
<body>
	
	<jsp:include page="../header.jsp" />
	
	<div class="body">
		<div class="card fill-screen">
		<div>
			<input type="text" class="input" style="width:60% ;margin:2%" onkeyup="filterQuestions(event);"/>
            <button id="" class="button" > Search Question </button>
            <button id="" class="button warning" nav="/Farmers-Buddy/questions/post"> Ask a question  </button>
        </div>
        
			<div class="cards-list" id="questions-list">
			<c:forEach items="${questions}"	var="question">
				<div class="card question">
					<label nav="view/${question.getQuestionId()}"> <c:out value="${question.getQuestion() }" /> </label>
					<div class="card-options">
						<span class="icon small like"nav="/Farmers-Buddy/questions/like/${question.getQuestionId()}"></span><span class="like-count">${question.getLikes()} </span>
						<button id="" class="button no-top-up-margin" nav="view/${question.getQuestionId()}"> View Answers </button>
						
						<c:if test="${ username == question.getCreatedBy() || role == 'officer' || role == 'admin'}">
							<button id="" class="button success no-top-up-margin" nav="/Farmers-Buddy/questions/edit/${question.getQuestionId()}"> Edit </button>
						</c:if>
						<c:if test="${ username == question.getCreatedBy() || role == 'officer' || role == 'admin' }">
							<button id="" class="button danger no-top-up-margin" nav="/Farmers-Buddy/questions/delete/${question.getQuestionId()}"> Delete </button>
						</c:if>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
	
	<%-- 
	<jsp:include page="../footer.jsp" /> --%>
	
	 <script src="../resources/js/fbuddy.js"></script>
	 <script src="../resources/js/util.js"></script>
     <script src="../resources/js/autumn.js"></script>
     <script src="../resources/lib/axios.js"></script>

</body>
</html>