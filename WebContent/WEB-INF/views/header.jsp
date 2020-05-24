<div id="login-top-back">
    <img src="/Farmers-Buddy/resources/img/proimage2.jpg">
</div>

<div class="header" >
    <div id="title" nav="/Farmers-Buddy">
        <label class="title"> <span>F</span>armers<span>&nbsp;B</span>uddy </label>    
    </div>
    <div class="options right">
        <button class="green filled" nav="/Farmers-Buddy/users/signup">Register</button>
		<% if( session != null && session.getAttribute("username") != null ) { %>
			<button class="blue" nav="/Farmers-Buddy/logout"> Logout</button>
		<% } else { %>
			<button class="saffron" nav="/Farmers-Buddy/users/login">Login</button>        
		<% } %>
    </div>
</div>