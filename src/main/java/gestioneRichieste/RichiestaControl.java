package gestioneRichieste;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ConnessioneDB;

/**
 * @author gregoriosaggese
 *
 */

/**
 * Servlet implementation class RichiestaControl
 * Classe che definisce <i>RichiestaControl</i> 
 */
@WebServlet("/RichiestaControl")
public class RichiestaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * costruttore vuoto
	 * @see HttpServlet#HttpServlet()
	 */
	public RichiestaControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * metodo che permette allo studente di effettuare la richiesta nella azienda
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iscrittoAl,annoCorsoLAurea,laureaIn,matricola,annoAccademico,numeroCFU,datConseguimentoLaurea;
		String possessoLAurea,tipoLaurea,portatoreHAndicap,opzione;
		String nome,cognome,residenza,via,natoA,il,codiceFiscale,telefono,emailStudente,idStudente;
		String nomeUtenteResponsabileAziendale = null,nomeUtenteTutorAccademico = null,nomeUtenteTutorAziendale = null;
		String dataFirma = request.getParameter("datafirma");
		boolean opzioneBoolean, portatoreHAndicapBoolean,tipoLaureaBoolean;
		int idStudenteInt;
		int numeroCFUInt;
		opzione = request.getParameter("optradio0");
		tipoLaurea = request.getParameter("optradio");
		portatoreHAndicap = request.getParameter("optradio1");
		nome = request.getParameter("nome");
		cognome = request.getParameter("cognome");
		residenza = request.getParameter("residenza");
		via = request.getParameter("via");
		natoA = request.getParameter("nato");
		il = request.getParameter("il");
		codiceFiscale = request.getParameter("codicefiscale");
		telefono = request.getParameter("telefono");
		laureaIn = request.getParameter("laureaIn");
		matricola = request.getParameter("matricola");
		datConseguimentoLaurea = request.getParameter("dataconseguimentolaurea");
		numeroCFU = request.getParameter("numeroCFU");
		tipoLaurea = request.getParameter("optradio");
		portatoreHAndicap = request.getParameter("optradio1");
		emailStudente = request.getParameter("email");
		idStudente = request.getParameter("id");
		String dataInizio= request.getParameter("inizio");
		String dataFine = request.getParameter("fine");
		String sede = request.getParameter("sede");
		idStudenteInt = Integer.parseInt(idStudente);
		numeroCFUInt = Integer.parseInt(numeroCFU);
		iscrittoAl = "none";
		annoCorsoLAurea = "none";
		annoAccademico = "none";
		possessoLAurea = "none";
		if(opzione.equalsIgnoreCase("uno")) {
			opzioneBoolean = false;
			iscrittoAl = request.getParameter("iscrittoAl");
			annoCorsoLAurea = request.getParameter("annoCorsoLaurea");
			annoAccademico = request.getParameter("annoaccademico");
		}else {
			opzioneBoolean = true;
			possessoLAurea = request.getParameter("laureaIn");
		}
		if(tipoLaurea.equalsIgnoreCase("triennale")) {
			tipoLaureaBoolean = false;
		}else {
			tipoLaureaBoolean = true;
		}
		if(portatoreHAndicap.equalsIgnoreCase("no")) {
			portatoreHAndicapBoolean = false;
		}else {
			portatoreHAndicapBoolean = true;
		}
		try {
			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();
			Statement st;
			ResultSet rs;
			String selectRA = "SELECT * FROM `RESPONSABILE AZIENDALE` WHERE `Nome_Azienda` = " + "'"+ request.getParameter("azienda") +"'";
			String selectTAZIE = "SELECT * FROM `TUTOR AZIENDALE` WHERE `Nome_Azienda` = " + "'"+ request.getParameter("azienda") +"'";
			String selectTACC = "SELECT * FROM `TUTOR ACCADEMICO`";
			st = c.createStatement();
			rs = st.executeQuery(selectRA);
			while (rs.next()) {
				nomeUtenteResponsabileAziendale = rs.getString("Nome_Utente");
			}
			rs.close();
			st.close();
			st = c.createStatement();
			rs = st.executeQuery(selectTAZIE);
			while (rs.next()) {
				nomeUtenteTutorAziendale = rs.getString("Nome_Utente");
			}
			rs.close();
			st.close();
			st = c.createStatement();
			rs = st.executeQuery(selectTACC);
			while (rs.next()) {
				nomeUtenteTutorAccademico = rs.getString("Nome_Utente");
			}
			rs.close();
			st.close();
			String insertPF = "INSERT INTO  `PROGETTO FORMATIVO` ("
					+ "`Id` ,"
					+ "`Nome` ,"
					+ "`Cognome` ,"
					+ "`Residenza` ,"
					+ "`Via` ,"
					+ "`Nato a` ,"
					+ "`Nato il`,"
					+ "`Codice Fiscale` ,"
					+ "`Telefono` ,"
					+ "`Firma_Azienda` ,"
					+ "`Firma_Tutor_Aziendale` ,"
					+ "`Firma_Presidente_Consiglio_Didattico`,"
					+ "`Firma_Tutor_Accademico`,"
					+ "`Firma_Studente` ,"
					+ "`Email_Studente` ,"
					+ "`Nome_Utente_Responsabile_Aziendale`,"
					+ "`Nome_Utente_Tutor_Aziendale` ,"
					+ "`Nome_Utente_Tutor_Accademico` ,"
					+ "`Opzione` ,"
					+ "`IscrittoAl` ,"
					+ "`AnnoCorsoLaurea` ,"
					+ "`LaureaIn` ,"
					+ "`Matricola`,"
					+ "`AnnoAccademico` ,"
					+ "`NumeroCFU` ,"
					+ "`TipoLaurea` ,"
					+ "`DataConseguimentoLaurea` ,"
					+ "`InpossessodiLaurea` ,"
					+ "`PortatoreHandicap`,"
					+ "`DataFirma`,"
					+ "`DataInizio`,"
					+ "`DataFine`,"
					+ "`Sede`"
					+ " )"
					+ "VALUES ("
					+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
					+ ");";
			PreparedStatement psmt = c.prepareStatement(insertPF);
			psmt.setInt(1, idStudenteInt);
			psmt.setString(2, nome);
			psmt.setString(3, cognome);
			psmt.setString(4, residenza);
			psmt.setString(5, via);
			psmt.setString(6, natoA);
			psmt.setString(7, il);
			psmt.setString(8, codiceFiscale);
			psmt.setString(9, telefono);
			psmt.setBoolean(10, false);//firma azienda
			psmt.setBoolean(11, false);//firma tutor aziendale
			psmt.setBoolean(12, false);// Firma_Presidente_Consiglio_Didattico
			psmt.setBoolean(13, false);// Firma_Tutor_Accademico
			psmt.setBoolean(14, true);//firma studente
			psmt.setString(15, emailStudente);
			psmt.setString(16, nomeUtenteResponsabileAziendale);
			psmt.setString(17, nomeUtenteTutorAziendale);
			psmt.setString(18, nomeUtenteTutorAccademico);
			psmt.setBoolean(19, opzioneBoolean);
			psmt.setString(20, iscrittoAl);
			psmt.setString(21, annoCorsoLAurea);
			psmt.setString(22, laureaIn);
			psmt.setString(23, matricola);
			psmt.setString(24, annoAccademico);
			psmt.setInt(25, numeroCFUInt);
			psmt.setBoolean(26, tipoLaureaBoolean);
			psmt.setString(27, datConseguimentoLaurea);
			psmt.setString(28, possessoLAurea);///
			psmt.setBoolean(29, portatoreHAndicapBoolean);
			psmt.setString(30, dataFirma);
			psmt.setString(31, dataInizio);
			psmt.setString(32, dataFine);
			psmt.setString(33, sede);
			psmt.executeUpdate();
			psmt.close();
			String insertRichiesta = "INSERT INTO  `RICHIESTA` ("
					+ "`id_studente`,"	
					+ "`Stato`,"
					+ "`Nome`,"
					+ "`Cognome`,"
					+ "`Matricola`,"
					+ "`Responsabile Aziendale`"
					+ ")"
					+ "VALUES ("
					+ "?,?,?,?,?,?"
					+ ");";
			psmt = c.prepareStatement(insertRichiesta);
			psmt.setInt(1, idStudenteInt);
			psmt.setBoolean(2, false);
			psmt.setString(3, nome);	
			psmt.setString(4, cognome);
			psmt.setString(5, matricola);
			psmt.setString(6, nomeUtenteResponsabileAziendale);
			psmt.executeUpdate();
			psmt.close();
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (Exception ex) {
			ex.printStackTrace();
			if(ex.getMessage().equals("Duplicate entry '"+idStudenteInt+"' for key 'PRIMARY'")) {
				String messageDetail = "Torna indietro";
				String message = "Richiesta già effettuata";
				HttpSession userSession = request.getSession();
				userSession.setAttribute("message", message);
				userSession.setAttribute("messageDetail", messageDetail);
				response.sendRedirect(request.getContextPath()+"/message.jsp");
			}
		}
	}
}
