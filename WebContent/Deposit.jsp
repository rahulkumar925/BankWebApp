<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="deposit.app" method="post">
<table>
<tr>
<td>Enter Account Number: </td>
<td><input type="text" name="accountNumber"></td>
</tr>
<tr>
<td>Enter Deposit Amount: </td>
<td><input type="number" name="depositAmount" min=1></td>
</tr>
<tr>
<td><input type="submit" value="Deposit"></td>
</tr>
</table>
</form>
</body>
</html>