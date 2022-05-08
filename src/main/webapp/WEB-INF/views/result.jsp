<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film Query</title>
</head>
<body>
  <c:choose>
    <c:when test="${! empty film}">
      <ul>
      	<li><strong>ID:</strong> ${film.id}</li>
        <li><strong>Title:</strong> ${film.title}</li>
        <li><strong>Year:</strong> ${film.releaseYear}</li>
        <li><strong>Rating:</strong> ${film.rating}</li>
        <li><strong>Rental Duration:</strong> ${film.rentalDuration}</li>
        <li><strong>Rental rate:</strong> ${film.rentalRate}</li>
        <li><strong>Language Id:</strong> ${film.languageID}</li>
        <li><strong>Length:</strong> ${film.length}</li>
        <li><strong>Replacement cost:</strong> ${film.replacementCost}</li>
       <%--  <li><strong>Special Features:</strong> ${film.specialFeatures}</li> --%> 
        <li><strong>Description:</strong> ${film.description}</li> 
      </ul>
    </c:when>
    <c:otherwise>
      <p>No film found</p>
    </c:otherwise>
  </c:choose>
  <a href="home.do">Return to main page</a> 
<hr>
  <h3>Delete a film you previously added:</h3>
	<form action="deleteFilm.do" method="GET">
		<label for="deleteFilmID">Film ID:</label>
		<input type="text" name="deleteFilmID" size="4"/> 
		<input type="submit" value="Delete This Film" />
	</form>
<hr>
<h3>Update a film you previously added:</h3>
	<form action="updateFilm.do" method="POST">
		<label for="id">Film Id:</label>
		<input type="text" name="id" size="5" value="${film.id}" readonly/> 
		 <br>
		<label for="title">Title:</label>
		<input type="text" name="title" size="30" value="${film.title}" /> <br>
		<label for="releaseYear">Release year:</label>
		<input type="text" name="releaseYear" size="5" value="${film.releaseYear}" /> <br>
		<label for="rating">Rating:</label>
		<input type="text" name="rating" size="3" value="${film.rating}" /> <br>
		<label for="rentalDuration">Rental duration:</label>
		<input type="text" name="rentalDuration" size="7" value="${film.rentalDuration}" /> <br>
		<label for="rentalRate">Rental rate:</label>
		<input type="text" name="rentalRate" size="7" value="${film.rentalRate}" /> <br>
		<label for="length">Length:</label>
		<input type="text" name="length" size="7" value="${film.length}" /> <br>
		<label for="replacementCost">Replacement cost:</label>
		<input type="text" name="replacementCost" size="7" value="${film.replacementCost}" /> <br>
		<label for="languageID">Language ID:</label>
		<input type="text" name="languageID" size="7" value="${film.languageID}" /> <br>
		<%-- <label for="specialFeatures">Special features:</label>
		<input type="text" name="specialFeatures" size="90" value="${film.specialFeatures}" /> <br> --%>
		<label for="description">Description:</label>
		<input type="text" name="description" size="90" value="${film.description}" /> <br><br>
		<input type="submit" value="Update This Film"/> 
	</form>
</body>
</html>