package bean;

import java.util.ArrayList;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>ListaAziende</i>
 * ha un parametro listaAziende(ArryList<Aziende>) 
 * 
 */
public class ListaAziende {

	private ArrayList<Azienda> listaAziende;
	/**Costruttore
	 * @param listaAziende, crea l'array list di Azienda
	 */
	public ListaAziende() {
		this.listaAziende = new ArrayList<>();
	}
	/**Getter di listaAziende
	 * restituisce l'array lists listaAziende
	 * @return listaAziende;
	 */
	public ArrayList<Azienda> getListaAziende() {
		return listaAziende;
	}
	/**Setter di listaAziende
	 * setta l'array lists listaAziende
	 */
	public void setListaAziende(ArrayList<Azienda> listaAziende) {
		this.listaAziende = listaAziende;
	}
	/**Metodo addAzienda
	 * aggiunge un,azienda all'array list
	 */
	public void addAzienda(Azienda azienda) {
		listaAziende.add(azienda);
	}
}
