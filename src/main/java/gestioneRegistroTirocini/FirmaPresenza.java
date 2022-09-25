package gestioneRegistroTirocini;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ListaRegistro;
import bean.Registro;
import database.ConnessioneDB;

/**
 * @author gregoriosaggese
 *
 */

/**
 * Servlet implementation class FirmaPresenza
 * Classe che definisce <i>FirmaPresenza</i> 
 */

@WebServlet("/FirmaPresenza")
public class FirmaPresenza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * costruttore vuoto
	 * @see HttpServlet#HttpServlet()
	 */
	public FirmaPresenza() {
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
	 * metodo che inserisce le firme nel database e aggiorna la lista del registro
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ConnessioneDB con;
		Connection c;
		PreparedStatement st;
		HttpSession session = request.getSession();
		String id = request.getParameter("id1");
		int idS = Integer.parseInt(id);
		String data = request.getParameter("data");
		int i=1;
		try {
			con = new ConnessioneDB();
			c = con.getConnection();
			String sql = "INSERT INTO `REGISTRO` "
					+ "(`Data` ,`Firma` ,`Id_Progetto_Formativo`) "
					+ "VALUES ( ?,?,? ); ";
			PreparedStatement psmt = c.prepareStatement(sql);
			psmt.setString(1, data);
			psmt.setBoolean(2, true);
			psmt.setInt(3, idS);
			psmt.executeUpdate();
		}catch (Exception e) {
			String messageDetail;
			if(e.getMessage().equals("Duplicate entry '"+data+"' for key 'PRIMARY'")) {
				System.out.println("sonoqui");
				String message = "Firma non valida";
				messageDetail = "Hai gia firmato questo giorno";
				session.setAttribute("message", message);
				session.setAttribute("messageDetail", messageDetail);
				i=0;
				response.sendRedirect(request.getContextPath()+"/message.jsp");
			}
		}
		if(i==1) {
			ListaRegistro listaRegistro = new ListaRegistro();
			try {
				System.out.println("nel try");
				String sqlSelect = "SELECT * FROM `REGISTRO`; ";
				con = new ConnessioneDB();
				c = con.getConnection();
				st = c.prepareStatement(sqlSelect);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Registro registro = new Registro();
					registro.setData(rs.getString("Data"));
					registro.setIsFirmed(rs.getBoolean("Firma"));
					registro.setId(rs.getInt("Id_Progetto_Formativo"));
					listaRegistro.addRegistro(registro);
				}
				session.setAttribute("listaRegistro", listaRegistro);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
