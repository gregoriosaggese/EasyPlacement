
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyPlacement</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap-grid.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="icon" href="logo/logo2.png" type="image/png" />
<script type="text/javascript"
	src="javaScript/librerieJQuery/jquery-1.7.2.min.js"></script>

<script type="text/javascript" src="javaScript/questionarioValidator.js"></script>

<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: white;
	border: 1px solid;
	margin: 8px 0;
	border-radius: 4px;
	cursor: pointer;
	padding: 14px 20px;
}

div {
	border-radius: 5px;
	padding: 20px;
}
</style>
<script type="text/javascript">
	function checked() {
		document.getElementById("checkTirocinanteD").value = "Firmato";
	}
</script>

</head>
<body>

	<%
		try {
			GregorianCalendar g = new GregorianCalendar();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String data = df.format(g.getTime());
	%>


	<div class="container">
		<img
			style="width: 200px; height: 60px; margin-right: 50px; margin-left: 50px;"
			alt="logounisa" src="logo/univsalerno.jpg"> <img
			style="width: 200px; height: 30px; margin-right: 50px; margin-left: 50px;"
			alt="logounisa" src="logo/logo_unisa.png"> <label
			style="margin-right: 50px; margin-left: 50px;">Data
			compilazione: <%=data%></label>
	</div>

	<h2 style="text-align: center;">QUESTIONARIO PER IL TIROCINANTE</h2>
	<h2 style="text-align: center;">CORSO DI LAUREA IN INFORMATICA</h2>


	<div>
		<form action="InviaQuestionario" onsubmit="return(validator())"
			method="post" name="inviaquestionario">
			<input style="display: none;" type="text" name="questionario"
				value="studente"> <label for="fname">Tirocinante:</label> <input
				type="text" id="" name="tirocinante"> <label for="lname">Periodo
				svolgimento del tirocinio:</label> <input type="text" id=""
				name="periodosvolgimento"> <label for="fname">Titolo
				del tirocinio:</label> <input type="text" id="" name="titolodeltirocinio">
			<label for="lname">Ente Ospitante: </label> <input type="text" id=""
				name="ente"> <label for="fname">Sede del tirocinio:</label>
			<input type="text" id="" name="sede"> <label for="lname">Prov.:
			</label> <input type="text" id="" name="provincia"> <label
				for="fname">Tutor Ente Ospitante:</label> <input type="text" id=""
				name="enteospitante"> <label for="fname">Email:</label> <input
				type="text" id="" name="email"> <label for="fname">Tutor
				Accademico:</label> <input type="text" id="" name="tutoraccademico">
			<h2>
				<label for="fname"> Relativamente al progetto di Tirocinio e
					all&lsquo; Esperienza: </label>
			</h2>

			<div>
				<strong><label>Le attività svolte sono state
						coerenti con le conoscenze possedute &emsp;&emsp; </label></strong> 1/per niente<input
					type="radio" name="conoscenze" value="1/per niente">
				&emsp;&emsp; 2<input type="radio" name="conoscenze" value="2">&emsp;&emsp;3
				<input type="radio" name="conoscenze" value="3">&emsp;&emsp;
				4<input type="radio" name="conoscenze" value="4">&emsp;&emsp;
				5/molto<input type="radio" name="conoscenze" value="5/molto">
			</div>

			<div>
				<strong> <label>Il tirocinio ha migliorato la
						formazione tecnica &emsp;&emsp; </label></strong> 1/per niente<input type="radio"
					name="formazione" value="1/per niente"> &emsp;&emsp; 2<input
					type="radio" name="formazione" value="2">&emsp;&emsp;3 <input
					type="radio" name="formazione" value="3">&emsp;&emsp; 4<input
					type="radio" name="formazione" value="4">&emsp;&emsp;
				5/molto<input type="radio" name="formazione" value="5/molto">
			</div>

			<div>
				<strong><label>Il tirocinio ha migliorato le soft
						skill (capacit&agrave; di relazionarsi,di lavorare in team,
						organizzarsi ...) &emsp;&emsp; </label></strong> 1/per niente<input type="radio"
					name="skill" value="1/per niente"> &emsp;&emsp; 2<input
					type="radio" name="skill" value="2">&emsp;&emsp;3 <input
					type="radio" name="skill" value="3">&emsp;&emsp; 4<input
					type="radio" name="skill" value="4">&emsp;&emsp; 5/molto<input
					type="radio" name="skill" value="5/molto">
			</div>

			<div>
				<strong> <label>La durata del tirocinio &egrave;
						stata adeguata agli obiettivi del progetto &emsp;&emsp;</label>
				</strong>1/insufficienti <input type="radio" name="durata"
					value="1/insufficienti"> &emsp;&emsp; 2<input type="radio"
					name="durata" value="2">&emsp;&emsp;3 <input type="radio"
					name="durata" value="3">&emsp;&emsp; 4 <input type="radio"
					name="durata" value="4">&emsp;&emsp; 5/eccessiva<input
					type="radio" name="durata" value="5/eccessiva">
			</div>

			<div>
				<strong><label>Valutazione complessiva
						dell&lsquo;esperienza&emsp;&emsp; </label></strong> 1/inutile<input type="radio"
					name="Valutazione" value="1/inutile"> &emsp;&emsp; 2<input
					type="radio" name="Valutazione" value="2">&emsp;&emsp;3 <input
					type="radio" name="Valutazione" value="3">&emsp;&emsp; 4<input
					type="radio" name="Valutazione" value="4">&emsp;&emsp;
				5/molto utile<input type="radio" name="Valutazione"
					value="5/molto utile">
			</div>
			<h2>
				<label for="fname">Relativamente all&lsquo;ente ospitante: </label>
			</h2>
			<div>
				<strong> <label>Mansioni assegnate&emsp;&emsp; </label></strong>
				1/inadeguate<input type="radio" name="allente" value="1/inadeguate">
				&emsp;&emsp; 2<input type="radio" name="allente" value="2">&emsp;&emsp;3
				<input type="radio" name="allente" value="3">&emsp;&emsp; 4<input
					type="radio" name="allente" value="4">&emsp;&emsp;
				5/adeguate<input type="radio" name="allente" value="5/adeguate">
			</div>

			<div>
				<strong> <label>Ambiente di lavoro&emsp;&emsp; </label></strong>
				1/inospitale<input type="radio" name="Ambiente" value="1/inospitale">
				&emsp;&emsp; 2<input type="radio" name="Ambiente" value="2">&emsp;&emsp;3
				<input type="radio" name="Ambiente" value="3">&emsp;&emsp; 4<input
					type="radio" name="Ambiente" value="4">&emsp;&emsp;
				5/ottimo<input type="radio" name="Ambiente" value="5/ottimo">
			</div>
			<div>
				<strong> <label>Competenze tecniche
						presenti&emsp;&emsp; </label></strong> 1/insufficienti<input type="radio"
					name="Competenze" value="1/insufficienti"> &emsp;&emsp; 2<input
					type="radio" name="Competenze" value="2">&emsp;&emsp;3 <input
					type="radio" name="Competenze" value="3">&emsp;&emsp; 4<input
					type="radio" name="Competenze" value="4">&emsp;&emsp;
				5/ottime<input type="radio" name="Competenze" value="5/ottime">
			</div>

			<div>
				<strong><label>Logistica e supporto
						strumentale&emsp;&emsp; </label></strong> 1/insufficiente<input type="radio"
					name="strumentale" value="1/insufficiente"> &emsp;&emsp; 2<input
					type="radio" name="strumentale" value="2">&emsp;&emsp;3 <input
					type="radio" name="strumentale" value="3">&emsp;&emsp; 4<input
					type="radio" name="strumentale" value="4">&emsp;&emsp;
				5/molto buono<input type="radio" name="strumentale"
					value="5/molto buono">
			</div>

			<div>
				<strong><label>Assistenza del tutor Ente
						Ospitante&emsp;&emsp; </label></strong> 1/insufficiente<input type="radio"
					name="Ospitante" value="1/insufficiente"> &emsp;&emsp; 2<input
					type="radio" name="Ospitante" value="2">&emsp;&emsp;3 <input
					type="radio" name="Ospitante" value="3">&emsp;&emsp; 4<input
					type="radio" name="Ospitante" value="4">&emsp;&emsp;
				5/ottima<input type="radio" name="Ospitante" value="5/ottima">
			</div>
			<h2>
				<label for="fname">Relativamente alle strutture
					universitarie addette alla gestione dei Tirocini:</label>
			</h2>
			<div>
				<strong> <label>Hanno fornito informazioni chiare
						ed esaustive&emsp;&emsp; </label></strong> 1/per niente<input type="radio"
					name="esaustive" value="1/per niente"> &emsp;&emsp; 2<input
					type="radio" name="esaustive" value="2">&emsp;&emsp;3 <input
					type="radio" name="esaustive" value="3">&emsp;&emsp; 4<input
					type="radio" name="esaustive" value="4">&emsp;&emsp;
				5/molto<input type="radio" name="esaustive" value="5/molto">
			</div>

			<div>
				<strong><label>Hanno fornito assistenza e
						disponibilit&agrave; &emsp;&emsp; </label></strong> 1/per niente<input type="radio"
					name="assistenza" value="1/per niente"> &emsp;&emsp; 2<input
					type="radio" name="assistenza" value="2">&emsp;&emsp;3 <input
					type="radio" name="assistenza" value="3">&emsp;&emsp; 4<input
					type="radio" name="assistenza" value="4">&emsp;&emsp;
				5/molto<input type="radio" name="assistenza" value="5/molto">
			</div>

			<div>
				<strong> <label>I servizi/informazioni fornite via
						Web sono esaustive&emsp;&emsp; </label>
				</strong>1/per niente <input type="radio" name="servizi" value="1/per niente">
				&emsp;&emsp; 2 <input type="radio" name="servizi" value="2">&emsp;&emsp;3
				<input type="radio" name="servizi" value="3">&emsp;&emsp; 4
				<input type="radio" name="servizi" value="4">&emsp;&emsp;
				5/molto <input type="radio" name="servizi" value="5/molto">

			</div>

			<h2>
				<label for="fname">Eventuali osservazioni: </label>
			</h2>

			<div>
				<textarea name="informazioni" style="width: 100%; height: 80px;"
					rows="" cols=""> </textarea>
			</div>


			<div style="float: right;" class="row">
				<div style="float: right;" class="row">
					<div style="float: right;" class="col-lg-6">
						<div style="float: right;" class="input-group">
							<label><button id="checkTirocinante" type="button"
									onclick="checked()">Firma del tirocinante</button></label><input
								type="text" id="checkTirocinanteD" class="form-control"
								disabled="disabled" value="Non Firmato" name="firmastudente">
						</div>
					</div>
				</div>
			</div>
			<input type="submit" value="Invia Questionario">
		</form>
	</div>

	<%
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/pageNotFound.jsp");
		}
	%>

</body>
</html>

