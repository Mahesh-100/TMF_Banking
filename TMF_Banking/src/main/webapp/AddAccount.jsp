<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account Form</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
        <img src="company-logo.png" alt="Company Logo">
        <h1>TMF Banking</h1>
</header>
<div>
<button style="width:10%" class="logout" onclick="requestlogout();">Logout</button>
</div>
<div class="container">
<div class="form-box">
<h2>Bank Account Form</h2>
<%HttpSession Session=request.getSession();
session.getAttribute("user");%>
<form action="http://localhost:8082/TMF_Banking/AddAccount" method="post">
    <label for="accountNumber">Account Number:</label>
    <input type="text" id="accountNumber" name="accountNumber" required>

    <label for="bankName">Bank Name:</label>
    <input type="text" id="bankName" name="bankName" required>

    <label for="ifscCode">IFSC Code:</label>
    <input type="text" id="ifscCode" name="ifscCode" required>

    <label for="accountType">Account Type:</label>
    <select id="accountType" name="accountType" required>
     <option value="savings"></option>
        <option value="savings">Savings</option>
        <option value="current">Current</option>
        <!-- Add more options if needed -->
    </select>

    <label for="initialBalance">Initial Balance:</label>
    <input type="number" id="initialBalance" name="initialBalance" required>

    <button type="submit">Submit</button>
</form>
</div>
</div>
<script type="text/javascript">
function requestlogout() {
    window.location.href="login.jsp";
}
</script>
</body>
</html>