<%@page import="Entidades.Personaje"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function ingresarID(){
	var id1=document.getElementById("id1");
	var id2=document.getElementById("id2");
	if(id1.value=="" || id2.value==""){
		alert("ingrese los ID")
	}
	else{
		var form=document.getElementById("formBuscarSeleccionado");
		form.submit();
	}
}
</script>
</head>
<body>
<form action="SeleccionarPersonajes" method="post" id="formBuscarSeleccionado" name="formBuscarSeleccionado">
  <input type="hidden" name="accion" id="accion">
  <table border="1" align="center">
    <tr>
      <td>
      <label>Id</label>
      <input type="text" id="id1" name="id1">
      </td>
      <td>
      <label>Id</label>
      <input type="text" id="id2" name="id2">
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
      <input type="button" value="Seleccionar" onclick="ingresarID();">
      </td>
    </tr>
  </table>
</form>

<table>
  <tr>
    <td>
    
    </td>
  </tr>
</table>
</body>
</html>