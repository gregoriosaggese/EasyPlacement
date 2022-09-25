<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyPlacement</title>
<script type="text/javascript" src="javaScript/librerieJQuery/jquery.js"></script>
<jsp:include page="/includesPage/stylesheets.html"></jsp:include>
</head>
<body>
	<%
		
			if (session.getAttribute("user") == null) {
	%>
	<jsp:include page="includesPage/login.html"></jsp:include>
	<%
		} else {
	%>
	<jsp:include page="includesPage/logout.jsp"></jsp:include>
	<%
		}
	%>
</body>
</html>