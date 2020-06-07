<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div id="login-top-back">
    <img src="/Farmers-Buddy/resources/img/back09.jpg">
</div>

<div class="header" >
    <div id="title" nav="/Farmers-Buddy">
        <label class="title"> <span>F</span>armers<span>&nbsp;B</span>uddy </label>    
    </div>
    <div class="options right">
        <c:if test="${role == 'admin' }">
        	<button class="green filled" nav="/Farmers-Buddy/admin/">Admin options</button>
        </c:if>
        <c:if test="${ role == null }">
        	<button class="green filled" nav="/Farmers-Buddy/users/signup">Register</button>
        </c:if>
        
		<% if( session != null && session.getAttribute("username") != null ) { %>
			<button class="blue" nav="/Farmers-Buddy/logout"> Logout</button>
		<% } else { %>
			<button class="saffron" nav="/Farmers-Buddy/users/login">Login</button>        
		<% } %>
    </div>
</div>