package bean;

import java.util.ArrayList;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>ListaRegistro</i>
 * ha un parametro listaRegistro(ArrayList<Registro>)
 * 
 */
public class ListaRegistro {

	private ArrayList<Registro> listaRegistro;
	/**Costruttore
	 * @param ListaRegistro, crea l'array list di Registro
	 */
	public ListaRegistro() {
		this.listaRegistro = new ArrayList<>();
	}
	/**Getter di listaRegistro
	 * restituisce l'array list listaRegistro
	 * @return listaRegistro;
	 */
	public ArrayList<Registro> getListaRegistro() {
		return listaRegistro;
	}
	/**Setter di listaRegistro
	 * setta l'array list listaRegistro
	 */
	public void setListaRegistro(ArrayList<Registro> listaRegistro) {
		this.listaRegistro = listaRegistro;
	}
	/**Metodo addRegistro
	 * aggiunge un registro all'array list
	 */
	public void addRegistro(Registro registro) {
		listaRegistro.add(registro);
	}
}