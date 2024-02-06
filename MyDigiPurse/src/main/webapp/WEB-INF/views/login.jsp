<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
        <img src="logo.jpg" alt="Company Logo">
        <h1>MyDigiPurse</h1>
    </header>

    <div class="container">
        <div class="form-box">
       
            <h2>Login</h2>
            <form action="login" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required><br>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br>

                <button type="submit">Login</button> </form>
                <form action="register">
                <h3>New user?</h3>
             <button type="submit" >Register</button>
             </form>
               
                

            <!-- Display error message if login fails 
            <c:if test="${not empty requestScope.error}">
                <div class="error-message">${requestScope.error}</div>
            </c:if>-->
        </div>
    </div>
    
</body>
</html>