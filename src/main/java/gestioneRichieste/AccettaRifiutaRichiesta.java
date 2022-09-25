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

import bean.ListaRichieste;
import bean.Richiesta;
import database.ConnessioneDB;

/**
 * @author gregoriosaggese
 *
 */

/**
 * Servlet implementation class AccettaRifiutaRichiesta
 * Classe che definisce <i>AccettaRifiutaRichiesta</i> 
 */
@WebServlet("/AccettaRifiutaRichiesta")
public class AccettaRifiutaRichiesta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * costruttore vuoto
	 * @see HttpServlet#HttpServlet()
	 */
	public AccettaRifiutaRichiesta() {
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
	 * metodo che permette al responsaabile aziendale di accettare o rifiutare una richiesta di uno specifico studente
	 * se accetta inserisce la richiesta nella lista ricjieste se rifiuta la elimina dal lista progetto formativo
	 * aggiorna la lista richieste
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id, value;
		value = request.getParameter("action").substring(0, 7);
		if(value.equalsIgnoreCase("Rifiuta")) {
			id = request.getParameter("action").substring(9);
		}else {
			id = request.getParameter("action").substring(8);
		}
		int idS = Integer.parseInt(id); 
		HttpSession userSession = request.getSession();
		try {
			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();
			if(value.equalsIgnoreCase("Accetta")) {
				String updateRichiesta = "UPDATE `RICHIESTA` SET `Stato`= ? WHERE `id_studente`= " +"'" + idS + "';";
				PreparedStatement psmt = c.prepareStatement(updateRichiesta);
				psmt.setBoolean(1, true);
				psmt.executeUpdate();
				String updateProgettoFormativo = "UPDATE `PROGETTO FORMATIVO` SET `Firma_Azienda`= ? WHERE `Id`= " +"'" + idS + "';";
				psmt = c.prepareStatement(updateProgettoFormativo);
				psmt.setBoolean(1, true);
				psmt.executeUpdate();
			}else {
				String deleteFromRichiesta = "DELETE FROM `RICHIESTA` WHERE `id_studente`= " +"'" + idS + "';";
				PreparedStatement st = c.prepareStatement(deleteFromRichiesta);
				st.execute();
				String deleteFromProgettoFormativo = "DELETE FROM `PROGETTO FORMATIVO` WHERE `Id`= " +"'" + idS + "';";
				st = c.prepareStatement(deleteFromProgettoFormativo);
				st.execute();
			}
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
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
