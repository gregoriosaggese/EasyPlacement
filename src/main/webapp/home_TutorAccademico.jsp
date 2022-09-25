<%@page import="bean.TutorAccademico"%>
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
<script type="text/javascript" src="javaScript/firmaValidator.js"></script>
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
			<li class=progettoFormativo>Consulta Registro</li>
		</ul>
	</div>


	<%
		try {

			TutorAccademico tutor_Accademico = (TutorAccademico) session.getAttribute("user");

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

								System.out.println(lista.getListaProgettoFormativo().get(i).getNome_Utente_Tutor_Aziendale());
								System.out.println(tutor_Accademico.getUsername());
								System.out.println(lista.getListaProgettoFormativo().get(i).getId());

								if (lista.getListaProgettoFormativo().size() != 0) {
									if (lista.getListaProgettoFormativo().get(i).isFirma_Azienda()) {
										if (lista.getListaProgettoFormativo().get(i).isFirma_Tutor_Accademico() == false) {
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
						if (tutor_Accademico.getUsername().equalsIgnoreCase(
								lisaPF.getListaProgettoFormativo().get(i).getNome_Utente_Tutor_Accademico())) {
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
	</div>
	<%
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/pageNotFound.jsp");
		}
	%>

</body>
</html>

