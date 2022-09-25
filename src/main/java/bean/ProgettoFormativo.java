package bean;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>ProgettoFormativo</i>
 * ha un parametro id(int)
 * ha un parametro Nome(String)
 * ha un parametro Cognome(String)
 * ha un parametro Residenza(String)
 * ha un parametro Via(String)
 * ha un parametro Natoa(String)
 * ha un parametro Natoil(String)
 * ha un parametro CodiceFiscale(String)
 * ha un parametro Telefonoa(String)
 * ha un parametro Firma_Azienda(boolean)
 * ha un parametro Firma_Tutor_Aziendale(boolean)
 * ha un parametro Firma_Presidente_Consiglio_Didattico(boolean)
 * ha un parametro Firma_Tutor_Accademico(boolean)
 * ha un parametro Firma_Studente(boolean)
 * ha un parametro Email_Studente(String)
 * ha un parametro Nome_Utente_Responsabile_Aziendale(String)
 * ha un parametro Nome_Utente_Tutor_Aziendale(String)
 * ha un parametro Nome_Utente_Tutor_Accademico(String)
 * ha un parametro Opzione(boolean)
 * ha un parametro IscrittoAl(String)
 * ha un parametro AnnoCorsoLaurea(String)
 * ha un parametro LaureaIn(String)
 * ha un parametro Matricola(String)
 * ha un parametro AnnoAccademico(String)
 * ha un parametro NumeroCFU(int)
 * ha un parametro TipoLaurea(boolean)
 * ha un parametro DataConseguimentoLaurea(String)
 * ha un parametro InpossessodiLaurea(String)
 * ha un parametro PortatoreHandicap(boolean)
 * ha un parametro DataFirma(String)
 * ha un parametro dataInizio(String)
 * ha un parametro dataFine(String)
 * ha un parametro sede(String)
 */
