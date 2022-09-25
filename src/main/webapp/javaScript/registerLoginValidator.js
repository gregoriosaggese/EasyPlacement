
function registerValidator(){

	var email = document.forms["register"]["emailRegistrazione"].value;
	var stringValidator = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var nameLenght = email.indexOf("@");
	var pass = document.forms["register"]["passwordRegistrazione"].value;
	var numeroTelefono = document.forms["register"]["numTelefono"].value;
	var nome = document.forms["register"]["nome"].value;
	var cognome = document.forms["register"]["cognome"].value;
	var username = document.forms["register"]["username"].value;

	if(email == ""|| pass == "" || numeroTelefono == "" || nome == "" || cognome == ""  ){
		alert("I campi sono obligatori");
		return false;
	}	
	
	if(email.match(stringValidator)){
		var isValid = true;
		if(isValid){
			if(nameLenght < 5){
				alert("L'email deve essere composta da minimo 5 caratteri");
				return false;
			}
		}
	}else{
		alert("Indirizzo Email non valido")  
		return false  
	}

	if(!isNaN(nome)){
		alert("Nome non corretto");
		return false;
	}

	if(!isNaN(cognome)){
		alert("Cognome non corretto");
		return false;
	}

	if(pass.length < 5){
		alert("La password deve essere di minimo 6 caratteri");
		return false;
	}

	if (isNaN(numeroTelefono)) {
		alert("Numero di telefono non corretto : inserire solo valori numerici");
		return false;
	}

	if(numeroTelefono < 8){
		alert("Numero di telefono non corretto : numero non valido");
		return false;
	} 


}


function loginValidator(){
	
	var nomeUtente = document.forms["login"]["usernameLogin"].value;
	var pass = document.forms["login"]["passwordLogin"].value;

	if(nomeUtente == ""|| pass == ""){
		alert("I campi sono obligatori");
		return false;
	}	
}








