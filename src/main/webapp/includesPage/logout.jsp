<%@page import="bean.UfficioStageTirocini"%>
<%@page import="bean.TutorAziendale"%>
<%@page import="bean.TutorAccademico"%>
<%@page import="bean.PresidenteConsiglioDidattico"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.ResponsabileAziendale"%>
<%@page import="bean.Studente"%>
<%@page import="bean.Utente"%>
<jsp:include page="/includesPage/stylesheets.html"></jsp:include>

<script type="text/javascript">
	$(document).ready(function() {
		var numClic = 0;
		$('.utenteLoggato').click(function() {
			numClic++;
			if (numClic % 2 == 0) {
				$('#buttonLogout').hide();
			} else {
				$('#buttonLogout').css('display');
				$('#buttonLogout').show();
			}
		});
	});
</script>

<%
	Utente utente = (Utente) session.getAttribute("user");
	if (utente.getUsername().contains("responsabileAziendale")) {

		ResponsabileAziendale responsabileAziendale = (ResponsabileAziendale) session.getAttribute("user");

		String uid = responsabileAziendale.getNomeUtente();
		String inizialeN = responsabileAziendale.getNome().substring(0, 1);
		String finaleN = responsabileAziendale.getNome().substring(1, responsabileAziendale.getNome().length());
		String nome = inizialeN.toUpperCase() + finaleN.toLowerCase();

		String inizialeC = responsabileAziendale.getCognome().substring(0, 1);
		String finaleC = responsabileAziendale.getCognome().substring(1,
				responsabileAziendale.getCognome().length());
		String cognome = inizialeC.toUpperCase() + finaleC.toLowerCase();
%>


<div style="margin-top: 0px;">
	<ul>
		<li id="nomeUtenteLoggato" class="utenteLoggato"><a><%=nome + " " + cognome%></a></li>
	</ul>
</div>

<div>
	<ul>
		<li id="buttonLogout"><a
			style="text-decoration: none; color: black;" href="LogoutControl">Logout</a></li>
	</ul>
</div>

<jsp:include page="/home_responsabileAziendale.jsp"></jsp:include>

<%
	} else if (utente.getUsername().contains("presidenteConsiglioDidattico")) {
		
		
		PresidenteConsiglioDidattico presidenteConsiglioDidattico = (PresidenteConsiglioDidattico) session
				.getAttribute("user");
		
		String userName = presidenteConsiglioDidattico.getUsername();
		String uid = presidenteConsiglioDidattico.getNomeUtente();

		String inizialeN = presidenteConsiglioDidattico.getNome().substring(0, 1);
		String finaleN = presidenteConsiglioDidattico.getNome().substring(1,
				presidenteConsiglioDidattico.getNome().length());
		String nome = inizialeN.toUpperCase() + finaleN.toLowerCase();

		String inizialeC = presidenteConsiglioDidattico.getCognome().substring(0, 1);
		String finaleC = presidenteConsiglioDidattico.getCognome().substring(1,
				presidenteConsiglioDidattico.getCognome().length());
		String cognome = inizialeC.toUpperCase() + finaleC.toLowerCase();
%>

<div style="margin-top: 0px;">
	<ul>
		<li id="nomeUtenteLoggato" class="utenteLoggato"><a><%=nome + " " + cognome%></a></li>
	</ul>
</div>

<div>
	<ul>
		<li id="buttonLogout"><a
			style="text-decoration: none; color: black;" href="LogoutControl">Logout</a></li>
	</ul>
</div>


<%@include file="/home_PresidenteConsiglioDidattico.jsp"%>

<%
	} else if (utente.getUsername().contains("tutorAccademico")) {

		TutorAccademico tutorAccademico = (TutorAccademico) session.getAttribute("user");
		String userName = tutorAccademico.getUsername();
		String uid = tutorAccademico.getNomeUtente();

		String inizialeN = tutorAccademico.getNome().substring(0, 1);
		String finaleN = tutorAccademico.getNome().substring(1, tutorAccademico.getNome().length());
		String nome = inizialeN.toUpperCase() + finaleN.toLowerCase();

		String inizialeC = tutorAccademico.getCognome().substring(0, 1);
		String finaleC = tutorAccademico.getCognome().substring(1, tutorAccademico.getCognome().length());
		String cognome = inizialeC.toUpperCase() + finaleC.toLowerCase();
%>

<div style="margin-top: 0px;">
	<ul>
		<li id="nomeUtenteLoggato" class="utenteLoggato"><a><%=nome + " " + cognome%></a></li>
	</ul>
</div>

<div>
	<ul>
		<li id="buttonLogout"><a
			style="text-decoration: none; color: black;" href="LogoutControl">Logout</a></li>
	</ul>
</div>


<%@include file="/home_TutorAccademico.jsp"%>

<%
	} else if (utente.getUsername().contains("tutorAziendale")) {

		TutorAziendale tutorAziendale = (TutorAziendale) session.getAttribute("user");
		String userName = tutorAziendale.getUsername();
		String uid = tutorAziendale.getNomeUtente();

		String inizialeN = tutorAziendale.getNome().substring(0, 1);
		String finaleN = tutorAziendale.getNome().substring(1, tutorAziendale.getNome().length());
		String nome = inizialeN.toUpperCase() + finaleN.toLowerCase();

		String inizialeC = tutorAziendale.getCognome().substring(0, 1);
		String finaleC = tutorAziendale.getCognome().substring(1, tutorAziendale.getCognome().length());
		String cognome = inizialeC.toUpperCase() + finaleC.toLowerCase();
%>

<div style="margin-top: 0px;">
	<ul>
		<li id="nomeUtenteLoggato" class="utenteLoggato"><a><%=nome + " " + cognome%></a></li>
	</ul>
</div>

<div>
	<ul>
		<li id="buttonLogout"><a
			style="text-decoration: none; color: black;" href="LogoutControl">Logout</a></li>
	</ul>
</div>

<%@include file="/home_TutorAziendale.jsp"%>


<%
	} else if (utente.getUsername().contains("ufficioStageETirocini")) {

		UfficioStageTirocini ufficioStageETirocini = (UfficioStageTirocini) session.getAttribute("user");
		String uid = ufficioStageETirocini.getNomeUtente();
%>

<div style="margin-top: 0px;">
	<ul>
		<li id="nomeUtenteLoggato" class="utenteLoggato"><a><%=uid%></a></li>
	</ul>
</div>

<div>
	<ul>
		<li id="buttonLogout"><a
			style="text-decoration: none; color: black;" href="LogoutControl">Logout</a></li>
	</ul>
</div>


<%@include file="/home_UfficioStage&Tirocini.jsp"%>

<%
	} else {

		Studente studente = (Studente) session.getAttribute("user");
		String userName = studente.getUsername();
		int uid = studente.getUserId();

		String inizialeN = studente.getNome().substring(0, 1);
		String finaleN = studente.getNome().substring(1, studente.getNome().length());
		String nome = inizialeN.toUpperCase() + finaleN.toLowerCase();

		String inizialeC = studente.getCognome().substring(0, 1);
		String finaleC = studente.getCognome().substring(1, studente.getCognome().length());
		String cognome = inizialeC.toUpperCase() + finaleC.toLowerCase();
%>

<div style="margin-top: 0px;">
	<ul>
		<li id="nomeUtenteLoggato" class="utenteLoggato"><a><%=nome + " " + cognome%></a></li>
	</ul>
</div>

<div>
	<ul>
		<li id="buttonLogout"><a
			style="text-decoration: none; color: black;" href="LogoutControl">Logout</a></li>
	</ul>
</div>

<%@include file="/home_studente.jsp"%>

<%
	}
%>

