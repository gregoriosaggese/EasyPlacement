package bean;

/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>Azienda</i>
 * ha un parametro nome(String) , un parametro sede(String),un parametro numerotelefono(String),un parametro progettoofferto(String),un parametro inizioTirocinio(String),un parametro fineTirocinio(String)
 * 
 */
public class Azienda {
	private String nome;
	private String sede;
	private String numerotelefono;
	private String progettoofferto;
	private String inizioTirocinio;
	private String fineTirocinio;
	/**Costruttore
	 * vuoto
	 */
	public Azienda() {

	}
	/**Getter di inizioTirocinio
	 * restituisce la stringa inizioTirocinio
	 * @return return inizioTirocinio;
	 */
	public String getInizioTirocinio() {
		return inizioTirocinio;
	}
	/**Setter di inizioTirocinio
	 * setta la stringa inizioTirocinio
	 */
	public void setInizioTirocinio(String inizioTirocinio) {
		this.inizioTirocinio = inizioTirocinio;
	}
	/**Getter di fineTirocinio
	 * restituisce la stringa fineTirocinio
	 * @return return fineTirocinio;
	 */
	public String getFineTirocinio() {
		return fineTirocinio;
	}
	/**Setter di fineTirocinio
	 * setta la stringa fineTirocinio
	 */
	public void setFineTirocinio(String fineTirocinio) {
		this.fineTirocinio = fineTirocinio;
	}
	/**Getter di nome
	 * restituisce la stringa nome
	 * @return return nome;
	 */
	public String getNome() {
		return nome;
	}
	/**Setter di nome
	 * setta la stringa nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	/**Getter di numerotelefono
	 * restituisce la stringa numerotelefono
	 * @return return numerotelefono;
	 */
	public String getNumerotelefono() {
		return numerotelefono;
	}
	/**Setter di numerotelefono
	 * setta la stringa numerotelefono
	 */
	public void setNumerotelefono(String numerotelefono) {
		this.numerotelefono = numerotelefono;
	}
	/**Getter di progettoofferto
	 * restituisce la stringa progettoofferto
	 * @return return progettoofferto;
	 */
	public String getProgettoofferto() {
		return progettoofferto;
	}
	/**Setter di progettoofferto
	 * setta la stringa progettoofferto
	 */
	public void setProgettoofferto(String progettoofferto) {
		this.progettoofferto = progettoofferto;
	}
}