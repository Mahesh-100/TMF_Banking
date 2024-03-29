<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
        <img src="company-logo.png" alt="Company Logo">
        <h1>MyDigiPurse</h1>
    </header>

    <div class="container">
        <div class="form-box">
            <h2>Registration</h2>
            <form action="http://localhost:8082/TMF_Banking/Register" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required><br>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br>

                <label for="fullName">Full Name:</label>
                <input type="text" id="fullName" name="fullname" required><br>

                <label for="phoneNumber">Phone Number:</label>
                <input type="text" id="phoneNumber" name="phone_no" pattern="[0-9]{10}" required><br>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required><br>

                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required><br>

                <button type="submit">Register</button> </form>
                <form action="http://localhost:8082/TMF_Banking/login.jsp">
                <h3>Already have a account?</h3>
                <button type="submit" >Login</button></form>
           

            <!-- Display error message if registration fails 
            <c:if test="${not empty requestScope.error}">
                <div class="error-message">${requestScope.error}</div>
            </c:if>-->
        </div>
    </div>
   
</body>
</html>