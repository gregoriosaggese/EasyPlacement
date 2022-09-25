package bean;

import java.util.ArrayList;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>ListaRichieste</i>
 * ha un parametro listaRichieste(ArrayList<Richiesta>) 
 * 
 */
public class ListaRichieste {
	
	private ArrayList<Richiesta> listaRichieste;
	/**Costruttore
	 * @param ListaRichieste, crea l'array list di Richiesta
	 */
	public ListaRichieste() {
		this.listaRichieste = new ArrayList<>();
	}
	/**Getter di listaRichieste
	 * restituisce l'array list listaRichieste
	 * @return listaRichieste;
	 */
	public ArrayList<Richiesta> getListaRichieste() {
		return listaRichieste;
	}
	/**Setter di listaRichieste
	 * setta l'array list listaRichieste
	 */
	public void setListaRichieste(ArrayList<Richiesta> listaRichieste) {
		this.listaRichieste = listaRichieste;
	}
	/**Metodo addRichiesta
	 * aggiunge una richiesta all'array list
	 */
	public void addRichiesta(Richiesta richiesta) {
		listaRichieste.add(richiesta);
	}
}
