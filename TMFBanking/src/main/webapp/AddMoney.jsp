<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.UserDTO" %>
    <%@ page import="dto.BankAccountDTO" %>
<%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Money</title>
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
<h2>Add Money</h2>

 
   <h3>Welcome <%out.print(user.getUser_fullname());%>
</h3>
<form  id="addMoneyForm" action="http://localhost:8082/TMF_Banking/AddMoneyServlet" method="post">
     
	<input type="hidden" name="accountNumber" value="<%=request.getAttribute("accountNumber") %>">
	<input type="hidden" name="accountID" value="<%=request.getAttribute("accountID") %>">
    <label for="amount">Amount to Add:</label>
    <input type="number" id="amount" name="amount" required>

    <button type="submit" >Add Money</button>
</form>

</div>
 </div>
 <% }%>
 <div>
<button style="width:10%" class="logout" onclick="requestlogout()">Logout</button>
</div>
</body>
</html>