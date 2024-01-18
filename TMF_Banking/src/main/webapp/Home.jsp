<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<link href="Style.css" rel="stylesheet">
</head>
<body>
<header>
<div class="company-logo">
            <img src="company-logo.png" alt="Company Logo">
        </div>
        <h1 class="company-name">TMF_BANKING</h1>
</header>   
<h2>Welcome <%UserDTO user = (UserDTO) session.getAttribute("user");
out.print(user.getUsername().toUpperCase());
%></h2>
<p>Full Name:<% out.print(user.getUser_fullname());%></p>
<p>Phone number:<%out.print(user.getPhone_no()); %></p>
<p>Email:<%out.print(user.getEmail()); %></p>
<p>Address:<%out.print(user.getAddress()); %></p>

</body>
</html>