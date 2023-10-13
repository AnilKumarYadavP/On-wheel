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
</head>
<body>
<h1 style="color: green">${pos}</h1>
    <h1 style="color: red">${neg}</h1>
	<h1>Fetch Product</h1>
	<table border="1" >
		<thead>
			<tr>
				<th>Product Name</th>
				<th>Price</th>
				<th>Image</th>
				<th>Stock</th>
				<th>Description</th>
				<th>remove</th>
				<th>Quantity</th>
				<th>add</th>
				
			</tr>

		</thead>
		
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
					<td><a href="/customer/cart-remove/${product.getId()}" style="text-decoration: none;">-</a></td>
					<td>
						<c:if test="${cartItems==null}">
						0
						</c:if>
						<c:if test="${cartItems!=null}">
						<c:set var="flag" value="true"></c:set>
						<c:forEach var="food" items="${cartItems}">
						<c:if test="${food.getName().equals(item.getName())}">
						${food.getQuantity()}
						<c:set var="flag" value="false"></c:set>
						</c:if>
						</c:forEach>
						<c:if test="${flag==true}">
						0
						</c:if>
						</c:if>
					</td>
					<td><a href="/customer/cart-add/${product.getId()}" style="text-decoration: none;">+</a></td>
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<a href="/customer/viewcart"> <button>ViewCart</button></a>
	<a href="/admin/home"><button>Back</button></a>
	


</body>
</html>