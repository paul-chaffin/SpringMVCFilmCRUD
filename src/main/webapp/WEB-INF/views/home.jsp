<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>
<body>

<h1>Welcome to Our Film Query and Database Site</h1>

<h3>Search for a Film by Film ID</h3>
	<form action="FindFilmByID.do" method="GET">
		Film ID:
		<input type="text" name="filmID" size="4"/> 
		<input type="submit" value="Search" />
	</form>


</body>
</html>