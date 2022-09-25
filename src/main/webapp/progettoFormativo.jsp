<%@page import="bean.Studente"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="database.ConnessioneDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.ListaAziende"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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

<script type="text/javascript" src="javaScript/bootstrap.min.js"></script>
<script type="text/javascript"
	src="javaScript/progettoFormativoControl.js"></script>


<style type="text/css">
.row {
	margin-left: 30px;
	width: 90%;
	margin-bottom: 20px;
}

label {
	padding: 5px;
}
</style>

<script type="text/javascript">
	function checked() {
		document.getElementById("checkTirocinanteD").value = "Firmato";
	}

	$(document).ready(function() {
		var numClic = 1;
		$('.opzione1').click(function() {
			numClic++;
			if (numClic % 2 == 0) {
				$('#opzione2').hide();
			} else {
				$('input:radio[name=optradio0]').attr('checked', false);
				$('#opzione2').css('display');
				$('#opzione2').show();
			}
		});
	});
	$(document).ready(function() {
		var numClic = 1;
		$('.opzione2').click(function() {
			numClic++;
			if (numClic % 2 == 0) {
				$('#opzione1').hide();
			} else {
				$('input:radio[name=optradio0]').attr('checked', false);
				$('#opzione1').css('display');
				$('#opzione1').show();
			}
		});
	});
</script>


