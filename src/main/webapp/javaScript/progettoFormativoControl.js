
function control(){

	var opzione =  document.forms["progettoformativo"]["optradio0"].value;
	var opzion1 =  document.forms["progettoformativo"]["optradio"].value;
	var opzion2 =  document.forms["progettoformativo"]["optradio1"].value;

	var dataConseguimentoLaurea = document.forms["progettoformativo"]["dataconseguimentolaurea"].value;
	var matricola = document.forms["progettoformativo"]["matricola"].value;
	var numeroCFU = document.forms["progettoformativo"]["numeroCFU"].value;

	if(opzione == "uno"){
		dataConseguimentoLaurea = "nessuna data";
	}else if(opzione == "due"){
		matricola = "nessuna matricola";
		numeroCFU = "0";
	}

	var nome = document.forms["progettoformativo"]["nome"].value;
	var cognome = document.forms["progettoformativo"]["cognome"].value;
	var residente = document.forms["progettoformativo"]["residenza"].value;
	var via = document.forms["progettoformativo"]["via"].value;
	var nato = document.forms["progettoformativo"]["nato"].value;
	var il = document.forms["progettoformativo"]["il"].value;
	var codicefiscale = document.forms["progettoformativo"]["codicefiscale"].value;
	var telefono = document.forms["progettoformativo"]["telefono"].value;
	var firmaStudente = document.forms["progettoformativo"]["firmastudente"].value;

	if(nome == "" || cognome == "" || residente == ""|| 
			via == ""|| nato == ""|| il == ""|| codicefiscale == ""
				|| telefono == "" ){
		alert("I campi sono obbligatori");
		return false;
	}
	if(opzione == ""){
		alert("Barra la casella")
		return false;
	}

	if(firmaStudente == "Non Firmato"){
		alert("Non hai firmato");
		return false;
	}
	if(!isNaN(nome)){
		alert("Nome non corretto");
		return false;
	}

	if(!isNaN(cognome)){
		alert("Cognome non corretto");
		return false;
	}

	if(isNaN(telefono)){
		alert("Telefono non corretto");
		return false;
	}

	if(codicefiscale.length != 16){
		alert("Codice Fiscale non valido");
		return false;
	}

	if(opzione == "due" && dataConseguimentoLaurea == ""){
		alert("Data conseguimento laurea non inserita");
		return false;
	}

	if(opzione == "uno"){
		if(matricola == ""){
			alert("Matricola non inserita");
			return false;
		}
		if(numeroCFU == ""){
			alert("Numero cfu non inserito");
			return false;
		}

	}

	if(opzion1 == ""){
		alert("Barra la casella Tipo Laurea");
		return false;
	}

	if(opzion2 == ""){
		alert("Barra la casella Portatore Handicap");
		return false;
	}

}