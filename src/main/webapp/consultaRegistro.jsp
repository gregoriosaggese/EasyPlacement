<%@page import="bean.ListaRegistro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyPlacement</title>
<%@include file="includesPage/stylesheets.html"%>
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

		<div id="consultaRegistro"
			style="position: absolute; top: 50px; height: 100%; width: 100%;"
			class="row">


			<div class="panel-heading">
				<h2
					style="color: #ff8221; size: 100px; font-family: sans-serif; margin-bottom: 20px;">Registro</h2>
			</div>


			<%
				try {
					String id = request.getParameter("uid");
					int idS = Integer.parseInt(id);
					ListaRegistro registro = (ListaRegistro) session.getAttribute("listaRegistro");
					for (int i = 0; i < registro.getListaRegistro().size(); i++) {
						if (idS == registro.getListaRegistro().get(i).getId()) {
			%>
			<form style="margin-top: 10px;">
				<a style="position: relative; top: -10px;">Data:&nbsp;&nbsp; <%=registro.getListaRegistro().get(i).getData()%>
				</a><label style="left: 100px;"><input type="checkbox"
					checked="checked" disabled="disabled" id="chkProdTomove" /> <span
					class="check-box-effect"></span> </label>
			</form>
			<%
				}
					}
				} catch (Exception e) {
					e.printStackTrace();
					response.sendRedirect(request.getContextPath() + "/pageNotFound.jsp");
				}
			%>
		</div>
	</div>
</body>
</html>