<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
h1{
	color: orange;
	text-indent: 50px;
	text-overflow: ellipsis;
	text-shadow:3px 3px 3px black;
}
body{
	text-align: center;
	height: 300px;
	width: 400px;
	border: 1px solid; 
	margin:20px 10px 10px 50px;
 background: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSB9hwFjVm9UfaQRKCLeGQKwScNpxSi2TZMUg&usqp=CAU);
	background-repeat:no-repeat;
	background-size: contain; 
}

button {
	text-align: center;
	background: orange;
	text-shadow:2px 2px buttonshadow;
}
table {
	background: transparent;
	align-items: center;
	
}
</style>
<body>
<h1 style="color: green">${pos}</h1>
    <h1 style="color: red">${neg}</h1>
	 <h1>Admin Home</h1>
<table border="1"> 
<tr>
   	<a href="/admin/fetch-products"><button>Approve Products</button></a> <br> <br>
    <a href="/admin/fetch-hotels"><button>View Hotel</button></a>  <br> <br>
    <a href="/admin/fetch-customers"><button>View Customers</button></a> <br> <br>
    <a href="/logout"><button>Logout</button></a>
</tr>
</table>	

</body>
</html>