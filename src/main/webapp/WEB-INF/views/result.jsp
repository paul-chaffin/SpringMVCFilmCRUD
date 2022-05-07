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
        <li><strong>Title:</strong> ${film.title}</li>
        <li><strong>Year:</strong> ${film.releaseYear}</li>
        <li><strong>Rating:</strong> ${film.rating}</li>
        <li><strong>Rental Duration:</strong> ${film.rentalDuration}</li>
        <li><strong>Rental rate:</strong> ${film.rentalRate}</li>
        <li><strong>Replacement cost:</strong> ${film.replacementCost}</li>
      </ul>
    </c:when>
    <c:otherwise>
      <p>No film found</p>
    </c:otherwise>
  </c:choose>
  <a href="home.do">Return to main page</a>
</body>
</html>