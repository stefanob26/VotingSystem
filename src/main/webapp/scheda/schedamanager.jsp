<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.SchedaVotazioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Gestione schede</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a href="SchedaVotazioneServlet?mode=schedelist">Gestione schede</a>
  <a href="UtenteVotanteServlet?mode=votolist">Lista voti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<SchedaVotazioneDTO> list = (List<SchedaVotazioneDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Titolo</th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (SchedaVotazioneDTO s : list) {
		%>
		<tr>
			<td><%=s.getTitolo()%></td>
			<td><a href=SchedaVotazioneServlet?mode=read&id_scheda=<%=s.getId()%>>LEGGI</a></td>
			<td><a href=SchedaVotazioneServlet?mode=read&update=true&id_scheda=<%=s.getId()%>>MODIFICA</a></td>
			<td><a href=SchedaVotazioneServlet?mode=delete&id_scheda=<%=s.getId()%>>ELIMINA</a></td>			
			<td><a href=UtenteVotanteServlet?mode=stat&id_scheda=<%=s.getId()%>>STAT</a></td>
		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="SchedaVotazioneServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="titolo">Titolo</label>
    </div>
    <div class="col-75">
      <input type="text" id="titolo" name="titolo" placeholder="inserisci titolo">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="domanda">domanda</label>
    </div>
    <div class="col-75">
      <input type="text" id="domanda" name="domanda" placeholder="inserisci domanda"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="risposta1">Risposta1</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="risposta1" name="risposta1" placeholder="inserisci risposta1"> 
    	</div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="risposta2">Risposta2</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="risposta2" name="risposta2" placeholder="inserisci risposta2"> 
    	</div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="risposta3">Risposta3</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="risposta3" name="risposta3" placeholder="inserisci risposta3"> 
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>