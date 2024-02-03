<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.UserDTO" %>
     <%@ page import="java.util.ArrayList" %>
     <%@ page import="dto.TransactionDTO" %>
     <%@ page import="dao.BankDao" %>
     <%@ page import="db.StatementServlet" %>
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
<div class="container">


<% UserDTO user=(UserDTO)session.getAttribute("user");
   if(user==null) {
	   response.sendRedirect("login.jsp");
   }else{%>


<h2>Account Statement</h2>

 
   <h3>Welcome <%out.print(user.getUser_fullname());%></h3>

<table class="Bank-table">
    <thead>
        <tr>
        	<th>TransactionId</th>
            <th>Transaction Date</th>
            <th>Transaction Type</th>
          	<th>Amount</th>
          	<th>SourceId</th>
          	<th>TargetId</th>
        </tr>
    </thead>
    <tbody>
       <% ArrayList<TransactionDTO> transactions = (ArrayList<TransactionDTO>) request.getAttribute("transactions");
               for (TransactionDTO transaction : transactions) { %>
        <tr>
        	<td><%=transaction.getTransactionID()%>
        	<td><%=transaction.getTransactionDate() %></td>
            <td><%=transaction.getTransactionType() %></td>
          	<td><%=transaction.getAmount() %></td>
            <td><%=transaction.getSourceAcctID() %></td>
            <td><%=transaction.getTargetAcctID() %></td>
            
        </tr>
      <% } %>
        
    </tbody>
</table>
</div>

 <% }%>
 <div>
<button style="width:10%" class="logout" onclick="requestlogout()">Logout</button>
</div>
</body>
</html>