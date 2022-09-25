package gestioneRegistroTirocini;

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

import bean.ListaProgettiFormativi;
import bean.ListaTirocini;
import bean.ProgettoFormativo;
import bean.Tirocinio;
import database.ConnessioneDB;

/**
 * @author gregoriosaggese
 *
 */

/**
 * Servlet implementation class ConvalidaFinaleTirocinio
 * Classe che definisce <i>ConvalidaFinaleTirocinio</i> 
 */

@WebServlet("/ConvalidaFinaleTirocinio")
public class ConvalidaFinaleTirocinio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * costruttore vuoto
	 * @see HttpServlet#HttpServlet()
	 */
	public ConvalidaFinaleTirocinio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * metodo che convalida la fine del tirocinio nel database, aggiorna la lista progetto formativo e la lista del tirocinio 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int idS = Integer.parseInt(id);
		HttpSession session = request.getSession();
		try {
			ConnessioneDB conn = new ConnessioneDB();
			Connection c = conn.getConnection();
			String updateTirocinio = "UPDATE `TIROCINIO` SET `Completato` = ?"
					+ " WHERE `Id_Progetto_Formativo`= " + "'" + idS + "'";
			PreparedStatement psmt = c.prepareStatement(updateTirocinio);
			psmt.setBoolean(1, true);
			psmt.executeUpdate();
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
			session.setAttribute("listaprogettiFormativi", listaprogettiFormativi);
			st.close();
			rs.close();
			c.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		ListaTirocini listaTirocini = new ListaTirocini();
		try {
			String sqlSelect = "SELECT"
					+ "`Id_Progetto_Formativo` ,`Data_Inizio`,`Data_Fine`,`Sede`,`Email_Studente`,`Completato` FROM  `TIROCINIO`; ";
			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();
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
			session.setAttribute("listaTirocini", listaTirocini);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
