package gestioneAutenticazione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author gregoriosaggese
 *
 */

/**
 * Servlet implementation class LogoutControl
 * Classe che definisce <i>LogoutControl</i> 
 */

@WebServlet("/LogoutControl")
public class LogoutControl extends HttpServlet {
    	private static final long serialVersionUID = 1L;

    	/**
    	 * costruttore vuoto
    	 * @see HttpServlet#HttpServlet()
    	 */
	public LogoutControl() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * metodo che invalida la sessione del server
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath());
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
