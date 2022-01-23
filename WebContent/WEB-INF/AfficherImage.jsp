<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher image</title>
</head>
<body>

<h1 style="color:red" align="center">Afficher les details de l'image</h1>
<div align="center">

</div>
<hr>

<div align="center">
	<table  style="width:600px">
		<tr>
			<th>Image Id</th>
			<th>Image</th>
		</tr>
		<c:if test="${!empty images}">
		<c:forEach items="${ requestScope.images }"
						var="image">
			<tr>
						<td><c:out value="${ image.titre }" /></td>
						<td><img src="${ image.url }" alt="${ image.titre }"/></td>		
		</tr>
		</c:forEach>
		</c:if>
	</table>
</div>
</body>
</html>