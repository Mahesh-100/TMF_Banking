<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserDTO" %>
<%@ page import="dao.BankDao" %>
<%@ page import="dto.BankAccountDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.LoginServlet" %>

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
        <img src="company-logo.png" alt="Company Logo">
        <h1>MyDigiPurse</h1>
</header>
<div>
<button style="width:10%" class="logout" onclick="requestlogout();">Logout</button>
</div>

<% UserDTO user=(UserDTO)session.getAttribute("user");
   if(user==null) {
	   response.sendRedirect("login.jsp");
   }else{%>
 <div class="userDetails">

 <h2>Welcome <% out.print(user.getUsername());%>
</h2>
   
<p>Full Name:<%out.print(user.getUser_fullname()); %></p>
<p>Phone Number:<%=user.getPhone_no() %></p>
<p>Email:<%=user.getEmail() %></p>
<p>Address:<%=user.getAddress() %></p>
</div>
    
<div class="accountsList">
 <a href="AddAccount.jsp" class="AllBtn" style="float: right; margin-right: 20px;"  >Add Account</a>
    <!-- Display accounts in radio buttons here -->
    
    <h2>Accounts</h2>
	<% ArrayList<BankAccountDTO> banklist=(ArrayList<BankAccountDTO>)request.getAttribute("accounts");%>
     <table class="Bank-table">
     <thead>
     <tr>
     <th>Select</th>
     <th>Account Number</th>
     <th>Bank Name</th>
     <th>IFSC code</th>
     <th>Account type</th>
     <th>Current Balance</th>
     <th>Last transaction</th>
     </tr>
     </thead>
    
     <tbody>
    
     <%for (BankAccountDTO account : banklist) { %>
     <tr>
     <td><input  type="radio" name="selectedAccount" value="<%=account.getAccount_no() %>"></td>
     <td><%=account.getAccount_no() %></td>
     <td><%=account.getBank_name() %></td>
     <td><%=account.getIFSC_code() %></td>
     <td><%=account.getAccount_type() %></td>
     <td><%out.print(account.getCurrent_balance()); %></td>
     <td>last_txn_date</td></tr>
<% } %>
     </tbody>
     </table>
     
 
</div>

  
<div class="transactions">
    <!-- Buttons for transaction requests -->
    <input type="hidden" id="selectedAction" name="selectedAction">
    <button  type="button" style="width:25%" class="AllBtn" onclick="validateAndRedirect('Statement')"> Statement</button>
    
    <button  style="width:25%"class="AllBtn" onclick="validateAndRedirect('AddMoney')"> Add Money</button>
     
    <button type="button" style ="width:25%" class="AllBtn" onclick="validateAndRedirect('SendMoney')">Send Money</button>
       <!-- <a href="SendMoney.jsp" class="AllBtn"   >Send Money</a>
     <a href="Statement.jsp" class="AllBtn"   >Statement</a>
     <a href="AddMoney.jsp" class="AllBtn"   >Add Money</a>-->
    
</div>

 <% }%>
   
</form>


</body>
</html>


