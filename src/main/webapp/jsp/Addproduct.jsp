<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 table{
  border-collapse: collapse;
  width: 50vw;
  margin-bottom: 30px;
  border: solid black;
  text-align: center;
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
	<table>
	 <form action="/hotel/add-product" method="post" enctype="multipart/form-data">
       
        Name: <input type="text" name="name" required><br>
        Price: <input type="text" name="price" required><br>
        Image: <input type="file" name="pic" ><br>
        Stock: <input type="number" name="stock" required><br>
        Description: <input type="text" name="description" required><br>
        <input type="submit" value="Submit">
        <input type="reset" value="Cancel">
        
    </form>
</table>
	<a href="/hotel/home"><button>Back</button></a>
</body>
</html>