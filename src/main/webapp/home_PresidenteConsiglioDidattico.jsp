<%@page import="bean.ListaTirocini"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="bean.ListaRegistro"%>
<%@page import="bean.PresidenteConsiglioDidattico"%>
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
			<li class=consultaRegistro>Convalida finale Tirocinio</li>
		</ul>
	</div>


	<%
		try {

			PresidenteConsiglioDidattico presidentePCD = (PresidenteConsiglioDidattico) session
					.getAttribute("user");

			ListaProgettiFormativi lista = (ListaProgettiFormativi) session.getAttribute("listaprogettiFormativi");
			ListaTirocini tirocini = (ListaTirocini) session.getAttribute("listaTirocini");
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

								if (lista.getListaProgettoFormativo().size() != 0) {
									if (lista.getListaProgettoFormativo().get(i).isFirma_Azienda()) {
										if (lista.getListaProgettoFormativo().get(i)
												.isFirma_Presidente_Consiglio_Didattico() == false) {
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
				ListaProgettiFormativi lista2 = (ListaProgettiFormativi) session.getAttribute("listaprogettiFormativi");

					System.out.println(lista2.getListaProgettoFormativo().size());
					ListaRegistro registro = (ListaRegistro) session.getAttribute("listaRegistro");
					int o = 0;
					for (int i = 0; i < lista2.getListaProgettoFormativo().size(); i++) {
						if (lista.getListaProgettoFormativo().get(i).isFirma_Azienda() == true
								&& lista2.getListaProgettoFormativo().get(i)
										.isFirma_Presidente_Consiglio_Didattico() == true
								&& lista2.getListaProgettoFormativo().get(i).isFirma_Studente() == true
								&& lista2.getListaProgettoFormativo().get(i).isFirma_Tutor_Accademico() == true
								&& lista2.getListaProgettoFormativo().get(i).isFirma_Tutor_Aziendale() == true) {
							System.out.println(lista2.getListaProgettoFormativo().get(i).getDataFine());
							for (int x = 0; x < registro.getListaRegistro().size(); x++) {

								

								GregorianCalendar data1 = new GregorianCalendar();
								DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
								Date d1 = format.parse(lista2.getListaProgettoFormativo().get(i).getDataFine());
								data1.setTime(d1);

								String data = format.format(data1.getTimeInMillis() - 24 * 60 * 60 * 100);

								

								if (lista2.getListaProgettoFormativo().get(i).getId() == registro.getListaRegistro().get(x)
										.getId() && data.equalsIgnoreCase(registro.getListaRegistro().get(x).getData())
										&& registro.getListaRegistro().get(x).getIsFirmed() == true) {
									for (int y = 0; y < tirocini.getListaTirocini().size(); y++) {
										if (tirocini.getListaTirocini().get(y).isCompletato() == false) {
											o = 1;
			%>

			<form action="ConvalidaFinaleTirocinio" method="post"
				name="convalidafinale">
				<input style="display: none;" type="text" name="id"
					value="<%=lista2.getListaProgettoFormativo().get(i).getId()%>">
				<a><%=lista2.getListaProgettoFormativo().get(i).getNome()%></a> <a><%=lista2.getListaProgettoFormativo().get(i).getCognome()%></a>
				<input style="cursor: pointer;" type="submit"
					value="Convalida Tirocinio">
			</form>

			<%
				}
									}
								}
							}
						}
					}

					if (o == 0) {
			%>
			<h1>Nessuno studente ha completato il tirocinio</h1>

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

