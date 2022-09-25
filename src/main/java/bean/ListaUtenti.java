package bean;

import java.util.ArrayList;

import bean.Studente;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>ArrayList<Studente> listaUtenti</i>
 * ha un parametro listaUtenti(ArrayList<Studente>)
 * 
 */
public class ListaUtenti {

	private ArrayList<Studente> listaUtenti;
	/**Costruttore
	 * @param listaUtenti, crea l'array list di Studente
	 */
	public ListaUtenti() {
		this.listaUtenti = new ArrayList<>();
	}
	/**Getter di listaUtenti
	 * restituisce l'array list listaUtenti
	 * @return listaUtenti;
	 */
	public ArrayList<Studente> getListaUtenti() {
		return listaUtenti;
	}
	/**Setter di listaUtenti
	 * setta l'array list listaUtenti
	 */
	public void setListaUtenti(ArrayList<Studente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}
	/**Metodo addUtente
	 * aggiunge un studente all'array list
	 */
	public void addUtente(Studente utente) {
		listaUtenti.add(utente);
	}
}