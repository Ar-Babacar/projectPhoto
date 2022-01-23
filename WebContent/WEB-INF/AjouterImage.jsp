<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter une image</title>
</head>
<body>
<h1 style="color:red" align="center">Ajouter les details de l'image</h1>

<div align="center">
<form action=ajouter-image method="post" enctype="multipart/form-data">
	Select image : 
	<input type="file" name="image">
	<input type="submit" value="Add Image">
</form>
</div>
</body>
</html>