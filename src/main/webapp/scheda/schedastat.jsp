<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Statistica scheda id<%=Integer.parseInt(request.getParameter("id_scheda"))%></title>
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
<%double[] risultati = (double[]) request.getAttribute("risultati");%>
<table>
	<tr> 
		<th><%=request.getAttribute("risposta1").toString()%></th>
		<th><%=request.getAttribute("risposta2").toString()%></th>
		<th><%=request.getAttribute("risposta3").toString()%></th>
	</tr>
	<tr>
		<td><%=risultati[0]%></td>
		<td> <%=risultati[1]%></td>
		<td> <%=risultati[2]%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>