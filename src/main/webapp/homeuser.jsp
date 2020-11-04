<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.SchedaVotazioneDTO"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Utente</title>

<link href="css/vittoriostyle.css" rel="stylesheet">
<link href="css/styleHomeUser.css" rel="stylesheet">

<script type="text/javascript">
	
	document.addEventListener("DOMContentLoaded", function(){
		
		var btn1 = document.getElementById("btn1");
		var btn2 = document.getElementById("btn2");
		
		btn1.addEventListener("click",function (){
			var el1 = document.getElementsByClassName("main")[0];
			var el2 = document.getElementsByClassName("listaSchede")[0];
			var btn1 = document.getElementById("btn1");
			var btn2 = document.getElementById("btn2");
			el1.style.display = "block";
			el2.style.display = "none";
			btn1.style.background = "#00ccad";
			btn2.style.background = "#00a990";
		});
		
		btn2.addEventListener("click",function (){
			var el1 = document.getElementsByClassName("main")[0];
			var el2 = document.getElementsByClassName("listaSchede")[0];
			var btn1 = document.getElementById("btn1");
			var btn2 = document.getElementById("btn2");
			el1.style.display = "none";
			el2.style.display = "block";
			btn1.style.background ="#00a990";
			btn2.style.background ="#00ccad";
		});		
	}, false);

</script>
</head>
<body>
<div id="bodyContainer">
<%@include file="css/header.jsp"%>


<div class="navbar">
  
  <div id="btn1">Home</div>
  <div id="btn2">Vota</div>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
	
	<div id="container">
		<div class="primaColonna">ID</div><div class="secondaColonna">${user.getId()}</div>
		<div class="primaColonna">USERNAME</div><div class="secondaColonna">${user.getUsername()}</div>
		<div class="primaColonna">TIPO UTENTE</div><div class="secondaColonna">${user.getUsertype()}</div>
	</div>
</div>

<div class="listaSchede">

	<%
		List<SchedaVotazioneDTO> list = (List<SchedaVotazioneDTO>) request.getAttribute("list");
	%>

<br>
	<table>
		<tr>
			<th>titolo</th>
			<th></th>
		<tr>
		<%
			for (SchedaVotazioneDTO s : list) {
		%>
		<tr>
			<td>
				<%=s.getTitolo()%>
			</td>
			<td><a href="UtenteVotanteServlet?mode=control&id_scheda=<%=s.getId()%>">
				VOTA
			</a></td>
		</tr>
		<%
			}
		%>
	</table>

</div>


<%@ include file="css/footer.jsp" %>
</div>
</body>
</html>