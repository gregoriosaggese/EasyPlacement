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
public class PresidenteConsiglioDidattico extends Utente implements FindUser{

	private Connection c;
	private String nomeUtente;
	/**Non ha costruttore 
	 */
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
		String sqlGetUserId = "SELECT  `Nome_Utente` FROM  `PRESIDENTE CONSIGLIO DIDATTICO`";
		c=  new ConnessioneDB().getConnection();
		PreparedStatement psmt  = c.prepareStatement(sqlGetUserId);
		ResultSet executeQuery = psmt.executeQuery();
		executeQuery.next();
		nomeUtente = executeQuery.getString("Nome_Utente");
		return nomeUtente;
	}
}
