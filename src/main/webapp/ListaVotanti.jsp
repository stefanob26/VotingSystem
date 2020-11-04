<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.UtenteVotanteDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting List</title>
</head>
<body>
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