public class ProgettoFormativo {
	private int id;
	private String Nome;
	private String Cognome;
	private String Residenza;
	private String Via;
	private String Natoa;
	private String Natoil;
	private String CodiceFiscale;
	private String Telefono;
	private boolean Firma_Azienda;
	private boolean Firma_Tutor_Aziendale;
	private boolean Firma_Presidente_Consiglio_Didattico;
	private boolean Firma_Tutor_Accademico;
	private boolean Firma_Studente	;
	private String Email_Studente;
	private String Nome_Utente_Responsabile_Aziendale;
	private String Nome_Utente_Tutor_Aziendale;
	private String Nome_Utente_Tutor_Accademico;
	private boolean Opzione;
	private String IscrittoAl;
	private String AnnoCorsoLaurea;
	private String LaureaIn;
	private String Matricola;
	private String AnnoAccademico;
	private int NumeroCFU;
	private boolean TipoLaurea;
	private String DataConseguimentoLaurea;
	private String InpossessodiLaurea;
	private boolean PortatoreHandicap;
	private String DataFirma;
	private String dataInizio;
	private String dataFine;
	private String sede;
	/**Costruttore
	 * vuoto
	 */
	public ProgettoFormativo() {
		super();
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
	/**Getter di Nome
	 * restituisce la stringa Nome
	 * @return return Nome;
	 */
	public String getNome() {
		return Nome;
	}
	/**Setter di nome
	 * setta la stringa nome
	 */
	public void setNome(String nome) {
		Nome = nome;
	}
	/**Getter di Cognome
	 * restituisce la stringa Cognome
	 * @return return Cognome;
	 */
	public String getCognome() {
		return Cognome;
	}
	/**Setter di cognome
	 * setta la stringa cognome
	 */
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	/**Getter di Residenza
	 * restituisce la stringa Residenza
	 * @return return Residenza;
	 */
	public String getResidenza() {
		return Residenza;
	}
	/**Setter di Residenza
	 * setta la stringa Residenza
	 */
	public void setResidenza(String residenza) {
		Residenza = residenza;
	}
	/**Getter di Via
	 * restituisce la stringa Via
	 * @return return Via;
	 */
	public String getVia() {
		return Via;
	}
	/**Setter di Via
	 * setta la stringa Via
	 */
	public void setVia(String via) {
		Via = via;
	}
	/**Getter di Natoa
	 * restituisce la stringa Natoa
	 * @return return Natoa;
	 */
	public String getNatoa() {
		return Natoa;
	}
	/**Setter di Natoa
	 * setta la stringa Natoa
	 */
	public void setNatoa(String natoa) {
		Natoa = natoa;
	}
	/**Getter di Natoil
	 * restituisce la stringa Natoil
	 * @return return Natoil;
	 */
	public String getNatoil() {
		return Natoil;
	}
	/**Setter di Natoil
	 * setta la stringa Natoil
	 */
	public void setNatoil(String natoil) {
		Natoil = natoil;
	}
	/**Getter di CodiceFiscale
	 * restituisce la stringa CodiceFiscale
	 * @return return CodiceFiscale;
	 */
	public String getCodiceFiscale() {
		return CodiceFiscale;
	}
	/**Setter di CodiceFiscale
	 * setta la stringa CodiceFiscale
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}
	/**Getter di Telefono
	 * restituisce la stringa Telefono
	 * @return return Telefono;
	 */
	public String getTelefono() {
		return Telefono;
	}
	/**Setter di Telefono
	 * setta la stringa Telefono
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	/**Getter di Firma_Azienda
	 * restituisce boolean Firma_Azienda
	 * @return return Firma_Azienda;
	 */
	public boolean isFirma_Azienda() {
		return Firma_Azienda;
	}
	/**Setter di Firma_Azienda
	 * setta  boolean Firma_Azienda
	 */
	public void setFirma_Azienda(boolean firma_Azienda) {
		Firma_Azienda = firma_Azienda;
	}
	/**Getter di Firma_Tutor_Aziendale
	 * restituisce boolean Firma_Tutor_Aziendale
	 * @return return Firma_Tutor_Aziendale;
	 */
	public boolean isFirma_Tutor_Aziendale() {
		return Firma_Tutor_Aziendale;
	}
	/**Setter di Firma_Tutor_Aziendale
	 * setta boolean Firma_Tutor_Aziendale
	 */
	public void setFirma_Tutor_Aziendale(boolean firma_Tutor_Aziendale) {
		Firma_Tutor_Aziendale = firma_Tutor_Aziendale;
	}
	/**Getter di Firma_Presidente_Consiglio_Didattico
	 * restituisce boolean Firma_Presidente_Consiglio_Didattico
	 * @return return Firma_Presidente_Consiglio_Didattico;
	 */
	public boolean isFirma_Presidente_Consiglio_Didattico() {
		return Firma_Presidente_Consiglio_Didattico;
	}
	/**Setter di Firma_Presidente_Consiglio_Didattico
	 * setta boolean Firma_Presidente_Consiglio_Didattico
	 */
	public void setFirma_Presidente_Consiglio_Didattico(boolean firma_Presidente_Consiglio_Didattico) {
		Firma_Presidente_Consiglio_Didattico = firma_Presidente_Consiglio_Didattico;
	}
	/**Getter di Firma_Tutor_Accademico
	 * restituisce boolean Firma_Tutor_Accademico
	 * @return return Firma_Tutor_Accademico;
	 */
	public boolean isFirma_Tutor_Accademico() {
		return Firma_Tutor_Accademico;
	}
	/**Setter di Firma_Tutor_Accademico
	 * setta boolean Firma_Tutor_Accademico
	 */
	public void setFirma_Tutor_Accademico(boolean firma_Tutor_Accademico) {
		Firma_Tutor_Accademico = firma_Tutor_Accademico;
	}
	/**Getter di Firma_Studente
	 * restituisce boolean Firma_Studente
	 * @return return Firma_Studente;
	 */
	public boolean isFirma_Studente() {
		return Firma_Studente;
	}
	/**Setter di Firma_Studente
	 * setta boolean Firma_Studente
	 */
	public void setFirma_Studente(boolean firma_Studente) {
		Firma_Studente = firma_Studente;
	}
	/**Getter di Email_Studente
	 * restituisce la stringa Email_Studente
	 * @return return Email_Studente;
	 */
	public String getEmail_Studente() {
		return Email_Studente;
	}
	/**Setter di Email_Studente
	 * setta la stringa Email_Studente
	 */
	public void setEmail_Studente(String email_Studente) {
		Email_Studente = email_Studente;
	}
	/**Getter di Nome_Utente_Responsabile_Aziendale
	 * restituisce la stringa Nome_Utente_Responsabile_Aziendale
	 * @return return Nome_Utente_Responsabile_Aziendale;
	 */
	public String getNome_Utente_Responsabile_Aziendale() {
		return Nome_Utente_Responsabile_Aziendale;
	}
	/**Setter di Nome_Utente_Responsabile_Aziendale
	 * setta la stringa Nome_Utente_Responsabile_Aziendale
	 */
	public void setNome_Utente_Responsabile_Aziendale(String nome_Utente_Responsabile_Aziendale) {
		Nome_Utente_Responsabile_Aziendale = nome_Utente_Responsabile_Aziendale;
	}
	/**Getter di Nome_Utente_Tutor_Aziendale
	 * restituisce la stringa Nome_Utente_Tutor_Aziendale
	 * @return return Nome_Utente_Tutor_Aziendale;
	 */
	public String getNome_Utente_Tutor_Aziendale() {
		return Nome_Utente_Tutor_Aziendale;
	}
	/**Setter di Nome_Utente_Tutor_Aziendale
	 * setta la stringa Nome_Utente_Tutor_Aziendale
	 */
	public void setNome_Utente_Tutor_Aziendale(String nome_Utente_Tutor_Aziendale) {
		Nome_Utente_Tutor_Aziendale = nome_Utente_Tutor_Aziendale;
	}
	/**Getter di Nome_Utente_Tutor_Accademico
	 * restituisce la stringa Nome_Utente_Tutor_Accademico
	 * @return return Nome_Utente_Tutor_Accademico;
	 */
	public String getNome_Utente_Tutor_Accademico() {
		return Nome_Utente_Tutor_Accademico;
	}
	/**Setter di Nome_Utente_Tutor_Accademico
	 * setta la stringa Nome_Utente_Tutor_Accademico
	 */
	public void setNome_Utente_Tutor_Accademico(String nome_Utente_Tutor_Accademico) {
		Nome_Utente_Tutor_Accademico = nome_Utente_Tutor_Accademico;
	}
	/**Getter di Opzione
	 * restituisce boolean Opzione
	 * @return return Opzione;
	 */
	public boolean isOpzione() {
		return Opzione;
	}
	/**Setter di Opzione
	 * setta boolean Opzione
	 */
	public void setOpzione(boolean opzione) {
		Opzione = opzione;
	}
	/**Getter di IscrittoAl
	 * restituisce la stringa IscrittoAl
	 * @return return IscrittoAl;
	 */
	public String getIscrittoAl() {
		return IscrittoAl;
	}
	/**Setter di IscrittoAl
	 * setta la stringa IscrittoAl
	 */
	public void setIscrittoAl(String iscrittoAl) {
		IscrittoAl = iscrittoAl;
	}
	/**Getter di AnnoCorsoLaurea
	 * restituisce la stringa AnnoCorsoLaurea
	 * @return return AnnoCorsoLaurea;
	 */
	public String getAnnoCorsoLaurea() {
		return AnnoCorsoLaurea;
	}
	/**Setter di AnnoCorsoLaurea
	 * setta la stringa AnnoCorsoLaurea
	 */
	public void setAnnoCorsoLaurea(String annoCorsoLaurea) {
		AnnoCorsoLaurea = annoCorsoLaurea;
	}
	/**Getter di LaureaIn
	 * restituisce la stringa LaureaIn
	 * @return return LaureaIn;
	 */
	public String getLaureaIn() {
		return LaureaIn;
	}
	/**Setter di LaureaIn
	 * setta la stringa LaureaIn
	 */
	public void setLaureaIn(String laureaIn) {
		LaureaIn = laureaIn;
	}
	/**Getter di Matricola
	 * restituisce la stringa Matricola
	 * @return return Matricola;
	 */
	public String getMatricola() {
		return Matricola;
	}
	/**Setter di Matricola
	 * setta la stringa Matricola
	 */
	public void setMatricola(String matricola) {
		Matricola = matricola;
	}
	/**Getter di AnnoAccademico
	 * restituisce la stringa AnnoAccademico
	 * @return return AnnoAccademico;
	 */
	public String getAnnoAccademico() {
		return AnnoAccademico;
	}
	/**Setter di AnnoAccademico
	 * setta la stringa AnnoAccademico
	 */
	public void setAnnoAccademico(String annoAccademico) {
		AnnoAccademico = annoAccademico;
	}
	/**Getter di NumeroCFU
	 * restituisce l'int NumeroCFU
	 * @return return NumeroCFU;
	 */
	public int getNumeroCFU() {
		return NumeroCFU;
	}
	/**Setter di NumeroCFU
	 * setta l'int NumeroCFU
	 */
	public void setNumeroCFU(int numeroCFU) {
		NumeroCFU = numeroCFU;
	}
	/**Getter di TipoLaurea
	 * restituisce boolean TipoLaurea
	 * @return return TipoLaurea;
	 */
	public boolean isTipoLaurea() {
		return TipoLaurea;
	}
	/**Setter di TipoLaurea
	 * setta la stringa TipoLaurea
	 */
	public void setTipoLaurea(boolean tipoLaurea) {
		TipoLaurea = tipoLaurea;
	}
	/**Getter di DataConseguimentoLaurea
	 * restituisce la stringa DataConseguimentoLaurea
	 * @return return DataConseguimentoLaurea;
	 */
	public String getDataConseguimentoLaurea() {
		return DataConseguimentoLaurea;
	}
	/**Setter di DataConseguimentoLaurea
	 * setta la stringa DataConseguimentoLaurea
	 */
	public void setDataConseguimentoLaurea(String dataConseguimentoLaurea) {
		DataConseguimentoLaurea = dataConseguimentoLaurea;
	}
	/**Getter di InpossessodiLaurea
	 * restituisce la stringa InpossessodiLaurea
	 * @return return InpossessodiLaurea;
	 */
	public String getInpossessodiLaurea() {
		return InpossessodiLaurea;
	}
	/**Setter di InpossessodiLaurea
	 * setta la stringa InpossessodiLaurea
	 */
	public void setInpossessodiLaurea(String inpossessodiLaurea) {
		InpossessodiLaurea = inpossessodiLaurea;
	}
	/**Getter di PortatoreHandicap
	 * restituisce boolean PortatoreHandicap
	 * @return return PortatoreHandicap;
	 */
	public boolean isPortatoreHandicap() {
		return PortatoreHandicap;
	}
	/**Setter di PortatoreHandicap
	 * setta boolean PortatoreHandicap
	 */
	public void setPortatoreHandicap(boolean portatoreHandicap) {
		PortatoreHandicap = portatoreHandicap;
	}
	/**Getter di DataFirma
	 * restituisce la stringa DataFirma
	 * @return return DataFirma;
	 */
	public String getDataFirma() {
		return DataFirma;
	}
	/**Setter di DataFirma
	 * setta la stringa DataFirma
	 */
	public void setDataFirma(String dataFirma) {
		DataFirma = dataFirma;
	}
}
