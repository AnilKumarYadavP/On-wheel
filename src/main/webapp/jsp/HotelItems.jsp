<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
 table{
  border-collapse: collapse;
  width: 98vw;
  margin-bottom: 30px;
  border: solid black;
 }
 th, td {
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
<body>
<h1 style="color: green">${pos}</h1>
    <h1 style="color: red">${neg}</h1>
	<h1>Fetch Product</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Image</th>
				<th>Stock</th>
				<th>Description</th>
				<th>Delete</th>
				<th>Edit</th>
				
			</tr>

		</thead>
		<tbody>
		<tbody>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.getName()}</td>
					<td>${product.getPrice()}</td>
					<c:set var="base64"
							value="${Base64.encodeBase64String(product.getImage())}"></c:set>
				    <td><img
						height="100px" width="100px" alt="unknown"
						src="data:image/jpeg;base64,${base64}">
					</td>
					
					
					<td>${product.getStock()}</td>
					<td>${product.getDescription()}</td>
					<td><a href="/hotel/delete/${product.getId()}"><button>Delete</button></a></td>
					<td><a href="/hotel/edit/${product.getId()}"><button>Edit</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<a href="/hotel/home"><button>Back</button></a>
	

















</body>
</html>