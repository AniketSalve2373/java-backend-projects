<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My JSP Page</title>

    <!-- Connecting CSS -->
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <div class="container">

        <div class="card">

            <h1>🎉 Fun Calculator</h1>
            <p class="tagline">Joke of the day </p>
            
            <div class="joke">
                😂 <b>Joke:</b> <h1>=<%=request.getParameter("joke")%></h1>
            </div>

            <!-- FORM START -->
            <form action="myServlet" method="get">

                <!-- IMPORTANT CHANGE:
                     Use SAME name for buttons so servlet knows
                     which operation user clicked -->     
                    
                    <h1>Ans =<%=request.getParameter("ans")%></h1>
             

            </form>
            <!-- FORM END -->

            <div class="result">
                Result: <span>0</span>
            </div>

            

        </div>

    </div>

</body>
</html>