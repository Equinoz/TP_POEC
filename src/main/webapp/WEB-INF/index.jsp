<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sceance</title>
</head>
<body>
	<c:forEach items="${model.list }" var="notation">
		<p>${seance.sceanceId}${seance.filmId} ${seance.salleId}
			${sceance.film.nom}</p>
	</c:forEach>
	<h3>${model.curent}</h3>
	<h2>${model.list}</h2>
</body>
</html>