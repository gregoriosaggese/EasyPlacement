package ricercaAzienda;

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
import database.ConnessioneDB;

/**
 * Servlet implementation class RicercaAzienda
 */
@WebServlet("/RicercaAzienda")
public class RicercaAziendaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RicercaAziendaControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession userSession = request.getSession();

		String azienda = request.getParameter("campoRicerca");

		String sqlSearch = "SELECT * FROM `AZIENDA` WHERE `Nome` =" + "'" + azienda+"'";
		
		ListaAziende listaSearch = new ListaAziende();
	
		try {
			ConnessioneDB con = new ConnessioneDB();
			
			Connection c = con.getConnection();

			Statement st = c.createStatement();

			ResultSet rs = st.executeQuery(sqlSearch);

			Azienda aziendaSearch = new Azienda();

			while (rs.next()) {

				String nomeAzienda = rs.getString("Nome");

				String sedeAzienda = rs.getString("Sede");

				String numeroTelefono = rs.getString("Numero_Telefonico");

				String progettoOfferto = rs.getString("Progetto_Offerto");

				aziendaSearch.setNome(nomeAzienda);
				aziendaSearch.setSede(sedeAzienda);
				aziendaSearch.setNumerotelefono(numeroTelefono);
				aziendaSearch.setProgettoofferto(progettoOfferto);
				listaSearch.addAzienda(aziendaSearch);
			}


		}catch (Exception e) {
			e.printStackTrace();
		}


		userSession.setAttribute("ricercaAzienda", listaSearch);
		response.sendRedirect(request.getContextPath()+"/searchResult.jsp");


	}

}
