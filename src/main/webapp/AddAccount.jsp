<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="dto.UserDTO" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account Form</title>
<link rel="stylesheet" href="styles.css">
<script type="text/javascript" src="Script.js"></script>

</head>
<body>
<header>
        <img src="company-logo.png" alt="Company Logo">
        <h1>MyDigiPurse</h1>
</header>

<% UserDTO user=(UserDTO)session.getAttribute("user");
   if(user==null) {
	   response.sendRedirect("login.jsp");
   }else{%>
<div class="container">
<div class="form-box">
<h2>Bank Account Form</h2>

<form action="http://localhost:8082/TMF_Banking/AccountServlet" method="post">
	
 
   <h3>Welcome <%out.print(user.getUsername());%>
</h3>
     <input type="hidden" name="username" value="<%user.getUsername(); %>">
    <label for="accountNumber">Account Number:</label>
    <input type="text" id="accountNumber" name="accountNumber" required>

    <label for="bankName">Bank Name:</label>
    <input type="text" id="bankName" name="bankName" required>

    <label for="ifscCode">IFSC Code:</label>
    <input type="text" id="ifscCode" name="ifscCode" required>

    <label for="accountType">Account Type:</label>
    <select id="accountType" name="accountType" required>
     <option value="savings"></option>
        <option value="savings">Savings</option>
        <option value="current">Current</option>
        <!-- Add more options if needed -->
    </select>

    <label for="initialBalance">Initial Balance:</label>
    <input type="number" id="initialBalance" name="initialBalance" required>

    <button type="submit">Submit</button>
</form>

</div>
</div>
<% }%>
<div>
<button style="width:10%" class="logout" onclick="requestlogout()">Logout</button>
</div>
</body>
</html>