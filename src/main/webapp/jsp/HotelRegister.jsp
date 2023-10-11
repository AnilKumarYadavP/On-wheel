<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
/* Global Styles */
body {
    background-color: white;
    color: orange;
    font-family: Arial, sans-serif;
    text-align: center;
    margin: 0;
    padding: 0;
}

/* Header Styles */
h1 {
    font-size: 24px;
}

h1[style*="color: green"] {
    color: orange;
}

h1[style*="color: red"] {
    color: black;
}

/* Logo Styles */
h2.logo {
    color: orange;
    font-size: 36px;
    margin-top: 20px;
}

h2.logo img {
    width: 24px;
    vertical-align: middle;
    margin-left: 10px;
}

/* Table Styles */
table {
    border-collapse: collapse;
    margin: 0 auto;
    width: 80%;
    max-width: 800px;
}

table, th, td {
    border: 1px solid ;
    border-collapse: collapse;
    
}

th, td {
    padding: 10px;
    
}

th {
    background-color: black;
    color: orange;
}

/* Form Styles */
mvc\\:form {
    margin-top: 20px;
}

button {
    background-color: black;
    color: orange;
    border: none;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
    margin: 10px;
}

button[type="reset"] {
    margin-left: 30px;
}

/* Back Button Styles */
a button {
    background-color: orange;
    color: black;
    text-decoration: none;
    border: none;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
}

a button:hover {
    background-color: black;
    color: orange;
}
</style>
</head>
<body>
	<h1 style="color: green">${pos}</h1>
	<h1 style="color: red">${neg}</h1>
	
              
            <h2 class="logo">On-Wheel   <img src="/images/motorcycle-solid.svg" alt="" ></h2>  
            
		 
		
				 <mvc:form action="/hotel/register" method="post" modelAttribute="hotel">
			 <table border="1"  style="color:black;">
				 <tr>
					 <th>Name:</th>
					 <th><mvc:input path="name" /></th>
					 <th><mvc:errors path="name" /></th>
				 </tr>
				 <tr>
					 <th>Email:</th>
					 <th><mvc:input path="email" /></th>
					 <th><mvc:errors path="email" /></th>
				 </tr>
				 <tr>
					 <th>Password:</th>
					 <th><mvc:password path="password" /></th>
					 <th><mvc:errors path="password" /></th>
				 </tr>
				 <tr>
					 <th>Mobile:</th>
					 <th><mvc:input path="mobile" /></th>
					 <th><mvc:errors path="mobile" /></th>
				 </tr>
				 <tr>
				 
		</table><br>
			 <button >Login</button>
			 <button type="reset" style="margin-left: 30px">Cancel</button>
		 </mvc:form>
		
					<br>
			 <a href="/"><button>Back</button></a>
		
		

</body>
</html>