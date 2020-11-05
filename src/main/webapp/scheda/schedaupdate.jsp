<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SchedaVotazioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Update card</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="UserServlet?mode=userlist">Users</a>
  <a href="SchedaVotazioneServlet?mode=schedelist">Gestione schede</a>
  <a href="UtenteVotanteServlet?mode=votolist">Lista voti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">
<%SchedaVotazioneDTO s = (SchedaVotazioneDTO) request.getAttribute("dto");%>

	<form action="SchedaVotazioneServlet?mode=update" method="post">

		<input type="text" id ="SchedaTitolo" name ="titolo" value ="<%=s.getTitolo()%>" required>
		<input type="text" id ="Domanda" name ="domanda" value ="<%=s.getDomanda() %>" required>

		<input type="text" id="Risposta1" name ="risposta1" value ="<%=s.getRisposta1()%>" required>
		<input type="text" id="Risposta2" name ="risposta2" value ="<%=s.getRisposta2()%>" required>
		<input type="text" id="Risposta3" name ="risposta3" value ="<%=s.getRisposta3()%>" required>
		<input type="text" name ="id_scheda" value = "<%=s.getId() %>" style = "display:none" readonly>
		<input type = "submit" value = "invia"> 

	</form>
	<br>
</div>
	
<%@ include file="../css/footer.jsp" %>
</body>
</html>