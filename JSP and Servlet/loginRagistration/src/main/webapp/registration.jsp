<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="css/registrationStyle.css">
</head>
<body>

<div class="card">
    <h2>Registration</h2>

    <form action="RegisterServlet" method="post">
        <input type="text" name="username" placeholder="Enter Username" required>
        <input type="email" name="email" placeholder="Enter Email" required>
        <input type="password" name="password" placeholder="Enter Password" required>

        <button type="submit">Register</button>
    </form>

    <a href="index.html" class="home-btn">Home</a>
</div>

</body>
</html>
