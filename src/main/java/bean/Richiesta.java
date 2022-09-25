package bean;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>Azienda</i>
 *  un parametro nomeUtenteResponsabileAziendale(String),
 *  un parametro nomeStudente(String),
 *  un parametro cognomeStudenteente(String),
 *  un parametro matricola(String),
 *  un parametro stato(boolean),
 *  un parametro idStudente(int)
 * 
 */
public class Richiesta {

	private int idStudente;
	private boolean stato;
	private String nomeStudente;
	private String cognomeStudenteente;
	private String matricola;
	private String nomeUtenteResponsabileAziendale;
	/**Costruttore
	 * vuoto
	 */
	public Richiesta() {
		super();
	}
	/**Getter di idStudente
	 * restituisce la stringa idStudente
	 * @return return idStudente;
	 */
	public int getIdStudente() {
		return idStudente;
	}
	/**Setter di idStudente
	 * setta l'int idStudente
	 */
	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}
	/**Getter di stato
	 * restituisce boolean stato
	 * @return return stato;
	 */
	public boolean isStato() {
		return stato;
	}
	/**Setter di isFirmed
	 * setta boolean isFirmed
	 */
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	/**Getter di nomeStudente
	 * restituisce la stringa nomeStudente
	 * @return return nomeStudente;
	 */
	public String getNomeStudente() {
		return nomeStudente;
	}
	/**Setter di nomeStudente
	 * setta la stringa nomeStudente
	 */
	public void setNomeStudente(String nomeStudente) {
		this.nomeStudente = nomeStudente;
	}
	/**Getter di cognomeStudenteente
	 * restituisce la stringa cognomeStudenteente
	 * @return return cognomeStudenteente;
	 */
	public String getCognomeStudente() {
		return cognomeStudenteente;
	}
	/**Setter di cognomeStudenteente
	 * setta la stringa cognomeStudenteente
	 */
	public void setCognomeStudenteente(String cognomeStudenteente) {
		this.cognomeStudenteente = cognomeStudenteente;
	}
	/**Getter di matricola
	 * restituisce la stringa matricola
	 * @return return matricola;
	 */
	public String getMatricola() {
		return matricola;
	}
	/**Setter di matricola
	 * setta la stringa matricola
	 */
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	/**Getter di nomeUtenteResponsabileAziendale
	 * restituisce la stringa nomeUtenteResponsabileAziendale
	 * @return return nomeUtenteResponsabileAziendale;
	 */
	public String getNomeUtenteResponsabileAziendale() {
		return nomeUtenteResponsabileAziendale;
	}
	/**Setter di nomeUtenteResponsabileAziendale
	 * setta la stringa nomeUtenteResponsabileAziendale
	 */
	public void setNomeUtenteResponsabileAziendale(String nomeUtenteResponsabileAziendale) {
		this.nomeUtenteResponsabileAziendale = nomeUtenteResponsabileAziendale;
	}
}
