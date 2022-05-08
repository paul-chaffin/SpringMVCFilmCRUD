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
					<td>ID: ${film.id}</td>
					<td>Title: ${film.title}</td>
					<td>Year: ${film.releaseYear}</td>
					<td>Rating: ${film.rating}</td>
					<td>Rental Duration: ${film.rentalDuration}</td>
					<td>Rental rate: ${film.rentalRate}</td>
					<td>Language Id: ${film.languageID}</td>
					<td>Length: ${film.length}</td>
					<td>Replacement cost: ${film.replacementCost}</td>
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