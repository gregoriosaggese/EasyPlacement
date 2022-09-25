package bean;

/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>Azienda</i>
 *  un parametro data(String),
 *  un parametro isFirmed(boolean),
 *  un parametro id(int)
 * 
 */
public class Registro {

	private String data;
	private boolean isFirmed;
	private int id;
	/**Costruttore
	 * vuoto
	 */
	public Registro() {	
		
	}
	/**Getter di data
	 * restituisce la stringa data
	 * @return return data;
	 */
	public String getData() {
		return data;
	}
	/**Setter di data
	 * setta la stringa data
	 */
	public void setData(String data) {
		this.data = data;
	}
	/**Getter di isFirmed
	 * restituisce boolean isFirmed
	 * @return return isFirmed;
	 */
	public boolean getIsFirmed() {
		return isFirmed;
	}
	/**Setter di isFirmed
	 * setta boolean isFirmed
	 */
	public void setIsFirmed(boolean isFirmed) {
		this.isFirmed = isFirmed;
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