package gestioneAutenticazione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;


import bean.Azienda;
import bean.ListaAziende;
import bean.ListaProgettiFormativi;
import bean.ListaRegistro;
import bean.ListaRichieste;
import bean.ListaTirocini;
import bean.ListaUtenti;
import bean.ProgettoFormativo;
import bean.Registro;
import bean.Richiesta;
import database.ConnessioneDB;
import bean.PresidenteConsiglioDidattico;
import bean.ResponsabileAziendale;
import bean.Studente;
import bean.Tirocinio;
import bean.TutorAccademico;
import bean.TutorAziendale;
import bean.UfficioStageTirocini;
/**
 * @author gregoriosaggese
 *
 */

/**
 * Servlet implementation class LoginControl
 * Classe che definisce <i>LoginControl</i> 
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * costruttore vuoto
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginControl() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * metodo che gestisce l'autenticazione delle varie tipologie di utente 
	 * crea la lista degli utenti, aggiorna la lista dei tirocini,il registro delle presenze,la lista delle aziende,
	 * e la lista delle richieste(ListaProgettoFormativo)
	 * gestisce l'errore di sbagliata autenticazione
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username, pass;
		String db_username, db_pass;
		boolean isLoggedIn = false;
		HttpSession userSession = request.getSession();
		username = request.getParameter("usernameLogin");
		pass = request.getParameter("passwordLogin");
		String message, messageDetail;
		message = "Username non Esistente";
		messageDetail = "Effettua la registrazione";
		ListaRegistro listaRegistro = new ListaRegistro();
		try {
			ConnessioneDB conn = new ConnessioneDB();
			Connection c = conn.getConnection();
			String sqlSelect = "SELECT * FROM `REGISTRO`; ";
			PreparedStatement st = c.prepareStatement(sqlSelect);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Registro registro = new Registro();
				registro.setData(rs.getString("Data"));
				registro.setIsFirmed(rs.getBoolean("Firma"));
				registro.setId(rs.getInt("Id_Progetto_Formativo"));
				listaRegistro.addRegistro(registro);
			}
			userSession.setAttribute("listaRegistro", listaRegistro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ListaUtenti lista = new ListaUtenti();
			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();
			String sqlGetUser;
			sqlGetUser = "SELECT  `Username` ,  "
					+ "`Password`,`Nome`,`Cognome`,`Email`,`Numero_Telefonico` FROM  `STUDENTE`; ";
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sqlGetUser);
			String nome,cognome,email,numeroTelefono;
			Studente studente = null;
			while (rs.next()) {
				String username1 = rs.getString("Username");
				String pass1 = rs.getString("Password");
				nome = rs.getString("Nome");
				cognome = rs.getString("Cognome");
				email = rs.getString("Email");
				numeroTelefono = rs.getString("Numero_Telefonico");
				studente = new Studente();
				studente.setUsername(username1);
				studente.setPassword(pass1);
				studente.setNome(nome);
				studente.setCognome(cognome);
				studente.setEmail(email);
				studente.setNumeroTelefono(numeroTelefono);
				studente.setUserId(username1);
				lista.addUtente(studente);
			}
			userSession.setAttribute("listaUtenti", lista);
			st.close();
			rs.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();
			String sqlAzienda = "SELECT * FROM  `AZIENDA`; ";
			Statement st = c.createStatement();
			ResultSet rsAzienda = st.executeQuery(sqlAzienda);
			String nomeAzienda = null,sede = null,numeroTelefono = null,progettoOfferto,inizioTirocinio,fineTirocinio;
			ListaAziende listaAziende = new ListaAziende();
			while (rsAzienda.next()) {
				nomeAzienda = rsAzienda.getString("Nome");
				sede = rsAzienda.getString("Sede");
				inizioTirocinio = rsAzienda.getString("InizioTirocinio");
				fineTirocinio = rsAzienda.getString("FineTirocinio");
				numeroTelefono=	rsAzienda.getString("Numero_Telefonico");
				progettoOfferto=	rsAzienda.getString("Progetto_Offerto");
				Azienda azienda = new Azienda();
				azienda.setNome(nomeAzienda);
				azienda.setSede(sede);
				azienda.setNumerotelefono(numeroTelefono);
				azienda.setProgettoofferto(progettoOfferto);
				azienda.setInizioTirocinio(inizioTirocinio);
				azienda.setFineTirocinio(fineTirocinio);
				listaAziende.addAzienda(azienda);
			}
			userSession.setAttribute("listaAziende", listaAziende);
			st.close();
			rsAzienda.close();
			c.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		String selectRichiesta = "SELECT * FROM `RICHIESTA`";
		ListaRichieste listaRichieste = new ListaRichieste();
		try {
			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(selectRichiesta);
			while(rs.next()) {
				Richiesta richiesta = new Richiesta();
				richiesta.setIdStudente(rs.getInt("id_studente"));
				richiesta.setStato(rs.getBoolean("Stato"));
				richiesta.setNomeStudente(rs.getString("Nome"));
				richiesta.setCognomeStudenteente(rs.getString("Cognome"));
				richiesta.setMatricola(rs.getString("Matricola"));
				richiesta.setNomeUtenteResponsabileAziendale(rs.getString("Responsabile Aziendale"));
				listaRichieste.addRichiesta(richiesta);
			}
			userSession.setAttribute("listaRichieste", listaRichieste);
			st.close();
			rs.close();
			c.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		String selectProgettoFormativo = "SELECT * FROM `PROGETTO FORMATIVO`";
		ListaProgettiFormativi listaprogettiFormativi = new ListaProgettiFormativi();
		try {
			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(selectProgettoFormativo);
			while(rs.next()) {
				ProgettoFormativo progettoFormativo = new ProgettoFormativo();
				progettoFormativo.setId(rs.getInt("Id"));
				progettoFormativo.setNome(rs.getString("Nome"));
				progettoFormativo.setCognome(rs.getString("Cognome"));
				progettoFormativo.setResidenza(rs.getString("Residenza"));
				progettoFormativo.setVia(rs.getString("Via"));
				progettoFormativo.setNatoa(rs.getString("Nato a"));
				progettoFormativo.setNatoil(rs.getString("Nato il"));
				progettoFormativo.setCodiceFiscale(rs.getString("Codice Fiscale"));
				progettoFormativo.setTelefono(rs.getString("Telefono"));
				progettoFormativo.setFirma_Azienda(rs.getBoolean("Firma_Azienda"));
				progettoFormativo.setFirma_Tutor_Aziendale(rs.getBoolean("Firma_Tutor_Aziendale"));
				progettoFormativo.setFirma_Presidente_Consiglio_Didattico(rs.getBoolean("Firma_Presidente_Consiglio_Didattico"));
				progettoFormativo.setFirma_Tutor_Accademico(rs.getBoolean("Firma_Tutor_Accademico"));
				progettoFormativo.setFirma_Studente(rs.getBoolean("Firma_Studente"));
				progettoFormativo.setEmail_Studente(rs.getString("Email_Studente"));
				progettoFormativo.setNome_Utente_Responsabile_Aziendale(rs.getString("Nome_Utente_Responsabile_Aziendale"));
				progettoFormativo.setNome_Utente_Tutor_Aziendale(rs.getString("Nome_Utente_Tutor_Aziendale"));
				progettoFormativo.setNome_Utente_Tutor_Accademico(rs.getString("Nome_Utente_Tutor_Accademico"));
				progettoFormativo.setOpzione(rs.getBoolean("Opzione"));
				progettoFormativo.setIscrittoAl(rs.getString("IscrittoAl"));
				progettoFormativo.setAnnoCorsoLaurea(rs.getString("AnnoCorsoLaurea"));
				progettoFormativo.setLaureaIn(rs.getString("LaureaIn"));
				progettoFormativo.setMatricola(rs.getString("Matricola"));
				progettoFormativo.setAnnoAccademico(rs.getString("AnnoAccademico"));
				progettoFormativo.setNumeroCFU(rs.getInt("NumeroCFU"));
				progettoFormativo.setTipoLaurea(rs.getBoolean("TipoLaurea"));
				progettoFormativo.setDataConseguimentoLaurea(rs.getString("DataConseguimentoLaurea"));
				progettoFormativo.setInpossessodiLaurea(rs.getString("InpossessodiLaurea"));
				progettoFormativo.setPortatoreHandicap(rs.getBoolean("PortatoreHandicap"));
				progettoFormativo.setDataFirma(rs.getString("DataFirma"));
				progettoFormativo.setDataInizio(rs.getString("DataInizio"));
				progettoFormativo.setDataFine(rs.getString("DataFine"));
				progettoFormativo.setSede(rs.getString("Sede"));
				listaprogettiFormativi.addProgettoFormativo(progettoFormativo);
			}
			userSession.setAttribute("listaprogettiFormativi", listaprogettiFormativi);
			st.close();
			rs.close();
			c.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(username.contains("responsabileAziendale")) {
				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				String sqlGetUsers;
				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password`,`Nome`,`Cognome` FROM  `RESPONSABILE AZIENDALE`; ";
				PreparedStatement st = c.prepareStatement(sqlGetUsers);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					String nome,cognome;
					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");
					if (username.equals(db_username)) {
						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							ResponsabileAziendale responsabileAziendale = new ResponsabileAziendale();
							responsabileAziendale.setUsername(username);
							responsabileAziendale.setNomeUtente(username);
							responsabileAziendale.setNome(nome);
							responsabileAziendale.setCognome(cognome);
							userSession.setAttribute("user", responsabileAziendale);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
				if (isLoggedIn == false){
					userSession.setAttribute("message", message);
					userSession.setAttribute("messageDetail", messageDetail);
					response.sendRedirect(request.getContextPath()+"/message.jsp");
				}
			}
			else if (username.contains("tutorAccademico")) {
				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				String sqlGetUsers;
				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password`,`Nome`,`Cognome` FROM  `TUTOR ACCADEMICO`; ";
				PreparedStatement st = c.prepareStatement(sqlGetUsers);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					String nome,cognome;
					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");
					if (username.equals(db_username)) {
						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							TutorAccademico tutorAccademico = new TutorAccademico();
							tutorAccademico.setUsername(username);
							tutorAccademico.setNomeUtente(username);
							tutorAccademico.setNome(nome);
							tutorAccademico.setCognome(cognome);
							userSession.setAttribute("user", tutorAccademico);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
				if (isLoggedIn == false){
					userSession.setAttribute("message", message);
					userSession.setAttribute("messageDetail", messageDetail);
					response.sendRedirect(request.getContextPath()+"/message.jsp");
				}
			}
			else if (username.contains("tutorAziendale")) {

				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				String sqlGetUsers;
				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password`,`Nome`,`Cognome`,`Numero_Telefonico`,`Email`,`Nome_Azienda` FROM  `TUTOR AZIENDALE`; ";
				PreparedStatement st; 
				ResultSet rs; 
				st = c.prepareStatement(sqlGetUsers);
				rs = st.executeQuery();
				while (rs.next()) {
					String nome,cognome,numeroTelefonico,email,nomeAzienda;
					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");
					numeroTelefonico = rs.getString("Numero_Telefonico");
					email = rs.getString("Email");
					nomeAzienda = rs.getString("Nome_Azienda");
					if (username.equals(db_username)) {
						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							TutorAziendale tutorAziendale = new TutorAziendale();
							tutorAziendale.setUsername(username);
							tutorAziendale.setNomeUtente(username);
							tutorAziendale.setNome(nome);
							tutorAziendale.setCognome(cognome);
							tutorAziendale.setNumeroTelefonico(numeroTelefonico);
							tutorAziendale.setEmail(email);
							tutorAziendale.setNomeAzienda(nomeAzienda);
							userSession.setAttribute("user", tutorAziendale);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
				listaRegistro = new ListaRegistro();
				try {
					String sqlSelect = "SELECT * FROM `REGISTRO`; ";
					st = c.prepareStatement(sqlSelect);
					rs = st.executeQuery();
					while (rs.next()) {
						Registro registro = new Registro();
						registro.setData(rs.getString("Data"));
						registro.setIsFirmed(rs.getBoolean("Firma"));
						registro.setId(rs.getInt("Id_Progetto_Formativo"));
						listaRegistro.addRegistro(registro);
					}
					userSession.setAttribute("listaRegistro", listaRegistro);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (isLoggedIn == false){
					userSession.setAttribute("message", message);
					userSession.setAttribute("messageDetail", messageDetail);
					response.sendRedirect(request.getContextPath()+"/message.jsp");
				}
			}
			else if (username.contains("ufficioStageETirocini")) {
				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				String sqlGetUsers;
				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password` FROM  `UFFICIO STAGE E TIROCINI`; ";
				PreparedStatement st = c.prepareStatement(sqlGetUsers);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");
					if (username.equals(db_username)) {
						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							UfficioStageTirocini ufficioStageETirocini = new UfficioStageTirocini();
							ufficioStageETirocini.setUsername(username);
							ufficioStageETirocini.setNomeUtente(username);
							userSession.setAttribute("user", ufficioStageETirocini);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
				if (isLoggedIn == false){
					userSession.setAttribute("message", message);
					userSession.setAttribute("messageDetail", messageDetail);
					response.sendRedirect(request.getContextPath()+"/message.jsp");
				}
			}
			else if (username.contains("presidenteConsiglioDidattico")) {
				ConnessioneDB con;
				Connection c;
				PreparedStatement st;
				ResultSet rs;
				listaRegistro = new ListaRegistro();
				try {
					con = new ConnessioneDB();
					c = con.getConnection();
					String sqlSelect = "SELECT * FROM `REGISTRO`; ";
					st = c.prepareStatement(sqlSelect);
					rs = st.executeQuery();
					while (rs.next()) {
						Registro registro = new Registro();
						registro.setData(rs.getString("Data"));
						registro.setIsFirmed(rs.getBoolean("Firma"));
						registro.setId(rs.getInt("Id_Progetto_Formativo"));
						listaRegistro.addRegistro(registro);
					}
					userSession.setAttribute("listaRegistro", listaRegistro);
				} catch (Exception e) {
					e.printStackTrace();
				}
				con = new ConnessioneDB();
				c = con.getConnection();
				String sqlGetUsers;
				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password`,`Nome`,`Cognome` FROM  `PRESIDENTE CONSIGLIO DIDATTICO`; ";
				st = c.prepareStatement(sqlGetUsers);
				rs = st.executeQuery();
				while (rs.next()) {
					String nome,cognome;
					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");
					if (username.equals(db_username)) {
						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							PresidenteConsiglioDidattico presidenteConsiglioDidattico = new PresidenteConsiglioDidattico();
							presidenteConsiglioDidattico.setUsername(username);
							presidenteConsiglioDidattico.setNomeUtente(username);
							presidenteConsiglioDidattico.setNome(nome);
							presidenteConsiglioDidattico.setCognome(cognome);
							userSession.setAttribute("user", presidenteConsiglioDidattico);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
				if (isLoggedIn == false){
					userSession.setAttribute("message", message);
					userSession.setAttribute("messageDetail", messageDetail);
					response.sendRedirect(request.getContextPath()+"/message.jsp");
				}
			}
			else {
				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				Statement st;
				ResultSet rs;
				int id = 0;
				ListaTirocini l = new ListaTirocini();
				try {
					String sqlSelect = "SELECT "
							+ "`Id_Progetto_Formativo` FROM  `TIROCINIO`; ";
					st = c.createStatement();
					rs = st.executeQuery(sqlSelect);
					while (rs.next()) {
						id = rs.getInt("Id_Progetto_Formativo");
						Tirocinio t = new Tirocinio();
						t.setId(id);
						l.addTirocinio(t);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				try {
					for(int i=l.getListaTirocini().size(); i<listaprogettiFormativi.getListaProgettoFormativo().size(); i++) {
						if( listaprogettiFormativi.getListaProgettoFormativo().get(i).isFirma_Azienda() == true &&
								listaprogettiFormativi.getListaProgettoFormativo().get(i).isFirma_Presidente_Consiglio_Didattico() == true &&
								listaprogettiFormativi.getListaProgettoFormativo().get(i).isFirma_Studente() == true && 
								listaprogettiFormativi.getListaProgettoFormativo().get(i).isFirma_Tutor_Accademico() == true && 
								listaprogettiFormativi.getListaProgettoFormativo().get(i).isFirma_Tutor_Aziendale() == true ) {
							con = new ConnessioneDB();
							c = con.getConnection();
							String sql = "INSERT INTO  `TIROCINIO` "
									+ "(`Email_Studente` ,`Id_Progetto_Formativo`,`Data_Inizio`,`Data_Fine`,`Sede`,`Completato` ) "
									+ "VALUES (?,?,?,?,?,?); ";
							PreparedStatement psmt = c.prepareStatement(sql);
							psmt.setString(1, listaprogettiFormativi.getListaProgettoFormativo().get(i).getEmail_Studente());
							psmt.setInt(2, listaprogettiFormativi.getListaProgettoFormativo().get(i).getId());
							psmt.setString(3,listaprogettiFormativi.getListaProgettoFormativo().get(i).getDataInizio());
							psmt.setString(4, listaprogettiFormativi.getListaProgettoFormativo().get(i).getDataFine());
							psmt.setString(5, listaprogettiFormativi.getListaProgettoFormativo().get(i).getSede());
							psmt.setBoolean(6, false);
							psmt.executeUpdate();
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				con = new ConnessioneDB();
				c = con.getConnection();
				String sqlGetUsers;
				sqlGetUsers = "SELECT  `Username` ,  "
						+ "`Password`,`Nome`,`Cognome`,`Email`,`Numero_Telefonico` FROM  `STUDENTE`; ";
				st = c.createStatement();
				rs = st.executeQuery(sqlGetUsers);
				String nome,cognome,email,numeroTelefono;
				Studente studente = null;
				while (rs.next()) {
					db_username = rs.getString("Username");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");
					email = rs.getString("Email");
					numeroTelefono = rs.getString("Numero_Telefonico");
					if (username.equals(db_username)) {
						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							studente = new Studente();
							studente.setUsername(username);
							studente.setUserId(username);
							studente.setNome(nome);
							studente.setCognome(cognome);
							studente.setEmail(email);
							studente.setNumeroTelefono(numeroTelefono);
							userSession.setAttribute("user", studente);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
				if (isLoggedIn == false){
					userSession.setAttribute("message", message);
					userSession.setAttribute("messageDetail", messageDetail);
					response.sendRedirect(request.getContextPath()+"/message.jsp");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();    
		} catch (Exception e) {
			e.printStackTrace();
		}
		ListaTirocini listaTirocini = new ListaTirocini();
		try {
			ConnessioneDB conn = new ConnessioneDB();
			Connection c = conn.getConnection();
			String sqlSelect = "SELECT"
					+ "`Id_Progetto_Formativo` ,`Data_Inizio`,`Data_Fine`,`Sede`,`Email_Studente` ,`Completato` FROM  `TIROCINIO`; ";
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sqlSelect);
			while (rs.next()) {
				Tirocinio tirocinio = new Tirocinio();
				tirocinio.setId(rs.getInt("Id_Progetto_Formativo"));
				tirocinio.setDataFine(rs.getString("Data_Fine"));
				tirocinio.setEmailStudente(rs.getString("Email_Studente"));
				tirocinio.setSede(rs.getString("Sede"));
				tirocinio.setCompletato(rs.getBoolean("Completato"));
				listaTirocini.addTirocinio(tirocinio);
			}
			userSession.setAttribute("listaTirocini", listaTirocini);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}