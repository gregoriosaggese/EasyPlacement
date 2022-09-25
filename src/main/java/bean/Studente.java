package bean;

import java.sql.*;

import bean.Utente;
import database.ConnessioneDB;
import interfaces.FindStudente;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>PresidenteConsiglioDidattico</i> estende la superclasse utente 
 * e implementa l'interfaccia FindStudente
 * ha un parametro c(Connection ) e un parametro numeroTelefono(String)
 * e un parametro email(String) e un parametro userId(int) =0
 */
public class Studente extends Utente implements FindStudente{

	Connection c;
	public String email;
	public String numeroTelefono;
	public int userId = 0;
	
	/**Non ha costruttore 
	 */
	
	/**Setter di userId
	 * setta l'id userId
	 */
	public void setUserId (String username) throws ClassNotFoundException, SQLException{
		this.userId = findUserId(username);     
	}
	/**Getter di email
	 * restituisce  la stringa email
	 * @return email;
	 */
	public String getUserEmail (){
		return email;
	}
	/**Getter di userId
	 * restituisce  l'int userId
	 * @return userId;
	 */
	public int getUserId (){
		return userId;
	}
	/**Getter di numeroTelefono
	 * restituisce  la stringa numeroTelefono
	 * @return numeroTelefono;
	 */
	public String getNumeroTelefono (){
		return numeroTelefono;
	}
	/**Getter di email
	 * restituisce  la stringa email
	 * @return email;
	 */
	public String getEmail() {
		return email;
	}
	/**Setter di email
	 * setta l'email  email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**Setter il numeroTelefono
	 * setta il numerotelefono numeroTelefono
	 */
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	/**metodo findUserId dell interfaccia FindStudente
	 * prende l'username dal database lo confronta con lo username inserito 
	 * e restituisce l' id dello studente 
	 * @return userId;
	 */
	public int findUserId (String username) throws SQLException, ClassNotFoundException{

		String sqlGetUserId = "SELECT  `studente_id` FROM  `STUDENTE` WHERE  `Username` =  ?";
		c=  new ConnessioneDB().getConnection();
		PreparedStatement psmt  = c.prepareStatement(sqlGetUserId);
		psmt.setString(1, username);
		ResultSet executeQuery = psmt.executeQuery();
		executeQuery.next();
		userId = executeQuery.getInt("studente_id");
		return userId;
	}
}