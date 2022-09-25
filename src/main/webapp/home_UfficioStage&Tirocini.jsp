<%@page import="bean.ListaUtenti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyPlacement</title>


<script type="text/javascript" src="javaScript/librerieJQuery/jquery.js"></script>
<script type="text/javascript" src="javaScript/visualizzaCampi.js"></script>
<script type="text/javascript"
	src="javaScript/registerLoginValidator.js"></script>

<%@include file="includesPage/stylesheets.html"%>


<style>
table {
	font-family: arial, sans-serif;
	border-color: white;
	width: 100%;
}

td, th {
	border-color: white;
	text-align: left;
	padding: 8px;
	background-color: white;
}
</style>

</head>
<body>

	<div id="containerLogo" style="margin-top: 5px; width: 100px">
		<img alt="logo" src="logo/logo2.png" width="200" height="200"
			style="margin-top: 10px">
	</div>

	<div style="position: absolute;" id="leftside">
		<ul id="leftsideNav">
			<li class=richiestaStudente>Elimina Account</li>
			<li class=compilaModuli>Modifica Account</li>
		</ul>
	</div>


	<%
		try {

			ListaUtenti lista = (ListaUtenti) session.getAttribute("listaUtenti");
	%>


	<div
		style="position: absolute; top: 150px; left: 250px; width: 76%; height: auto;"
		id="leftside">


		<div id="formRicerca"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">

			<div class="panel-heading">
				<h2 style="color: #ff8221; size: 100px; font-family: sans-serif;">Elimina
					Account</h2>
			</div>



			<%
				for (int i = 0; i < lista.getListaUtenti().size(); i++) {
			%>

			<form style="position: relative; left: -110px; top: 50px;"
				action="EliminaAccount" method="post" name="eliminaaccount">
				<input style="display: none;" type="text" name="id"
					value="<%=lista.getListaUtenti().get(i).getUserId()%>"> <label
					style="top: 20px;">Nome</label> <input type="text"
					name="nomeStudente" readonly="readonly"
					value="<%=lista.getListaUtenti().get(i).getNome()%>"> <label
					style="top: 83px;">Cognome</label> <input type="text"
					name="cognomeStudente" readonly="readonly"
					value="<%=lista.getListaUtenti().get(i).getCognome()%>"> <label>Username</label><input
					type="text" name="usernameStudente" readonly="readonly"
					value="<%=lista.getListaUtenti().get(i).getUsername()%>"> <input
					type="submit" value="Elimia" style="background-color: #ff8221">
			</form>
			<%
				}
			%>

		</div>

		<div id="compilaModuli"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">

			<div class="panel-heading">
				<h2 style="color: #ff8221; size: 100px; font-family: sans-serif;">Modifica
					Account</h2>
			</div>

			<%
				for (int i = 0; i < lista.getListaUtenti().size(); i++) {
			%>

			<form style="position: relative; left: -110px; top: 50px;"
				action="ModificaAccount" method="post" name="register"
				onsubmit="return(registerValidator())">

				<input style="display: none;" type="text" name="id"
					value="<%=lista.getListaUtenti().get(i).getUserId()%>"> <label
					style="top: 20px;">Nome</label> <input type="text" name="nome"
					readonly="readonly"
					value="<%=lista.getListaUtenti().get(i).getNome()%>"> <label
					style="top: 83px;">Cognome</label><input type="text" name="cognome"
					readonly="readonly"
					value="<%=lista.getListaUtenti().get(i).getCognome()%>"> <label
					style="top: 150px;">Username</label><input type="text"
					name="username"
					value="<%=lista.getListaUtenti().get(i).getUsername()%>"><label
					style="top: 215px;">Email</label> <input type="text"
					name="emailRegistrazione"
					value="<%=lista.getListaUtenti().get(i).getEmail()%>"> <label
					style="top: 282px;">Telefono</label><input type="text"
					name="numTelefono"
					value="<%=lista.getListaUtenti().get(i).getNumeroTelefono()%>">
				<label style="top: 345px;">Password</label> <input type="text"
					name="passwordRegistrazione"
					value="<%=lista.getListaUtenti().get(i).getPassword()%>"> <input
					type="submit" value="Modifica" style="background-color: #ff8221">
			</form>


			<%
				}
				} catch (Exception e) {
					response.sendRedirect(request.getContextPath() + "/pageNotFound.jsp");
				}
			%>

		</div>

	</div>

</body>
</html>
