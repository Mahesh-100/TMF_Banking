<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
        <img src="company-logo.png" alt="Company Logo">
        <h1>Company Name</h1>
</header>
<div class="home-container"> 
<h2>Welcome <%UserDTO user=(UserDTO)session.getAttribute("user");
out.print(user.getUsername());
%>
</h2>
<p>Full Name:<%out.print(user.getUser_fullname()); %></p>
<p>Phone Number:<%=user.getPhone_no() %></p>
<p>Email:<%=user.getEmail() %></p>
<p>Address:<%=user.getAddress() %></p>




</div>
    
    
</body>
</html>