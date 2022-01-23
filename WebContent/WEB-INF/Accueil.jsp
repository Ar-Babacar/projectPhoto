<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" /> 
<title>Test</title>
</head>
<body class="main">
	<div class="top-section">
	<div class="logo"> LOGO</div> <div class="cta-btn"></div>
	</div>
	<div class="main-section">
		<div class="main-section-left">
			<nav class="nav-menu"> 
			 	<div class="nav-menu-items"> 
			 		<div class="nav-menu-item"> 
			 	  <a> </a>
				</div>
				</div>
			</nav>
		</div>
			<div class="main-section-middle">
			 <c:forEach var="album" items="${ albums }">
			 
			 <div class="album">
			 <div class="album-cover">
			 	<div class="album-title"><c:out value="${ album.nom }"/> </div>
			 	<div class="album-photos-count"><c:out value="${ album.count }"/> Photo(s)</div>
			 	<div class="album-date"> créée le : <c:out value="${ album.dateCreation }"/> </div>
			 </div>
			  <div class="album-card-bottom">
			 	<p class="album-description"> <c:out value="${ album.description }"/></p>
			 	<div class="album-owner">
			 		<img src="" /> <div class="album-owner-name"></div>
			 	</div>
			 </div>
			 </div>
      		  </c:forEach>
			
		</div>
			<div class="main-section-right">
		</div>
	</div>
	

    <form method="post" action="accueil">
        <p>
            <label for="nom">Nom : </label>
            <input type="text" name="nom" id="nom" />
        </p>
        <p>
            <label for="prenom">Prénom : </label>
            <input type="text" name="prenom" id="prenom" />
        </p>
        
        <input type="submit" />
    </form>
    
    <ul>
        <c:forEach var="utilisateur" items="${ utilisateurs }">
            <li><c:out value="${ utilisateur.prenom }" /> <c:out value="${ utilisateur.nom }" /></li>
            
        </c:forEach>
        
    </ul>    
</body>
</html>