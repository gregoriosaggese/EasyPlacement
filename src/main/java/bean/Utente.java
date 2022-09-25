package bean;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>Azienda</i>
 *  un parametro username(String),
 *  un parametro password(String),
 *  un parametro cognome(String),
 *  un parametro nome(String)   
 */
public class Utente{

	public String username;
	public String password;
	public String cognome;
	public String nome;
	
	/**Costruttore
	 * vuoto
	 */
	public Utente() {

	}
	/**Setter di cognome
	 * setta la stringa cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**Setter di password
	 * setta la stringa password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**Setter di nome
	 * setta la stringa nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**Getter di username
	 * restituisce la stringa username
	 * @return return username;
	 */
	public String getUsername (){
		return username;
	}
	/**Getter di cognome
	 * restituisce la stringa cognome
	 * @return return cognome;
	 */
	public String getCognome (){
		return cognome;
	}
	/**Getter di nome
	 * restituisce la stringa nome
	 * @return return nome;
	 */
	public String getNome (){
		return nome;
	}
	/**Getter di password
	 * restituisce la stringa password
	 * @return return password;
	 */
	public String getPassword() {
		return password;
	}
	/**Setter di username
	 * setta la stringa username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}