package bean;

import java.util.ArrayList;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>ListaTirocini</i>
 * ha un parametro listaTirocini(ArrayList<Tirocinio>) 
 * 
 */
public class ListaTirocini {

	private ArrayList<Tirocinio> listaTirocini;
	/**Costruttore
	 * @param ListaTirocini, crea l'array list di Tirocinio
	 */
	public ListaTirocini() {
		this.listaTirocini = new ArrayList<>();
	}
	/**Getter di listaTirocini
	 * restituisce l'array list listaTirocini
	 * @return listaTirocini;
	 */
	public ArrayList<Tirocinio> getListaTirocini() {
		return listaTirocini;
	}
	/**Setter di listaTirocini
	 * setta l'array list listaTirocini
	 */
	public void setListaTirocini(ArrayList<Tirocinio> listaTirocini) {
		this.listaTirocini = listaTirocini;
	}
	/**Metodo addTirocinio
	 * aggiunge un tirocinio all'array list
	 */
	public void addTirocinio(Tirocinio tirocinio) {
		this.listaTirocini.add(tirocinio);
	}
}
