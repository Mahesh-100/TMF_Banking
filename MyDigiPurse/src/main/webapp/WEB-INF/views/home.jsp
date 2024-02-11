<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
 <%@ page isELIgnored="false" %>
 <%@ page import="com.controller.entity.UserDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="styles.css">
<script type="text/javascript" src="Script.js"></script>
</head>
<body>
<form id="accountForm" action="http://localhost:8082/TMF_Banking/ButtonServlet" method="post">
<input type="hidden" id="selectedPage" name="selectedPage">
<header>
        <img src="" alt="Company Logo">
        <h1>MyDigiPurse</h1>
</header>


<% 
   if(session.getAttribute("username")==null) {
	   response.sendRedirect("login");
   }else{%>
 <div class="userDetails">

 <h2>Welcome, ${user.username}</h2>
   
<p>Full Name:${user.user_fullname}</p>
<p>Phone Number:${user.phone_no }</p>
<p>Email:${user.email }</p>
<p>Address:${user.user_address }</p>
</div>
    
<div class="accountsList">
 <a href="addaccount" class="AllBtn" style="float: right; margin-right: 20px;"  >Add Account</a>
    <!-- Display accounts in radio buttons here -->
   
   
 
</div>

  
<div class="transactions">
    <!-- Buttons for transaction requests -->
    <input type="hidden" id="selectedAction" name="selectedAction">
    <button  type="button" style="width:25%" class="AllBtn" onclick="validateAndRedirect('Statement')"> Statement</button>
    
    <button  style="width:25%"class="AllBtn" onclick="validateAndRedirect('AddMoney')"> Add Money</button>
     
    <button type="button" style ="width:25%" class="AllBtn" onclick="validateAndRedirect('SendMoney')">Send Money</button>
     
    
</div>

 <% }%>
   
</form>
<div>
<button style="width:10%" class="logout" onclick="requestlogout()">Logout</button>
</div>

</body>
</html>


