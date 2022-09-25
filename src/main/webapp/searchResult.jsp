<%@page import="bean.ListaAziende"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyPlacement</title>
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

#nomeUtenteLoggato {
	margin-right: 10px;
	list-style-type: none;
	float: right;
	padding: 5px;
	padding-left: 15px;
	padding-right: 15px;
	border-radius: 5px 5px 5px 5px;
	background-color: #ff8221;
	cursor: pointer;
	border-radius: 5px 5px 5px 5px;
}
</style>

</head>
<body>



	<div style="margin-top: 0px;">
		<ul>
			<li style="border: 3px solid;" id="nomeUtenteLoggato"><a
				style="text-decoration: none; color: black;" href="index.jsp">Indietro</a></li>
		</ul>
	</div>

	<div id="containerLogo" style="margin-top: 5px; width: 100px">
		<img alt="logo" src="logo/logo2.png" width="200" height="200"
			style="margin-top: 10px">
	</div>

	<div
		style="position: absolute; top: 100px; left: 250px; width: 76%; height: auto;"
		id="leftside">
		<div id="formRicerca1"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row1">
			<div style="margin-top: 10px;">

				<%
					try {

						ListaAziende listaAziende = (ListaAziende) session.getAttribute("ricercaAzienda");

						String azienda = (String) session.getAttribute("campoRicerca");
						if (listaAziende.getListaAziende().isEmpty()) {
				%>

				<h3 style="color: red;" align="center">Nessuna azienda trovata</h3>

				<%
					} else {
				%>
				<table>
					<tr>
						<th><h2>Nome Azienda</h2></th>
						<th><h2>Sede</h2></th>
						<th><h2>Numero Telefonico</h2></th>
						<th><h2>Progetto Offerto</h2></th>
					</tr>
					<%
						for (int i = 0; i < listaAziende.getListaAziende().size(); i++) {
					%>


					<tr>
						<td><ul style="margin: 0px 0px; padding: 0px; width: 150px;">
								<a
									href="progettoFormativo.jsp?nomeAzienda=<%=listaAziende.getListaAziende().get(i).getNome()%>"
									style="text-decoration: none; text-align: center; color: black;"><li><%=listaAziende.getListaAziende().get(i).getNome()%></li></a>
							</ul></td>
						<td><%=listaAziende.getListaAziende().get(i).getSede()%></td>
						<td><%=listaAziende.getListaAziende().get(i).getNumerotelefono()%></td>
						<td><%=listaAziende.getListaAziende().get(i).getProgettoofferto()%></td>
					</tr>
					<%
						}
							}
						} catch (Exception e) {
							response.sendRedirect(request.getContextPath() + "/pageNotFound.jsp");
						}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>