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
			
        
			<div class="cards-list" id="questions-list">
			<c:forEach items="${users}"	var="user">
				<div class="card user">
					<label> ${user.getName() } ( ${ user.getUserName()} ) &lt; ${ user.getEmail() } &gt; </label>
					<div class="card-options">
						 <button id="" class="button danger no-top-up-margin" nav="/Farmers-Buddy/admin/delete/${user.getId() }"> Delete </button>
						  <c:if test="${user.getRole() != 'admin' }">
						  	<button id="" class="button success no-top-up-margin" nav="/Farmers-Buddy/admin/give/${user.getId()}"> Give Admin Access </button>
						  </c:if>
						  <c:if test="${user.getRole() == 'admin' }">
						  	<button id="" class="button warning" nav="/Farmers-Buddy/admin/revoke/${user.getId()}"> Revoke Admin Access </button>
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