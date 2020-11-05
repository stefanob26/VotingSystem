<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.UtenteVotanteDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Voting List</title>
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
	<%
		List<UtenteVotanteDTO> list = (List<UtenteVotanteDTO>) request.getAttribute("list");
	%>

<br>
	<table>
		<thead>
			<tr>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
			<tbody>
			<%
				for (UtenteVotanteDTO u : list) {
			%>
			<tr>
				<td><%=u.getidutente()%></td>
				<td><%=u.getidscheda()%></td>
				<td><%=u.getvoto()%></td>		
			</tr>
			<%	}
			%>
			</tbody>
	</table>

<!-- aggiungere funzione ricerca -->
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>