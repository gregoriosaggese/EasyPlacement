package bean;

import java.util.ArrayList;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>ListaProgettiFormativi</i>
 * ha un parametro listaProgettoFormativo(ArryList<ProgettoFormativo>) 
 * 
 */
public class ListaProgettiFormativi {

	private ArrayList<ProgettoFormativo> listaProgettoFormativo;
	/**Costruttore
	 * @param listaProgettoFormativo, crea l'array list di ProgettoFormativo
	 */
	public ListaProgettiFormativi() {
		this.listaProgettoFormativo = new ArrayList<>();
	}
	/**Getter di listaProgettoFormativo
	 * restituisce l'array list listaProgettoFormativo
	 * @return listaProgettoFormativo;
	 */
	public ArrayList<ProgettoFormativo> getListaProgettoFormativo() {
		return listaProgettoFormativo;
	}
	/**Setter di listaProgettoFormativo
	 * setta l'array list listaProgettoFormativo
	 */
	public void setListaProgettoFormativo(ArrayList<ProgettoFormativo> listaProgettoFormativo) {
		this.listaProgettoFormativo = listaProgettoFormativo;
	}
	/**Metodo addProgettoFormativo
	 * aggiunge un,progetto formativo all'array list
	 */
	public void addProgettoFormativo(ProgettoFormativo progettoFormativo) {
		this.listaProgettoFormativo.add(progettoFormativo);
	}
}