</head>
<body>

	<%
		try {
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			String dataStr2 = sdf2.format(new Date().getTime());

			ListaAziende listaAziende = (ListaAziende) session.getAttribute("listaAziende");
			Studente studente = (Studente) session.getAttribute("user");

			String inizio = "", fine = "";
			String sede = "";

			for (int i = 0; i < listaAziende.getListaAziende().size(); i++) {
				if (request.getParameter("nomeAzienda")
						.equalsIgnoreCase(listaAziende.getListaAziende().get(i).getNome())) {

					inizio = listaAziende.getListaAziende().get(i).getInizioTirocinio();
					fine = listaAziende.getListaAziende().get(i).getFineTirocinio();
					sede = listaAziende.getListaAziende().get(i).getSede();
				}
			}

			String nomeTA = "", cognomeTA = "", telefonoTA = "", emailTA = "";
			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();
			String sqlTutorAZIENDALE = "SELECT * FROM  `TUTOR AZIENDALE` WHERE `Nome_azienda` = " + "'"
					+ request.getParameter("nomeAzienda") + "'";

			Statement st = c.createStatement();
			ResultSet rsAzienda = st.executeQuery(sqlTutorAZIENDALE);
			while (rsAzienda.next()) {
				nomeTA = rsAzienda.getString("Nome");
				cognomeTA = rsAzienda.getString("Cognome");
				telefonoTA = rsAzienda.getString("Numero_Telefonico");
				emailTA = rsAzienda.getString("Email");
			}
			rsAzienda.close();
			st.close();

			String nomeTAC = "", cognomeTAC = "";
			String sqlTutorAccademico = "SELECT * FROM  `TUTOR ACCADEMICO`";

			st = c.createStatement();
			rsAzienda = st.executeQuery(sqlTutorAccademico);
			while (rsAzienda.next()) {
				nomeTAC = rsAzienda.getString("Nome");
				cognomeTAC = rsAzienda.getString("Cognome");
			}
			rsAzienda.close();
			st.close();
			c.close();
	%>



	<div class="container">
		<img style="width: 400px; height: 60px;" alt="logounisa"
			src="logo/logo_unisa.png">
	</div>

	<h1 style="text-align: center;">PROGETTO FORMATIVO E DI
		ORIENTAMENTO</h1>
	<h3 style="text-align: center; margin-bottom: 30px;">ai sensi del
		D.M. 25 marzo 1998 n.142</h3>


	<div class="row">
		<form action="RichiestaControl" method="get"
			onsubmit="return(control())" name="progettoformativo">
			<input style="display: none;" type="text" name="email"
				value="<%=studente.getEmail()%>"> <input
				style="display: none;" type="text" name="id"
				value="<%=studente.getUserId()%>">


			<div class="row">
				<div class="col">
					<input readonly="readonly" type="text" class="form-control"
						name="nome" value="<%=studente.getNome()%>">
				</div>
				<div class="col">
					<input readonly="readonly" type="text" class="form-control"
						name="cognome" value="<%=studente.getCognome()%>">
				</div>


				<div class="col">
					<input type="text" class="form-control" name="residenza"
						placeholder="Residente in">
				</div>
				<div class="col">
					<input type="text" class="form-control" name="via"
						placeholder="Via">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<input type="text" class="form-control" name="nato"
						placeholder="Nato a">
				</div>
				<div class="col">
					<input type="text" class="form-control" name="il" placeholder="il">
				</div>


				<div class="col">
					<input type="text" class="form-control" name="codicefiscale"
						placeholder="Codice fiscale">
				</div>
				<div class="col">
					<input readonly="readonly" type="text" class="form-control"
						name="telefono" value="<%=studente.getNumeroTelefono()%>">
				</div>
			</div>


			<h4 style="margin-top: 30px;">Attuale condizione (barrare la
				casella)</h4>

			<div style="margin-top: 30px;" class="radio">

				<div id="opzione1" class="radio">

					<input class="opzione1" type="radio" name="optradio0" value="uno">
					<label class="form-check-label" for="defaultCheck1">Studente
						universitario iscritto al &nbsp;</label><select class="custom-select"
						name="iscrittoAl">

						<option value="Primo Triennale">Primo Triennale</option>
						<option value="Secondo Triennale">Secondo Triennale</option>
						<option value="Terzo Triennale">Terzo Triennale</option>
						<option value="Primo Triennale Fuoricorso">Primo
							Triennale Fuoricorso</option>
						<option value="Secondo Triennale Fuoricorso">Secondo
							Triennale Fuoricorso</option>
						<option value="Terzo Triennale Fuoricorso">Terzo
							Triennale Fuoricorso</option>
						<option value="Primo Magistrale">Primo Magistrale</option>
						<option value="Secondo Magistrale">Secondo Magistrale</option>

					</select> <label class="form-check-label" for="defaultCheck1">&nbsp;
						anno del Corso di Laurea &nbsp;</label> <select class="custom-select"
						name="annoCorsoLaurea">

						<option value="2017/2018">2017/2018</option>
						<option value="2016/2017">2016/2017</option>
						<option value="2015/2016">2015/2016</option>
						<option value="2014/2015">2014/2015</option>
						<option value="2013/2014">2013/2014</option>
						<option value="2012/2013">2012/2013</option>
						<option value="2011/2012">2011/2012</option>
						<option value="2010/2011">2010/2011</option>
						<option value="2009/2010">2009/2010</option>

					</select> <label class="form-check-label" for="defaultCheck1">&nbsp;in
						&nbsp;</label><select class="custom-select" name="possessoLaurea">

						<option value="Informatica">Informatica</option>

					</select><label class="form-check-label" for="defaultCheck1">&nbsp;&nbsp;matricola&nbsp;</label><input
						type="text" name="matricola"><label
						class="form-check-label" for="defaultCheck1">&nbsp; presso
						l'Università degli studi di Salerno per l'anno accademico&nbsp;</label><select
						class="custom-select" name="annoaccademico">

						<option value="2017/2018">2017/2018</option>
						<option value="2016/2017">2016/2017</option>
						<option value="2015/2016">2015/2016</option>
						<option value="2014/2015">2014/2015</option>
						<option value="2013/2014">2013/2014</option>
						<option value="2012/2013">2012/2013</option>
						<option value="2011/2012">2011/2012</option>
						<option value="2010/2011">2010/2011</option>
						<option value="2009/2010">2009/2010</option>

					</select><label class="form-check-label" for="defaultCheck1">&nbsp;con
						tirocinio curricolare pari a &nbsp;</label><input type="text"
						name="numeroCFU" value="0"><label class="form-check-label"
						for="defaultCheck1"> &nbsp;CFU.</label>
				</div>
			</div>

			<div style="margin-top: 30px;" class="radio">
				<div id="opzione2" class="radio">
					<input class="opzione2" type="radio" name="optradio0" value="due">
					<label>In possesso di laurea &nbsp;</label><select
						class="custom-select" name="laureaIn">

						<option value="1">Triennale</option>
						<option value="2">Magistrale</option>

					</select> <label class="form-check-label" for="defaultCheck1">&nbsp;in&nbsp;</label>
					<select class="custom-select" name="possessoLaurea">

						<option value="Informatica">Informatica</option>

					</select> <label class="form-check-label" for="defaultCheck1">&nbsp;conseguita
						presso l'Università degli studi di Salerno in data&nbsp;</label> <input
						type="text" name="dataconseguimentolaurea">
				</div>
			</div>



			<label style="margin-top: 30px;" class="form-check-label"
				for="defaultCheck1">&nbsp;Indicare il tipo di laurea: </label>

			<div class="radio" style="margin-left: 160px;">
				<label><input type="radio" name="optradio" value="triennale">Laurea
					Triennale</label>
			</div>
			<div class="radio" style="margin-left: 160px;">
				<label><input type="radio" name="optradio"
					value="magistrale">Laurea Magistrale</label>
			</div>

			<label style="margin-top: 30px;" for="defaultCheck1">&nbsp;Portatore
				di handicap:</label>

			<div class="radio" style="margin-left: 160px;">
				<label><input type="radio" name="optradio1" value="si">SI
				</label>
			</div>
			<div class="radio" style="margin-left: 160px;">
				<label><input type="radio" name="optradio1" value="no">NO
				</label>
			</div>

			<div class="row">

				<div class="col">
					<h3 style="border: 2px solid;">
						<label style="margin-top: 30px;" class="form-check-label"
							for="defaultCheck1"> Azienda Ospitante : <%=request.getParameter("nomeAzienda")%></label>
						<input style="display: none;" name="azienda" type="text"
							value="<%=request.getParameter("nomeAzienda")%>">
					</h3>
				</div>

				<div class="col">
					<h3 style="border: 2px solid;">
						<label style="margin-top: 30px;" class="form-check-label"
							for="defaultCheck1">Sede azienda : <%=sede%> <input
							type="text" value="<%=sede%>" name="sede" style="display: none;">
						</label>
					</h3>
				</div>

				<!-- <h3 style="border: 2px solid;">
					<label style="margin-top: 30px;" class="form-check-label"
						for="defaultCheck1">Tempi di accesso ai locali aziendali :
						" INSERIRE TEMPI DI ACCESSO TRAMITE REQUEST! "</label>
				</h3> -->
			</div>

			<div style="border: 2px solid;" class="row">
				<h3>
					<label style="margin-top: -5px;" class="form-check-label"
						for="defaultCheck1">Periodo di tirocinio:</label>
				</h3>

				<label style="margin-top: 19px; margin-left: 25px;"
					class="form-check-label" for="defaultCheck1">&nbsp;N° Mesi</label><label
					style="margin-top: 19px;" class="form-check-label"
					for="defaultCheck1">&nbsp;6</label> <label
					style="margin-top: 19px;" class="form-check-label"
					for="defaultCheck1">&nbsp;Dal</label><label
					style="margin-top: 19px;" class="form-check-label"
					for="defaultCheck1">&nbsp;<%=inizio%> <input type="text"
					value="<%=inizio%>" name="inizio" style="display: none;">
				</label> <label style="margin-top: 19px;" class="form-check-label"
					for="defaultCheck1">&nbsp;al</label><label
					style="margin-top: 19px;" class="form-check-label"
					for="defaultCheck1">&nbsp;<%=fine%> <input type="text"
					value="<%=fine%>" name="fine" style="display: none;"></label><label
					style="margin-top: 19px;" class="form-check-label"
					for="defaultCheck1">&nbsp;per totale ore </label><label
					style="margin-top: 19px;" class="form-check-label"
					for="defaultCheck1">&nbsp;150</label>

			</div>


			<div style="border: 2px solid;" class="row">
				<h3>
					<label style="margin-top: 30px;" class="form-check-label"
						for="defaultCheck1">Tutor Accademico : <%=nomeTAC + " " + cognomeTAC%>
					</label>
				</h3>
			</div>

			<div style="border: 2px solid;" class="row">
				<h3>
					<label style="margin-top: 0px;" class="form-check-label"
						for="defaultCheck1">Tutor Aziendale :&nbsp;&nbsp; <%=nomeTA + " " + cognomeTA%>
					</label>
				</h3>

				<label style="margin-top: 70px; margin-left: -350px;"
					class="form-check-label" for="defaultCheck1">&nbsp;Telefono:</label><label
					style="margin-top: 70px;" class="form-check-label"
					for="defaultCheck1">&nbsp;<%=telefonoTA%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <label style="margin-top: 70px;" class="form-check-label"
					for="defaultCheck1">&nbsp;Email:</label><label
					style="margin-top: 70px;" class="form-check-label"
					for="defaultCheck1">&nbsp;<%=emailTA%>
				</label>
			</div>

			<div style="border: 2px solid;" class="row">
				<h3>
					<label style="margin-top: 0;" class="form-check-label"
						for="defaultCheck1">Polizze assicurative: </label>
				</h3>
				<h5>
					<label style="margin-left: 25px;" class="form-check-label"
						for="defaultCheck1">&nbsp;INAL Gestione per conto dello
						Stato prevista dal combinato disposto dagli artt. 127 e 190 del
						T.U. INAIL (DPR N. 1124/65) e regolamentato dal D.M. 10.10.85;
						Infortuni posizione 261044627 Compagnia Generali Responsabilità
						Civile Terzi Compagnia Generali 261044624</label>
				</h5>
			</div>

			<div style="border: 2px solid; height: 200px;" class="row">
				<h3>
					<label style="margin-top: 30px;" class="form-check-label"
						for="defaultCheck1">Obiettivi e modalià tirocinio: </label>
				</h3>

				<div style="width: 100%; height: 100%;">
					<textarea rows="" cols=""
						style="width: 100%; height: 95px; border: none;"></textarea>
				</div>
			</div>

			<div style="border: 2px solid" class="row">
				<h3>
					<label style="margin-top: 30px;" class="form-check-label"
						for="defaultCheck1">Eventuali facilitazioni previste: </label>
				</h3>

				<div style="width: 100%; height: 100%;">
					<textarea rows="" cols=""
						style="width: 100%; height: 50px; border: none;"></textarea>
				</div>
			</div>

			<div class="row">
				<h4>
					Obblighi per il tirocinante:<br> <br> &bull; Seguire le
					indicazioni dei tutori e fare riferimento ad essi su qualsiasi
					Esigenza di tipo organizzativo ed altre evenienze;<br> <br>
					&bull; Rispettare gli obblighi di riservatezza per quanto attiene
					ai dati, alle Informazioni e conoscenze in merito all’attività di
					ricerca dell’ Ente/Azienda, acquisiti durante e dopo lo svolgimento
					del tirocinio; <br> <br> &bull; Rispettare i regolamenti
					aziendali e le norme in materia di igiene e sicurezza.
				</h4>
			</div>

			<div class="row">
				<label style="margin-top: 30px;" class="form-check-label"
					for="defaultCheck1">Fisciano, <%=dataStr2%></label> <input
					style="display: none;" type="text" name="datafirma"
					value="<%=dataStr2%>">
			</div>

			<div class="row">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group">
							<label><button disabled="disabled" id="checkAzienda">Firma
									Azienda</button></label><input type="text" class="form-control"
								disabled="disabled" value="Non Firmato" name="firmaazienda">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group">
							<label>
								<button id="checkTutorAziendale" disabled="disabled">Firma
									Tutor Aziendale</button>
							</label><input type="text" class="form-control" disabled="disabled"
								value="Non Firmato" name="firmatutoraziendale">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group">
							<label><button id="checkTutorAccademico"
									disabled="disabled">Firma Tutor Accademico</button></label><input
								type="text" class="form-control" disabled="disabled"
								value="Non Firmato" name="firmatutoraccademico">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group">
							<label><button id="checkPCD" disabled="disabled">Firma
									Presidente Consiglio Didattico</button></label><input type="text"
								class="form-control" disabled="disabled" value="Non Firmato"
								name="firmapresidenteconsigliodidattico">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group">
							<label><button id="checkTirocinante" type="button"
									onclick="checked()">Firma per visione e accettazione
									del tirocinante</button></label><input type="text" id="checkTirocinanteD"
								class="form-control" disabled="disabled" value="Non Firmato"
								name="firmastudente">
						</div>
					</div>
				</div>
			</div>
			<input type="submit" class="form-control" value="Invia Richiesta">
			<br> <br> <br>
		</form>
	</div>


	<div class="row">
		<div class="col-sm-6">
			<div class="card">
				<div class="card-body">
					<p class="card-text">Ufficio Didattica, Organi Collegiali, Alta
						Formazione, Carriere.</p>
					<p class="card-text">Responsabile del procedimento: Carmela De
						Rosa.
					<p class="card-text">Responsabile dell’istruttoria: Carmela De
						Rosa.</p>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="card">
				<div class="card-body">
					<p class="card-text">Ufficio Didattica, Organi Collegiali, Alta
						Formazione, Carriere.</p>
					<p class="card-text">Contatti : Dott.ssa Matilde Cannavale.</p>
					<p class="card-text">tel: 089969277 e-mail :
						mcannavale@unisa.it.</p>
				</div>
			</div>
		</div>
	</div>
	<%
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/pageNotFound.jsp");
		}
	%>

</body>
</html>

