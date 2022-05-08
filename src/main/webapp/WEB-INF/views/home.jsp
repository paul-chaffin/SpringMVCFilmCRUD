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
		Film ID: <input type="text" name="filmID" size="4" /> <input
			type="submit" value="Search" />
	</form>
	<br>
	<h3>Add a New Film to database:</h3>
	<form action="CreateNewFilm.do" method="POST">
		<label for="title"> <strong>Enter film title:</strong>
		</label><input type="text" name="title" size="25" /> <br> <label
			for="releaseYear"> <strong>Enter release year:</strong>
		</label><input type="text" name="releaseYear" size="4" /> <br> <label
			for="rating"> <strong>Enter rating:</strong>
		</label><input type="text" name="rating" size="4" /> <br> <label
			for="rentalDuration"> <strong>Enter rental duration:</strong>
		</label><input type="text" name="rentalDuration" size="6" /> <br> <label
			for="rentalRate"> <strong>Enter rental rate:</strong>
		</label><input type="text" name="rentalRate" size="6" /> <br> <label
			for="length"> <strong>Enter length:</strong>
		</label><input type="text" name="length" size="6" /> <br> <label
			for="replacementCost"> <strong>Enter replacement
				cost:</strong>
		</label><input type="text" name="replacementCost" size="6" /> <br> <label
			for="languageID"> <strong>Enter language ID:</strong>
		</label><input type="text" name="languageID" size="6" /> <br> <label
			for="description"> <strong>Enter description:</strong>
		</label><input type="text" name="description" size="6" /> <br> <input
			type="submit" value="Add Film" />
	</form>



</body>
</html>