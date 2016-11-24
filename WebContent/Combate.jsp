<%@page import="Controlador.ControladorJuego"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Personaje"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Combate</title>
<script type="text/javascript">
function carga(){
	document.getElementById("energia").focus();
}
function atacar(){
	var energia=document.getElementById("energia");
	if(energia.value=="")
		{
		alert("Ingrese energia");
		}
	else{
	var form = document.getElementById("formJugar");
	form.action="Combate";
	var accion = document.getElementById("accion");
	accion.value="atacar";
	form.submit();
	}
}
function defender(){
	var form = document.getElementById("formJugar");
	form.action="Combate";
	var accion = document.getElementById("accion");
	accion.value="defender";
	form.submit();
}

</script>
</head>
<body onload = "carga(); ">
<%Personaje personaje1= (Personaje)session.getAttribute("per1"); 
Personaje personaje2=(Personaje)session.getAttribute("per2");
ControladorJuego ctrl=(ControladorJuego)session.getAttribute("ctrl");
if((Boolean)session.getAttribute("evadio"))
    {%>
	<script type="text/javascript"> alert("Evadio el ataque")</script>
	<%
	}
  if((Boolean)session.getAttribute("gano")){
	 
  %>	
  <script type="text/javascript">alert("Gano") </script>
  <%
  }
  %>

<table align="center" border="2">
  <tr>
    <td><leable>Nombre: </leable> <%=personaje1.getNombre() %></td>
    <td><leable>Nombre: </leable><%=personaje2.getNombre() %></td>
  </tr>
  <tr>
    <td><leable>Energia: </leable><%=personaje1.getEnergia() %></td>
    <td><leable>Energia: </leable><%=personaje2.getEnergia() %></td>
  </tr>
  <tr>
    <td><leable>Vida: </leable><%=personaje1.getVida() %></td>
    <td><leable>Vida: </leable><%=personaje2.getVida() %></td>
  </tr>
  <tr>
    <td><leable>Evasión: </leable><%=personaje1.getEvasion() %></td>
    <td><leable>Evasión: </leable><%=personaje2.getEvasion() %></td>
  </tr>
  
</table>
<label>Turno: </label><%=((ControladorJuego)session.getAttribute("ctrl")).getTurno() %>

<form method="post" id="formJugar" action="">
  <input type="hidden" id="accion" name="accion">
  <leable>Energia a utilizar: <input type="text" id="energia" name="energia"></leable>
  <input type="button" value="atacar" onclick="atacar();">
  <input type="button" value="defender" onclick="defender();">
</form>
<a href="Seleccionar.jsp">Volver a seleccion de personajes</a>
</body>
</html>