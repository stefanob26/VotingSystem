<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
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



    <c:choose>
    <c:when test="${request.getParameter("check")=='true'}">
 <div id ="SchedaTitolo" >${request.getParameter("titolo")}</div>
 <div id ="Domanda" >${request.getParameter("domanda")}</div>
<form action="UtenteVotanteServlet" method="post">
<input type= "text" name = "id_utente" value = "${request.getParameter("id_utente")}" style = "display:none" readonly>
<input type= "text" name = "id_scheda" value = "${request.getParameter("id_scheda")}" style = "display:none"readonly>
<input type= "radio" id= "R1" name = "risposta" value "${request.getParameter("risposta1")}" >
<label for = "R1"> ${request.getParameter("risposta1")}</label>
<input type= "radio" id= "R2" name = "risposta" value "${request.getParameter("risposta2")}" >
<label for = "R2"> ${request.getParameter("risposta2")}</label>
<input type= "radio" id= "R3" name = "risposta" value "${request.getParameter("risposta3")}" >
<label for = "R3"> ${request.getParameter("risposta3")}</label>
<input type = "submit" value = "invia"> 
</form>
        <br />
    </c:when>    
    <c:otherwise>
        ATTENZIONE HAI GIA' VOTATO IN QUESTA SCHEDA 
        <a href = UserServlet?mode=back>Indietro</a>
        <br />
    </c:otherwise>
</c:choose>




</div> 

<%@ include file="../css/footer.jsp" %>
</body>
</html>
    