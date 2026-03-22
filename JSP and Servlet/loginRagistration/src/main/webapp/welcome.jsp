<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="css/welcomeStyle.css">
</head>
<body>

<%
        // Retrieve the session object
        HttpSession session1 = request.getSession(false);

        // Check if the session is not null and the username attribute is set
        if (session1 != null && session1.getAttribute("username") != null) {
            // Get the username from the session
            String username = (String) session1.getAttribute("username");
    %>


<div class="card">
    <h1>Welcome, <%= username %>!</h1>
    <p>You have successfully logged in.</p>

	<form action="LogoutServlet" method="post">
    	<button type="submit" class="logout-btn">Logout</button>
	</form>
</div>

<%
        } else {
            // Redirect to the login page if the session is not valid
            response.sendRedirect("login.jsp");
        }
    %>


</body>
</html>
