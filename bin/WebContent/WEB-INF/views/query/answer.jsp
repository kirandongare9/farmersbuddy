<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<div class="w3-container">
		<h2>Cards</h2>
  		<p>Create paper-like cards with the w3-card classes:</p>

		<div class="w3-panel w3-card">
			<div class="element inline">
    			<div class="label"> Query </div>
        			<div class="control">
            			<input type="text" id="query" class="textbox"/>
           			</div>
     			</div>
    	
	 	<div class="element inline">
        	<div class="control">
        		<input type="submit" value="Submit " class="button" onclick="answer()"/>
        	</div>

     	</div>
     	</div>
     </div>
</body>
</html>