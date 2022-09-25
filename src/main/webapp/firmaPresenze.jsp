<%-- <%@page import="com.sun.xml.internal.ws.api.ha.StickyFeature"%> --%>
<%@page import="bean.ListaRegistro"%>
<%@page import="java.util.List"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.ListaProgettiFormativi"%>
<%@page import="bean.TutorAziendale"%>
<%@page import="bean.ListaTirocini"%>
<%@page import="bean.ListaUtenti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyPLacement</title>
<%@include file="includesPage/stylesheets.html"%>
<script type="text/javascript" src="javaScript/firmaValidator.js"></script>
<style type="text/css">
label {
	display: unset;
	color: #fff;
	cursor: pointer;
	position: relative;
}

label .check-box-effect {
	display: inline-block;
	position: relative;
	background-color: red;
	width: 25px;
	height: 25px;
	border: 2px solid #dcdcdc;
	border-radius: 10%;
}

label .check-box-effect:before {
	content: "";
	width: 0px;
	height: 2px;
	border-radius: 2px;
	background: #626262;
	position: absolute;
	transform: rotate(45deg);
	top: 13px;
	left: 9px;
	transition: width 50ms ease 50ms;
	transform-origin: 0% 0%;
}

label .check-box-effect:after {
	content: "";
	width: 0;
	height: 2px;
	border-radius: 2px;
	background: #626262;
	position: absolute;
	transform: rotate(305deg);
	top: 16px;
	left: 10px;
	transition: width 50ms ease;
	transform-origin: 0% 0%;
}

label:hover .check-box-effect:before {
	width: 5px;
	transition: width 100ms ease;
}

label:hover .check-box-effect:after {
	width: 10px;
	transition: width 150ms ease 100ms;
}

input[type="checkbox"] {
	display: none;
}

input[type="checkbox"]:checked+.check-box-effect {
	background-color: green !important;
	transform: scale(1.25);
}

input[type="checkbox"]:checked+.check-box-effect:after {
	width: 10px;
	background: #333;
	transition: width 150ms ease 100ms;
}

input[type="checkbox"]:checked+.check-box-effect:before {
	width: 5px;
	background: #333;
	transition: width 150ms ease 100ms;
}

input[type="checkbox"]:checked:hover+.check-box-effect {
	background-color: #dcdcdc;
	transform: scale(1.25);
}

input[type="checkbox"]:checked:hover+.check-box-effect:after {
	width: 10px;
	background: #333;
	transition: width 150ms ease 100ms;
}

