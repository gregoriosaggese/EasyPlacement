package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Utente;
import database.ConnessioneDB;
import interfaces.FindUser;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>PresidenteConsiglioDidattico</i> estende la superclasse utente 
 * e implementa l'interfaccia FindUser
 * ha un parametro c(Connection ) e un parametro nomeUtente(String)
 * 
 */

public class TutorAziendale extends Utente implements FindUser{

	private Connection c;
	private String nomeUtente;
	private String numeroTelefonico;
	private String email;
	private String nomeAzienda;
	/**Non ha costruttore 
	 */
	/**Getter di numeroTelefonico
	 * restituisce  la stringa numeroTelefonico
	 * @return numeroTelefonico;
	 */
	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}
	/**Setter di numeroTelefonico
	 * setta il numero telefono numeroTelefonico
	 */
	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	/**Getter di email
	 * restituisce  la stringa email
	 * @return email;
	 */
	public String getEmail() {
		return email;
	}
	/**Setter di email
	 * setta l'email email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**Getter di nomeAzienda
	 * restituisce  la stringa nomeAzienda
	 * @return nomeAzienda;
	 */
	public String getNomeAzienda() {
		return nomeAzienda;
	}
	/**Setter di nomeAzienda
	 * setta il nome azienda nomeAzienda
	 */
	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}
	/**Getter di nomeUtente
	 * restituisce  la stringa nomeUtente
	 * @return nomeUtente;
	 */
	public String getNomeUtente() {
		return nomeUtente;
	}
	/**Setter di nomeUtente
	 * setta il nome utente nomeUtente
	 */
	public void setNomeUtente(String username) throws ClassNotFoundException, SQLException {
		this.nomeUtente = findUser(username);
	}
	/**metodo findUser dell interfaccia finduser
	 * prende l'username dal database e lo restituisce 
	 * @return nomeUtente;
	 */
	@Override
	public String findUser(String username) throws ClassNotFoundException, SQLException {
		String sqlGetUserId = "SELECT  `Nome_Utente` FROM  `TUTOR AZIENDALE`";
		c=  new ConnessioneDB().getConnection();
		PreparedStatement psmt  = c.prepareStatement(sqlGetUserId);
		ResultSet executeQuery = psmt.executeQuery();
		executeQuery.next();
		nomeUtente = executeQuery.getString("Nome_Utente");
		return nomeUtente;
	}
}
