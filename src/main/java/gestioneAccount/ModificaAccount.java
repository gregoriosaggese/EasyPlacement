package gestioneAccount;

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

import bean.ListaUtenti;
import database.ConnessioneDB;
import bean.Studente;
/**
 * @author gregoriosaggese
 *
 */

/**
 * Servlet implementation class ModificaAccount
 * Classe che definisce <i>ModificaAccount</i> 
 */

@WebServlet("/ModificaAccount")
public class ModificaAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * costruttore vuoto
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaAccount() {
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
	 * metodo che modifica i dati di uno specifico utente nel database e aggiorna la lista utenti
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String email1 = request.getParameter("emailRegistrazione");
		String numTelefono = request.getParameter("numTelefono");
		String password = request.getParameter("passwordRegistrazione");
		int idS = Integer.parseInt(request.getParameter("id"));
		try {
			ConnessioneDB conn = new ConnessioneDB();
			Connection c = conn.getConnection();
			String updateRichiesta = "UPDATE `STUDENTE` SET `Username`= ?,"
					+ "`Email`= ?,`Password`= ? ,`Numero_Telefonico`= ? WHERE `studente_id`= " +"'" + idS + "';";
			PreparedStatement psmt = c.prepareStatement(updateRichiesta);
			psmt.setString(1, username);
			psmt.setString(2, email1);
			psmt.setString(3, password);
			psmt.setString(4, numTelefono);
			psmt.executeUpdate();
		}catch (Exception e) {
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
			session.setAttribute("listaUtenti", lista);
			st.close();
			rs.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
