<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
		<tr>
			<th>Account Number</th>
			<th>Account Holder Name</th>
			<th>Account Balance</th>
			<th>Over Draft Limit</th>
			<th>Phone No</th>
		</tr>
		<jstl:forEach var="account" items="${requestScope.account}">
			<tr>
				<td>${account.accountNumber}</td>
				<td>${account.accountHolder}</td>
				<td>${account.accountBalance}</td>
				<td>${account.odl}</td>
				<td>${account.phoneNo}</td>
			</tr>
		</jstl:forEach>
	</table>
</body>
</html>