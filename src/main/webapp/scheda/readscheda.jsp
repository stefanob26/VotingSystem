<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SchedaVotazioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="UserServlet?mode=userlist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">

  <%SchedaVotazioneDTO s = (SchedaVotazioneDTO) request.getAttribute("dto");%>
   
<table>
	<tr> 
		<th>id_scheda</th>
		<th>titolo</th>
		<th>domanda</th>
		<th>risposta1</th>
		<th>risposta2</th>
		<th>risposta3</th>
	</tr>
	<tr>
		<td><%=s.getId()%></td>
		<td> <%=s.getTitolo()%></td>
		<td> <%=s.getDomanda()%></td>
		<td><%=s.getRisposta1()%></td>
		<td> <%=s.getRisposta2()%></td>
		<td> <%=s.getRisposta3()%></td>
	</tr>	
</table>
    

</div> 

<%@ include file="../css/footer.jsp" %>
</body>
</html>