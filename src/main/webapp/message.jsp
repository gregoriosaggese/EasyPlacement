<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyPlcement</title>

<%@include file="includesPage/stylesheets.html"%>

<script type="text/javascript" src="javaScript/librerieJQuery/jquery.js"></script>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<style type="text/css">
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
<body style="width: 100%; height: 100%;">

	<div style="width: 100%; height: 100%;" class="alert alert-danger"
		role="alert">
		<div style="margin-top: 0px;">
			<ul>
				<li style="border: 3px solid;" id="nomeUtenteLoggato"><a
					style="text-decoration: none; color: black;" href="index.jsp">Indietro</a></li>
			</ul>
		</div>

		<div id="containerLogo" style="width: 100px">
			<img alt="logo" src="logo/logo2.png" width="200" height="200"
				style="margin-top: 10px">
		</div>
		<%
			String message = (String) session.getAttribute("message");
		%>

		<h1 style="margin-top: 100px;"><%=message%></h1>

		<%
			String messagedetails = (String) session.getAttribute("messageDetail");
		%>

		<h3><%=messagedetails%></h3>

	</div>



</body>
</html>
