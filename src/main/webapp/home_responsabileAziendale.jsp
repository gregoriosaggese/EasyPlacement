<%@page import="bean.ListaProgettiFormativi"%>
<%@page import="bean.ListaRegistro"%>
<%@page import="bean.ResponsabileAziendale"%>
<%@page import="bean.ListaRichieste"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyPlacement</title>


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
			<li class=consultaRegistro>Consulta Registro</li>
		</ul>
	</div>


	<%
		try {

			ListaRichieste listaRichieste = (ListaRichieste) session.getAttribute("listaRichieste");
			ResponsabileAziendale responsabileAziendale = (ResponsabileAziendale) session.getAttribute("user");
			String matricola;
	%>



	<div
		style="position: absolute; top: 150px; left: 250px; width: 76%; height: auto;"
		id="leftside">
		
		<form action="AccettaRifiutaRichiesta" method="post"
			name="accettarifiutarichiesta">
			<div id="formRicerca"
				style="position: absolute; top: 50px; height: 100%; width: 100%;"
				class="row">

				<div class="panel-heading">
					<h2 style="color: #ff8221; size: 100px; font-family: sans-serif;">Tirocinanti
						in attesa di conferma</h2>
				</div>

				<table class="table" style="position: absolute; top: 70px;">
					<%
						for (int i = 0; i < listaRichieste.getListaRichieste().size(); i++) {

								if (listaRichieste.getListaRichieste().get(i).getNomeUtenteResponsabileAziendale()
										.equalsIgnoreCase(responsabileAziendale.getUsername())) {
									if (listaRichieste.getListaRichieste().get(i).getMatricola().equalsIgnoreCase("")) {
										matricola = "Nessuna Matricola";
									} else {
										matricola = listaRichieste.getListaRichieste().get(i).getMatricola();
									}
									if (listaRichieste.getListaRichieste().get(i).isStato() == false) {
					%>
					<tr>
						<th><%=listaRichieste.getListaRichieste().get(i).getNomeStudente()%></th>
						<th><%=listaRichieste.getListaRichieste().get(i).getCognomeStudente()%></th>
						<th><%=matricola%></th>

						<th><input
							style="width: 100%; height: 50px; margin: 0; top: 20px; background-color: #ff8221; border: 1px solid;"
							type="submit" name="action"
							value="Accetta<%=" " + listaRichieste.getListaRichieste().get(i).getIdStudente()%>">
						</th>
						<th><input
							style="width: 100%; height: 50px; margin: 0; top: 20px; background-color: #ff8221; border: 1px solid;"
							type="submit" name="action"
							value="Rifiuta <%=" " + listaRichieste.getListaRichieste().get(i).getIdStudente()%>">
						</th>

					</tr>
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


			<div class="panel-heading">
				<h2
					style="color: #ff8221; size: 100px; font-family: sans-serif; margin-bottom: 20px;">Consulta
					Registro di:</h2>
			</div>

			<%
				ListaProgettiFormativi lisaPF = (ListaProgettiFormativi) session.getAttribute("listaprogettiFormativi");

					for (int i = 0; i < lisaPF.getListaProgettoFormativo().size(); i++) {
						if (lisaPF.getListaProgettoFormativo().get(i).getNome_Utente_Responsabile_Aziendale()
								.equalsIgnoreCase(responsabileAziendale.getUsername())) {
							String a = "" + lisaPF.getListaProgettoFormativo().get(i).getId();
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
				System.out.print(e.getMessage());
				response.sendRedirect(request.getContextPath() + "/pageNotFound.jsp");
			}
		%>





	</div>
</body>
</html>
