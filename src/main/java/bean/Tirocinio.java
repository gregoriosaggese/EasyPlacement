package bean;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>Azienda</i>
 *  un parametro dataInizio(String),
 *  un parametro dataFine(String),
 *  un parametro sede(String),
 *  un parametro emailStudente(String),
 *  un parametro completato(boolean),
 *  un parametro id(int)
 * 
 */
public class Tirocinio {

	private String dataInizio;
	private String dataFine;
	private String sede;
	private String emailStudente;
	private int id;
	private boolean completato;
	/**Costruttore
	 * vuoto
	 */
	public Tirocinio() {
		
	}
	/**Getter di completato
	 * restituisce boolean completato
	 * @return return completato;
	 */
	public boolean isCompletato() {
		return completato;
	}
	/**Setter di completato
	 * setta boolean completato
	 */
	public void setCompletato(boolean completato) {
		this.completato = completato;
	}
	/**Getter di dataInizio
	 * restituisce la stringa dataInizio
	 * @return return dataInizio;
	 */
	public String getDataInizio() {
		return dataInizio;
	}
	/**Setter di dataInizio
	 * setta la stringa dataInizio
	 */
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	/**Getter di dataFine
	 * restituisce la stringa dataFine
	 * @return return dataFine;
	 */
	public String getDataFine() {
		return dataFine;
	}
	/**Setter di dataFine
	 * setta la stringa dataFine
	 */
	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}
	/**Getter di sede
	 * restituisce la stringa sede
	 * @return return sede;
	 */
	public String getSede() {
		return sede;
	}
	/**Setter di sede
	 * setta la stringa sede
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}
	/**Getter di emailStudente
	 * restituisce la stringa emailStudente
	 * @return return emailStudente;
	 */
	public String getEmailStudente() {
		return emailStudente;
	}
	/**Setter di emailStudente
	 * setta la stringa emailStudente
	 */
	public void setEmailStudente(String emailStudente) {
		this.emailStudente = emailStudente;
	}
	/**Getter di id
	 * restituisce l'int id
	 * @return return id;
	 */
	public int getId() {
		return id;
	}
	/**Setter di id
	 * setta l'int id
	 */
	public void setId(int id) {
		this.id = id;
	}
}