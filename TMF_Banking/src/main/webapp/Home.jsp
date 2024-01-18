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
<h1>Welcome <%UserDTO user = (UserDTO) session.getAttribute("user"); %></h1>

</body>
</html>