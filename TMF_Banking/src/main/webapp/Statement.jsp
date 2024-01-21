<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statement</title>
<link rel="stylesheet" href="styles.css">
<script type="text/javascript" src="Script.js"></script>

</head>
<body>
<header>
        <img src="company-logo.png" alt="Company Logo">
        <h1>TMF Banking</h1>
    </header>
<div>
<button style="width:10%" class="logout" onclick="requestlogout();">Logout</button>
</div>
<% UserDTO user=(UserDTO)session.getAttribute("user");
   if(user==null) {
	   response.sendRedirect("login.jsp");
   }else{%>
<div class="container">
<div class="form-box">
<h2>Account Statement</h2>

 
   <h3>Welcome <%out.print(user.getUsername());%>
</h3>


<table class="Bank-table">
    <thead>
        <tr>
            <th>Transaction Date</th>
            <th>Transaction Type</th>
            <th>Description</th>
            <th>Amount</th>
        </tr>
    </thead>
    <tbody>
        <!-- Loop through your transactions and populate the table rows -->
        <tr>
            <td>2024-01-25 08:30:00</td>
            <td>Deposit</td>
            <td>Initial deposit</td>
            <td>500.00</td>
        </tr>
        <tr>
            <td>2024-01-26 12:45:00</td>
            <td>Withdrawal</td>
            <td>ATM withdrawal</td>
            <td>100.00</td>
        </tr>
        <!-- Add more rows as needed -->
    </tbody>
</table>
</div>
 </div>
 <% }%>
</body>
</html>