<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.apache.commons.codec.binary.Base64"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
border-collapse: collapse;
width: 98vw;
align-items: center;
}
tr,td,th{
align-items: center;
padding: 8px;

}
th{
background: orange;
}
</style>
</head>
<body>
	<h3>${pos}</h3>
	<h2>${neg}</h2>
	
		<table border="1">
			<tr>
				<th>Customer Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Status</th>
			</tr>
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.getName()}</td>
					<td>${customer.getEmail()}</td>
					<td>${customer.getMobile()}</td>
					<td>${customer.isStatus()}</td>
				</tr>
			</c:forEach>
		</table>
		<br>

	<a href="/admin/home" class="button">
		<button>Back</button>
	</a>
</body>
</html>