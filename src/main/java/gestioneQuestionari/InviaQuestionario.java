package gestioneQuestionari;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.MailUtility;

/**
 * @author gregoriosaggese
 *
 */

/**
 * Servlet implementation class InviaQuestionario
 * Classe che definisce <i>InviaQuestionario</i> 
 * String host; String port; String user; String pass;
 */
@WebServlet("/InviaQuestionario")
public class InviaQuestionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String host;
	private String port;
	private String user;
	private String pass;
	/**
	 * costruttore vuoto
	 * @see HttpServlet#HttpServlet()
	 */
	public InviaQuestionario() {
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
	 * metodo che inizializza le variabili d'istanza per l'invio della mail
	 * le legge dal file web.xml
	 */
	public void init() {
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	/**
	 * metodo che crea un file con i dati del questionario compilato dallo studente e dal tutor aziendale e l'invia via email ad una mail creata appositamente
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("questionario").equalsIgnoreCase("studente")) {
			String tirocinante,periodosvolgimento,titolo,ente,sede,provincia,tutorente,email,tutoraccademico;
			String conoscenze,formazione,skill,durata,Valutazione,allente,Ambiente,Competenze,strumentale,Ospitante,esaustive,assistenza,servizi;
			tirocinante = request.getParameter("tirocinante");
			periodosvolgimento = request.getParameter("periodosvolgimento");
			titolo = request.getParameter("titolodeltirocinio");
			ente = request.getParameter("ente");
			sede = request.getParameter("sede");
			provincia = request.getParameter("provincia");
			tutorente = request.getParameter("enteospitante");
			email = request.getParameter("email");
			tutoraccademico = request.getParameter("tutoraccademico");
			conoscenze = request.getParameter("conoscenze");
			formazione = request.getParameter("formazione");
			skill = request.getParameter("skill");
			durata = request.getParameter("durata");
			Valutazione = request.getParameter("Valutazione");
			allente = request.getParameter("allente");
			Ambiente = request.getParameter("Ambiente");
			Competenze = request.getParameter("Competenze");
			strumentale = request.getParameter("strumentale");
			esaustive = request.getParameter("esaustive");
			Ospitante = request.getParameter("Ospitante");
			assistenza = request.getParameter("assistenza");
			servizi = request.getParameter("servizi");
			String testo ="Tirocinante : "+tirocinante +"\n" 
					+ "Periodo svolgimento tirocinio: " + periodosvolgimento +"\n"
					+ "Titolo del tirocinio: "+ titolo+"\n"
					+ "Ente ospitante: " +ente+"\n"
					+"Sede del tirocinio: " +sede +"\n"
					+"Prov.: "+provincia+"\n"
					+"Tutor Ente Ospitante: " + tutorente+"\n"
					+"Email: " +email+"\n"
					+"Tutor Accademico: "+tutoraccademico+"\n" 
					+"Relativamente al progetto di Tirocinio all’Esperienza: \n"
					+"Le attività svolte sono state coerenti con le conoscenze possedute  "+conoscenze +"\n" 
					+"Il tirocinio ha migliorato la formazione tecnica  " +formazione+"\n"
					+"Il tirocinio ha migliorato le soft skill (capacità di relazionarsi,di lavorare in team, organizzarsi...)  " +skill+"\n"
					+"La durata del tirocinio è stata adeguata agli obiettivi del progetto  " +durata+"\n"
					+"Valutazione complessiva dell esperienza  " +Valutazione+"\n"
					+"Relativamente all'ente ospitante: \n"
					+"Mansioni assegnate  " +allente+"\n"
					+"Ambiente di lavoro  " +Ambiente +"\n"
					+"Competenze tecniche presenti  " +Competenze+"\n"
					+"Logistica e supporto strumentale  "+strumentale+"\n"
					+"Assistenza del tutor Ente Ospitante  "+Ospitante+"\n"
					+"Relativamente alle strutture universitarie addette alla gestione dei Tirocini: \n"
					+"Hanno fornito informazioni chiare ed esaustive  "+esaustive+"\n"
					+"Hanno fornito assistenza e disponibilità  "+assistenza+"\n"
					+"I servizi/informazioni fornite via Web sono esaustive  "+servizi+"\n"
					+"Eventuali informazioni: \n"
					+request.getParameter("informazioni");
			File file = new File("file.txt");
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(testo);
			out.close();
			try {
				MailUtility.sendEmail(host, port, user, pass, file);
			} catch (Exception ex) {
				ex.printStackTrace();
			} 
		}else {
			String titolotirocinio,tutoraccademico,enteospitante,sedetirocinio,provincia,tutorenteospitante,posizionericoperta,email,tirocinante,periodosvolgimento;
			String conoscenze,formazione,skill,durata,allente,Ambiente,Competenze,strumentale,esaustive,assistenza,servizi;
			enteospitante = request.getParameter("enteospitante");
			sedetirocinio = request.getParameter("sedetirocinio");
			provincia = request.getParameter("provincia");
			tutorenteospitante = request.getParameter("tutorenteospitante");
			posizionericoperta = request.getParameter("posizionericoperta");
			email = request.getParameter("email");
			tutoraccademico = request.getParameter("tutoraccademico");
			tirocinante = request.getParameter("tirocinante");
			periodosvolgimento = request.getParameter("periodosvolgimento");
			titolotirocinio = request.getParameter("titolotirocinio");
			conoscenze = request.getParameter("conoscenze");
			formazione = request.getParameter("formazione");
			skill = request.getParameter("skill");
			durata = request.getParameter("durata");
			allente = request.getParameter("allente");
			Ambiente = request.getParameter("Ambiente");
			Competenze = request.getParameter("Competenze");
			strumentale = request.getParameter("strumentale");
			esaustive = request.getParameter("esaustive");
			assistenza = request.getParameter("assistenza");
			servizi = request.getParameter("servizi");
			String testo ="Ente ospitante : "+enteospitante +"\n" 
					+ "Sede tirocinio: " + sedetirocinio +"\n"
					+ "Provincia : "+ provincia+"\n"
					+ "Tutor Ente ospitante: " +tutorenteospitante+"\n"
					+"Posizione Ricoperta: " +posizionericoperta +"\n"
					+"Email: "+email+"\n"
					+"Tutor Accademico: " + tutoraccademico+"\n"
					+"Tirocinante: " +tirocinante+"\n"
					+"Periodo Svolgimento del Tirocinio: "+periodosvolgimento+"\n" 
					+"Titolo del Tirocinio: "+titolotirocinio+"\n" 
					+"Relativamente al progetto di Tirocinio: \n"
					+"La durata del tirocinio è stata adeguata agli obiettivi formativi  "+conoscenze +"\n" 
					+"Gli obiettivi formativi previsti sono stati raggiunti  " +formazione+"\n"
					+"La collaborazione con il Tutor Didattico è stata  " +skill+"\n"
					+"l tirocinio formativo è utile all'Ente Ospitante  " +durata+"\n"
					+"Relativamente al Tirocinante: \n"
					+"Competenze informatiche possedute in ingresso  " +allente+"\n"
					+"Competenze acquisite al termine del tirocinio nella specifica disciplina  " +Ambiente +"\n"
					+"Motivazione e interesse  " +Competenze+"\n"
					+"Soft skill (capacit&agrave; di relazionarsi,di lavorare in team, organizzarsi ...)  "+strumentale+"\n"
					+"Relativamente alle strutture universitarie addette alla gestione dei Tirocini: \n"
					+"Hanno fornito informazioni chiare ed esaustive  "+esaustive+"\n"
					+"Hanno fornito assistenza e disponibilità  "+assistenza+"\n"
					+"I servizi/informazioni fornite via Web sono esaustive  "+servizi+"\n"
					+"Eventuali informazioni: \n"
					+request.getParameter("informazioni");
			File file = new File("file.txt");
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(testo);
			out.close();
			try {
				MailUtility.sendEmail(host, port, user, pass, file);
			} catch (Exception ex) {
				ex.printStackTrace();
			} 
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
