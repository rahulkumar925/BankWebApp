<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="fundTransfer.app" method="post">
<div align="center"><h2>Fund Transfer</h2></div>
<table>
<tr>
<td>Enter your Account Number: </td>
<td><input type="text" name="senderAccountNumber"></td>
</tr>
<tr>
<td>Enter destination Account Number: </td>
<td><input type="text" name="receiverAccountNumber"></td>
</tr>
<tr>
<td>Enter Amount: </td>
<td><input type="number" name="transferAmount" min=1></td>
</tr>
<tr>
<td><input type="submit" value="Send"></td>
</tr>
</table>
</form>
</body>
</html>