<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update card</title>
<link href="../css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@ include file="../css/header.jsp" %>
	<form action="SchedaVotazioneServlet?mode=update" method="post">

		<input type="text" id ="SchedaTitolo" name ="titolo" value ="${request.getParameter("titolo")}" required>
		<input type="text" id ="Domanda" name ="domanda" value ="${request.getParameter("domanda")}" required>

		<input type="text" id="Risposta1" name ="risposta1" value ="${request.getParameter("risposta1")}" required>
		<input type="text" id="Risposta2" name ="risposta2" value ="${request.getParameter("risposta2")}" required>
		<input type="text" id="Risposta3" name ="risposta3" value ="${request.getParameter("risposta3")}" required>
		<input type = "submit" value = "invia"> 

	</form>

	<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>