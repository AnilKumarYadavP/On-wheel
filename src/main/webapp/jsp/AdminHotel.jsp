<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
  border-collapse: collapse;
  width: 98vw;
  margin-bottom: 30px;
  border: solid black;
 }
 tr, th,td {
	border:  solid black;
	padding: 8px;
	text-align: center;
}
th {
	background-color: orange;
	color: black;
}

a{
	text-decoration: none;
	font-size: 30px;
}
</style>
</head>
<body>
	<h3>${pos}</h3>
		<h2>${neg}</h2>
		<table>
			<thead>
				<tr>
					<th>Hotel Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="hotel" items="${hotels}">
					<tr>
						<td>${hotel.getName()}</td>
						<td>${hotel.getEmail()}</td>
						<td>${hotel.getMobile()}</td>
						<td>${hotel.isStatus()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		
			<a href="/admin/home"><button>Back</button></a>
		
</body>
</html>