input[type="checkbox"]:checked:hover+.check-box-effect:before {
	width: 5px;
	background: #333;
	transition: width 150ms ease 100ms;
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

		<div id="compilaModuli"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">

			<div class="panel-heading">
				<h2
					style="color: #ff8221; size: 100px; font-family: sans-serif; margin-bottom: 20px;">Firma
					presenza studente</h2>
			</div>
			<%
				try {
					String id = request.getParameter("id_studente");
					int idS = Integer.parseInt(id);
					ListaRegistro registro = (ListaRegistro) session.getAttribute("listaRegistro");

					if (registro.getListaRegistro().size() > 3) {

						for (int i = registro.getListaRegistro().size() - 3; i < registro.getListaRegistro().size(); i++) {
							if (registro.getListaRegistro().get(i).getId() == idS) {
			%>
			<form style="margin-top: 10px;">
				<a style="position: relative; top: -10px;">Data:&nbsp;&nbsp; <%=registro.getListaRegistro().get(i).getData()%></a><label
					style="left: 100px;"><input type="checkbox"
					checked="checked" disabled="disabled" id="chkProdTomove" /> <span
					class="check-box-effect"></span> </label>
			</form>
			<%
				}
						}
					} else {

						for (int i = 0; i < registro.getListaRegistro().size(); i++) {
							if (registro.getListaRegistro().get(i).getId() == idS) {
			%>
			<form style="margin-top: 10px;">
				<a style="position: relative; top: -10px;">Data:&nbsp;&nbsp; <%=registro.getListaRegistro().get(i).getData()%></a><label
					style="left: 100px;"><input type="checkbox"
					checked="checked" disabled="disabled" id="chkProdTomove" /> <span
					class="check-box-effect"></span> </label>
			</form>
			<%
				}
						}
					}
			%>

			<%
				String stringDataInizio = "", stringDataFine = "";

					ListaProgettiFormativi lista = (ListaProgettiFormativi) session.getAttribute("listaprogettiFormativi");

					for (int i = 0; i < lista.getListaProgettoFormativo().size(); i++) {
						if (lista.getListaProgettoFormativo().get(i).getId() == idS) {
							stringDataInizio = lista.getListaProgettoFormativo().get(i).getDataInizio();
							stringDataFine = lista.getListaProgettoFormativo().get(i).getDataFine();
							System.out.println(stringDataInizio);
							System.out.println(stringDataFine);
						}
					}

					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

					Date dataInizio = df.parse(stringDataInizio);

					Date dataFine = df.parse(stringDataFine);

					List<Date> dates = new ArrayList<Date>();

					Calendar calendar = new GregorianCalendar();

					calendar.setTime(dataInizio);

					while (calendar.getTime().before(dataFine)) {
						Date result = calendar.getTime();
						dates.add(result);
						calendar.add(Calendar.DATE, 1);
					}

					for (int i = 0; i < dates.size(); i++) {

						Calendar g = new GregorianCalendar();
						Calendar f = new GregorianCalendar();
						g.setTime(dates.get(i));
						f.setTime(new Date());
						System.out.println(f.getTime());

						if (g.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
								&& f.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			%>

			<h2>Oggi è Sabato</h2>

			<%
				} else if (g.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
								&& f.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			%>

			<h2>Oggi è Domenica</h2>

			<%
				} else {
							GregorianCalendar g2 = new GregorianCalendar();
							if (g2.getTime().after(dataInizio)) {
								String today = df.format(g2.getTime());
								String dataStr2 = df.format(dates.get(i).getTime());

								if (registro.getListaRegistro().size() != 0) {
									for (int y = registro.getListaRegistro().size() - 1; y < registro.getListaRegistro()
											.size(); y++) {
										if (!registro.getListaRegistro().get(registro.getListaRegistro().size() - 1)
												.getData().equalsIgnoreCase(today)) {

											if (idS == registro.getListaRegistro().get(y).getId()) {
												Date d = df.parse(registro.getListaRegistro().get(y).getData());
												if (d.before(g2.getTime()) && dataStr2.equalsIgnoreCase(today)) {
			%>
			<form action="FirmaPresenza" method="post" name="firmapresenza"
				onsubmit="return(validator())" style="margin-top: 10px;">
				<input
					style="font-size: 15px; display: none; position: relative; top: 0%; left: 0%; -webkit-transform: translate(0%, 0%); -moz-transform: translate(0%, 0%); -ms-transform: translate(0%, 0%); -o-transform: translate(0%, 0%); transform: translate(0%, 0%); width: 150px; padding: 8px; margin-bottom: 0px; margin-top: 0px; border: none; border-radius: 4px; box-sizing: border-box;"
					readonly="readonly" value="<%=id%>" name="id1"><a
					style="position: relative; top: -10px;">Data:&nbsp;&nbsp; <%=dataStr2%></a><input
					style="display: none;" name="data" value="<%=dataStr2%>"> <label
					style="left: 100px;"><input type="checkbox" name="check"
					id="chkProdTomove" /> <span class="check-box-effect"></span> </label> <input
					style="font-size: 15px; background-color: #ff8221; cursor: pointer; position: relative; top: -10px; left: 25%; -webkit-transform: translate(0%, 0%); -moz-transform: translate(0%, 0%); -ms-transform: translate(0%, 0%); -o-transform: translate(0%, 0%); curtransform: translate(0%, 0%); width: 70px; padding: 8px; margin-bottom: 0px; margin-top: 0px; display: inline-block; border: 3px solid; border-radius: 4px; box-sizing: border-box;"
					type="submit" value="Firma">
			</form>
			<%
				i = dates.size();
												} else {
												}
											} else {
			%>
			<form action="FirmaPresenza" method="post" name="firmapresenza"
				onsubmit="return(validator())" style="margin-top: 10px;">
				<input
					style="font-size: 15px; display: none; position: relative; top: 0%; left: 0%; -webkit-transform: translate(0%, 0%); -moz-transform: translate(0%, 0%); -ms-transform: translate(0%, 0%); -o-transform: translate(0%, 0%); transform: translate(0%, 0%); width: 150px; padding: 8px; margin-bottom: 0px; margin-top: 0px; border: none; border-radius: 4px; box-sizing: border-box;"
					readonly="readonly" value="<%=id%>" name="id1"><a
					style="position: relative; top: -10px;">Data:&nbsp;&nbsp; <%=dataStr2%></a><input
					style="display: none;" name="data" value="<%=dataStr2%>"> <label
					style="left: 100px;"><input type="checkbox" name="check"
					id="chkProdTomove" /> <span class="check-box-effect"></span> </label> <input
					style="font-size: 15px; background-color: #ff8221; cursor: pointer; position: relative; top: -10px; left: 25%; -webkit-transform: translate(0%, 0%); -moz-transform: translate(0%, 0%); -ms-transform: translate(0%, 0%); -o-transform: translate(0%, 0%); curtransform: translate(0%, 0%); width: 70px; padding: 8px; margin-bottom: 0px; margin-top: 0px; display: inline-block; border: 3px solid; border-radius: 4px; box-sizing: border-box;"
					type="submit" value="Firma">
			</form>

			<%
				}

										} else {
											i = dates.size();
										}
									}
								} else if (registro.getListaRegistro().size() == 0 && i == 0) {
			%>
			<form action="FirmaPresenza" method="post" name="firmapresenza"
				onsubmit="return(validator())" style="margin-top: 10px;">
				<input
					style="font-size: 15px; display: none; position: relative; top: 0%; left: 0%; -webkit-transform: translate(0%, 0%); -moz-transform: translate(0%, 0%); -ms-transform: translate(0%, 0%); -o-transform: translate(0%, 0%); transform: translate(0%, 0%); width: 150px; padding: 8px; margin-bottom: 0px; margin-top: 0px; border: none; border-radius: 4px; box-sizing: border-box;"
					readonly="readonly" value="<%=id%>" name="id1"><a
					style="position: relative; top: -10px;">Data:&nbsp;&nbsp; <%=dataStr2%></a><input
					style="display: none;" name="data" value="<%=dataStr2%>"> <label
					style="left: 100px;"><input type="checkbox" name="check"
					id="chkProdTomove" /> <span class="check-box-effect"></span> </label> <input
					style="font-size: 15px; background-color: #ff8221; cursor: pointer; position: relative; top: -10px; left: 25%; -webkit-transform: translate(0%, 0%); -moz-transform: translate(0%, 0%); -ms-transform: translate(0%, 0%); -o-transform: translate(0%, 0%); curtransform: translate(0%, 0%); width: 70px; padding: 8px; margin-bottom: 0px; margin-top: 0px; display: inline-block; border: 3px solid; border-radius: 4px; box-sizing: border-box;"
					type="submit" value="Firma">
			</form>
			<%
				}
							}
						}
					}
				} catch (Exception e) {
					response.sendRedirect(request.getContextPath() + "/pageNotFound.jsp");
				}
			%>
		</div>
	</div>
</body>
</html>