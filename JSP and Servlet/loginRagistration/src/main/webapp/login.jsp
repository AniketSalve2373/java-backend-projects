<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/loginStyle.css">
</head>
<body>

<div class="card">
    <h2>Login</h2>

    <form action="LoginServlet" method="post">
        <input type="text" name="username" placeholder="Enter Username" required>
        <input type="password" name="password" placeholder="Enter Password" required>

        <button type="submit">Login</button>
    </form>
    
    <%-- Display error message if login fails --%>
    <%
		String error = request.getParameter("error");
		if (error != null && error.equals("1")) {
		%><p style="color: red;">Invalid username or password</p><%
		}
	%>

		<%-- Display error message if Register Successful --%>
        <% String rs = request.getParameter("registration");
            if (rs != null && rs.equals("success")) { %>
                <p style="color: green;">Your Registration is Successful. Please Login.</p>
        <% } %>
    <a href="index.html" class="home-btn">Home</a>
    
    
    
    
</div>

</body>
</html>
