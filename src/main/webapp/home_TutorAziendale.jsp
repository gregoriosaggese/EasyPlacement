<%@page import="bean.ListaTirocini"%>
<%@page import="bean.ListaUtenti"%>
<%@page import="bean.TutorAziendale"%>
<%@page import="bean.ListaProgettiFormativi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EasyPlacement</title>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="javaScript/librerieJQuery/jquery.js"></script>
<script type="text/javascript" src="javaScript/visualizzaCampi.js"></script>
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

a:link, a:visited {
	background-color: #ff8221;
	color: black;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

#buttonLogout a {
	margin-top: -10px;
	margin-right: -10px;
	margin-bottom: -10px;
	margin-left: -10px;
	padding: 5px;
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
			<li class=richiestaStudente>Convalida Documento</li>
			<li class=consultaRegistro>Compila Questionario</li>
			<li class=compilaModuli>Firma Presenze</li>
			<li class=progettoFormativo>Consulta Registro</li>
		</ul>
	</div>


	<%
		try {

			TutorAziendale tutor_Aziendale = (TutorAziendale) session.getAttribute("user");
			ListaTirocini listaTirocini = (ListaTirocini) session.getAttribute("listaTirocini");
			ListaProgettiFormativi lista = (ListaProgettiFormativi) session.getAttribute("listaprogettiFormativi");
	%>

	<div
		style="position: absolute; top: 100px; left: 250px; width: 76%; height: auto;"
		id="leftside">

		<form action="FirmaDocumento" method="post" name="firmadocumento">

			<div id="formRicerca"
				style="position: absolute; top: 50px; height: 100%; width: 100%;"
				class="row">

				<table class="table" style="position: absolute; top: 50px;">
					<%
						for (int i = 0; i < lista.getListaProgettoFormativo().size(); i++) {

								if (lista.getListaProgettoFormativo().get(i).getNome_Utente_Tutor_Aziendale()
										.equalsIgnoreCase(tutor_Aziendale.getUsername())) {
									if (lista.getListaProgettoFormativo().get(i).isFirma_Azienda()) {
										if (lista.getListaProgettoFormativo().get(i).isFirma_Tutor_Aziendale() == false) {
					%>
					<tr>
						<th><%=lista.getListaProgettoFormativo().get(i).getNome()%></th>
						<th><%=lista.getListaProgettoFormativo().get(i).getCognome()%></th>

						<th><input
							style="width: 100%; height: 50px; margin: 0; top: 20px; background-color: #ff8221; border: 1px solid;"
							type="submit" name="action"
							value="Firma<%=" " + lista.getListaProgettoFormativo().get(i).getId()%>"></th>


					</tr>
					<%
						}
									} else {
					%>

					<%
						}
								} else {
					%>

					<%
						}
							}
					%>
				</table>

			</div>

		</form>


		<div id="consultaRegistro"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">


			<%
				ListaUtenti listaUtenti1 = (ListaUtenti) session.getAttribute("listaUtenti");
					int o = 0;

					/*for (int i = 0; i < lista.getListaProgettoFormativo().size(); i++) {
						if (tutor_Aziendale.getUsername().equalsIgnoreCase(
								lista.getListaProgettoFormativo().get(i).getNome_Utente_Tutor_Aziendale())) {
							int id = lista.getListaProgettoFormativo().get(i).getId();
							for (int y = 0; y < listaTirocini2.getListaTirocini().size(); y++) {
								if (id == listaTirocini2.getListaTirocini().get(y).getId()) {
									for (int z = 0; z < listaUtenti.getListaUtenti().size(); z++) {
										if (id == listaUtenti.getListaUtenti().get(z).getUserId()) {
											String iniziale = listaUtenti.getListaUtenti().get(z).getNome().substring(0, 1);
											String finale = listaUtenti.getListaUtenti().get(z).getNome().substring(1,
													listaUtenti.getListaUtenti().get(z).getNome().length());
											String nom = iniziale.toUpperCase() + finale.toLowerCase();
					
											String inizial = listaUtenti.getListaUtenti().get(z).getCognome().substring(0,
													1);
											String fina = listaUtenti.getListaUtenti().get(z).getCognome().substring(1,
													listaUtenti.getListaUtenti().get(z).getCognome().length());
											String cognom = inizial.toUpperCase() + fina.toLowerCase();*/

					for (int i = 0; i < lista.getListaProgettoFormativo().size(); i++) {
						if (lista.getListaProgettoFormativo().get(i).getNome_Utente_Tutor_Aziendale()
								.equalsIgnoreCase(tutor_Aziendale.getUsername())) {
							int id = lista.getListaProgettoFormativo().get(i).getId();
							for (int x = 0; x < listaTirocini.getListaTirocini().size(); x++) {
								if (lista.getListaProgettoFormativo().get(i).getId() == listaTirocini.getListaTirocini()
										.get(x).getId() && listaTirocini.getListaTirocini().get(x).isCompletato() == true) {
									for (int z = 0; z < listaUtenti1.getListaUtenti().size(); z++) {
										if (id == listaUtenti1.getListaUtenti().get(z).getUserId()) {
											String iniziale = listaUtenti1.getListaUtenti().get(z).getNome().substring(0,
													1);
											String finale = listaUtenti1.getListaUtenti().get(z).getNome().substring(1,
													listaUtenti1.getListaUtenti().get(z).getNome().length());
											String nom = iniziale.toUpperCase() + finale.toLowerCase();

											String inizial = listaUtenti1.getListaUtenti().get(z).getCognome().substring(0,
													1);
											String fina = listaUtenti1.getListaUtenti().get(z).getCognome().substring(1,
													listaUtenti1.getListaUtenti().get(z).getCognome().length());
											String cognom = inizial.toUpperCase() + fina.toLowerCase();
											o = 1;
			%>
			<a style="border: 3px solid;" href="questionarioAzienda.jsp">Vai
				a compila questionario di: <%=nom + " " + cognom%></a>
			<%
				}
									}
								}
							}
						}
					}
			%>

			<%
				if (o == 0) {
			%>
			<h1>Non è possibile accedere al questionario</h1>
			<h5>Tirocinio non completato</h5>
			<%
				}
			%>

		</div>

		<div id="compilaModuli"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">

			<div class="panel-heading">
				<h2 style="color: #ff8221; size: 100px; font-family: sans-serif;">Firma
					presenza studente</h2>
			</div>

			<%
				ListaUtenti listaUtenti = (ListaUtenti) session.getAttribute("listaUtenti");
					ListaTirocini listaTirocini2 = (ListaTirocini) session.getAttribute("listaTirocini");
					for (int i = 0; i < lista.getListaProgettoFormativo().size(); i++) {
						if (tutor_Aziendale.getUsername().equalsIgnoreCase(
								lista.getListaProgettoFormativo().get(i).getNome_Utente_Tutor_Aziendale())) {
							int id = lista.getListaProgettoFormativo().get(i).getId();
							for (int y = 0; y < listaTirocini2.getListaTirocini().size(); y++) {
								if (id == listaTirocini2.getListaTirocini().get(y).getId()) {
									for (int z = 0; z < listaUtenti.getListaUtenti().size(); z++) {
										if (id == listaUtenti.getListaUtenti().get(z).getUserId()) {
											String iniziale = listaUtenti.getListaUtenti().get(z).getNome().substring(0, 1);
											String finale = listaUtenti.getListaUtenti().get(z).getNome().substring(1,
													listaUtenti.getListaUtenti().get(z).getNome().length());
											String nom = iniziale.toUpperCase() + finale.toLowerCase();

											String inizial = listaUtenti.getListaUtenti().get(z).getCognome().substring(0,
													1);
											String fina = listaUtenti.getListaUtenti().get(z).getCognome().substring(1,
													listaUtenti.getListaUtenti().get(z).getCognome().length());
											String cognom = inizial.toUpperCase() + fina.toLowerCase();
			%>
			<a style="border: 3px solid; margin-top: 20px; margin-right: 20px;"
				href="firmaPresenze.jsp?id_studente=<%=listaUtenti.getListaUtenti().get(z).getUserId()%>"><%=nom + " " + cognom%></a>
			<%
				}
									}
								}
							}
						}
					}
			%>
		</div>

		<div id="progettoFormativo"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">


			<div class="panel-heading">
				<h2
					style="color: #ff8221; size: 100px; font-family: sans-serif; margin-bottom: 20px;">Consulta
					Registro di:</h2>
			</div>

			<%
				ListaProgettiFormativi lisaPF = (ListaProgettiFormativi) session.getAttribute("listaprogettiFormativi");

					for (int i = 0; i < lisaPF.getListaProgettoFormativo().size(); i++) {
						if (tutor_Aziendale.getUsername().equalsIgnoreCase(
								lisaPF.getListaProgettoFormativo().get(i).getNome_Utente_Tutor_Aziendale())) {
			%>
			<a
				href="consultaRegistro.jsp?uid=<%=lisaPF.getListaProgettoFormativo().get(i).getId()%>"
				style="background-color: #ff8221; color: black; padding: 14px 25px; text-align: center; text-decoration: none; display: inline-block; border: 3px solid;"><%=lisaPF.getListaProgettoFormativo().get(i).getNome() + "  "
								+ lisaPF.getListaProgettoFormativo().get(i).getCognome()%></a>
			<%
				}
					}
			%>

		</div>
		<%
			} catch (Exception e) {
				response.sendRedirect(request.getContextPath() + "/pageNotFound.jsp");
			}
		%>


	</div>
</body>
</html>

