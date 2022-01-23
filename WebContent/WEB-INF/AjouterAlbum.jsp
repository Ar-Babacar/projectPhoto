<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" /> 
<title>Test</title>
</head>
<body>
    <form method="post" action=ajouter-album>
        <p>
            <label for="nom">Nom de l'album: </label>
            <input type="text" name="nom" id="nom" />
        </p>
        <p>
            <label for="theme">Theme : </label>
            <input type="text" name="theme" id="theme" />
        </p>
          <p>
            <label for="description">Description : </label>
            <textarea name="description" id="description" placeholder="Entrez une description présentant pour nous parler de votre album" ></textarea>
        </p>
        <p>
            <label for="status">status : </label>
            <label class="switch">
  <input type="checkbox" name="status">
  <span class="slider"></span>
</label>
        </p>
        
        <input type="submit" />
    </form>
    
   
</body>
</html>