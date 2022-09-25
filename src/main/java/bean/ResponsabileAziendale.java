package bean;

import java.sql.*;

import bean.Utente;
import database.ConnessioneDB;
import interfaces.FindUser;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>ResponsabileAziendale</i> estende la superclasse utente 
 * e implementa l'interfaccia FindUser
 * ha un parametro c(Connection ) e un parametro nomeUtente(String) 
 * e un parametro nomeAzienda(String)
 * 
 */
public class ResponsabileAziendale extends Utente implements FindUser{

	private	Connection c;
	private String nomeUtente;
	private String nomeAzienda;
	/**Non ha costruttore 
	 */
	
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
	public void setNomeUtente(String nomeUtente) throws ClassNotFoundException, SQLException {
		this.nomeUtente = findUser(nomeUtente);
	}
	/**metodo findUser dell interfaccia finduser
	 * prende l'username dal database e lo restituisce 
	 * @return nomeUtente;
	 */
	@Override
	public String findUser(String username) throws ClassNotFoundException, SQLException {
		String sqlGetUserId = "SELECT  `Nome_Utente` FROM  `RESPONSABILE AZIENDALE`";
		c=  new ConnessioneDB().getConnection();
		PreparedStatement psmt  = c.prepareStatement(sqlGetUserId);
		ResultSet executeQuery = psmt.executeQuery();
		executeQuery.next();
		nomeUtente = executeQuery.getString("Nome_Utente");
		return nomeUtente;
	}
}