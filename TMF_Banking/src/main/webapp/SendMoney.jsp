<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Money</title>
<link rel="stylesheet" href="styles.css">
<script type="text/javascript" src="Script.js"></script>

</head>
<body>
<header>
        <img src="company-logo.png" alt="Company Logo">
        <h1>Company Name</h1>
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
<h2>Send Money</h2>

 
   <h3>Welcome <%out.print(user.getUsername());%>
</h3>
<form action="ProcessSendMoneyServlet" method="post">
    <label for="recipientName">Recipient's Name:</label>
    <input type="text" id="recipientName" name="recipientName" required>

    <label for="recipientAccount">Recipient's Account Number:</label>
    <input type="text" id="recipientAccount" name="recipientAccount" required>

    <label for="amount">Amount to Send:</label>
    <input type="number" id="amount" name="amount" required>

    <button type="submit">Send Money</button>   
</form>
</div>
 </div>
 <% }%>
</body>
</html>