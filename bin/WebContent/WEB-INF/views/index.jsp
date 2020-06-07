<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Farmers Buddy</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" charset="ISO-8859-1">
        <link rel="stylesheet" href="./resources/css/autumn.css"/>
        <link rel="stylesheet" href="./resources/css/home.css"/>
        <link rel="stylesheet" href="./resources/css/icons.css"/>
        
</head>
<body>
	
	<jsp:include page="header.jsp" />
	
	<div class="body">
		<div class="card fill-screen">
		<div>
			<input type="text" class="input" style="width:60% ;margin:2%"/>
            <button id="" class="button" > Search Question </button>
            <button id="" class="button warning" nav="/Farmers-Buddy/questions/"> Ask a question  </button>
        </div>
        
			<div class="cards-list">
				<div class="card">
					Question 1 .
				</div>
				<div class="card">
					Question 2 .
				</div>
				<div class="card">
					Question 3 .
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" />
	
	 <script src="./resources/js/util.js"></script>
     <script src="./resources/js/autumn.js"></script>
     <script src="./resources/lib/axios.js"></script>

</body>
</html>