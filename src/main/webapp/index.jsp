<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CRUD Voiture</title>
	</head>
	<body>

		<a href="${rootUrl}/AjouterVoiture.jsp">Ajouter une voiture</a> <br> <br>
	
		<a href="${rootUrl}/ModifierVoiture.jsp">Modifier une voiture</a> <br> <br>
		
		
		<a href="${rootUrl}/SupprimerVoiture.jsp">Supprimer une voiture</a> <br> <br>
		
		Afficher les Voitures disponibles: 
		   <form action="VoitureServlet" method="POST">
		        <input type="submit" name="afficherVoiture" value="Liste"> &nbsp; &nbsp;<br>          
		    </form>
	        
	</body>
</html>