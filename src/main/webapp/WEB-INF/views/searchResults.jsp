<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film Query</title>
</head>
<body>
	<div>
		<p>
			<c:if test="${! empty films }">
				<h3>Search results: ${keyword}</h3>
			</c:if>
		<table>
			<c:forEach var="film" items="${films}">
				<tr>
					<td><strong>ID:</strong> ${film.id}</td>
					<td><strong>Title:</strong> ${film.title}</td>
					<td><strong>Year:</strong> ${film.releaseYear}</td>
					<td><strong>Rating:</strong> ${film.rating}</td>
					<td><strong>Rental Duration:</strong> ${film.rentalDuration}</td>
					<td><strong>Rental rate:</strong> ${film.rentalRate}</td>
					<td><strong>Language Id:</strong> ${film.languageID}</td>
					<td><strong>Length:</strong> ${film.length}</td>
					<td><strong>Replacement cost:</strong> ${film.replacementCost}</td>
					<td><strong>Description:</strong> ${film.description}</td>
					<td><strong>Category:</strong> ${film.category}</td>
					<td><strong>Cast:</strong>
					<c:forEach var="actor" items="${film.actors}">
					${actor.firstName} ${actor.lastName},
				</c:forEach></td>

				</tr>

			</c:forEach>
		</table>
		</p>
		<p>
			<a href="home.do" class="btn btn-secondary" role="button">Back to
				Home</a>
		</p>
	</div>
</body>
</html>