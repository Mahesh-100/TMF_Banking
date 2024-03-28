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
        <h1>MyDigiPurse</h1>
</header>
<form action="http://localhost:8082/TMF_Banking/StatementServlet" method="post">

<div class="container">
<div class="form-box">

<% UserDTO user=(UserDTO)session.getAttribute("user");
   if(user==null) {
	   response.sendRedirect("login.jsp");
   }else{%>


<h2>Account Statement</h2>

 
   <h3>Welcome <%out.print(user.getUser_fullname());%></h3>




<label for="StartDate">Start Date:</label>
        <input type="date" id="StartDate" name="startDate" required>
        <span id="startDateError" class="error-message"></span><br>
<label for="EndDate">End Date:</label>
        <input type="date" id="EndDate" name="endDate" required>
        <span id="endDateError" class="error-message"></span><br>
        <input type="hidden" name="accountID" value="<%=request.getAttribute("accountID") %>">
         <button type="submit">Submit</button> 

</div>

</div>
 
 <% }%>
 <div>
<button style="width:10%" class="logout" onclick="requestlogout()">Logout</button>
</div>
</form>
</body>
</html>