function validator() {

	var opzione1 =  document.forms["inviaquestionario"]["conoscenze"].value;
	var opzione2 =  document.forms["inviaquestionario"]["formazione"].value;
	var opzione3 =  document.forms["inviaquestionario"]["skill"].value;
	var opzione4 =  document.forms["inviaquestionario"]["durata"].value;
	var opzione5 =  document.forms["inviaquestionario"]["Valutazione"].value;
	var opzione6 =  document.forms["inviaquestionario"]["allente"].value;
	var opzione7 =  document.forms["inviaquestionario"]["Ambiente"].value;
	var opzione8 =  document.forms["inviaquestionario"]["Competenze"].value;
	var opzione9 =  document.forms["inviaquestionario"]["strumentale"].value;
	var opzione10 =  document.forms["inviaquestionario"]["Ospitante"].value;
	var opzione11 =  document.forms["inviaquestionario"]["esaustive"].value;
	var opzione12 =  document.forms["inviaquestionario"]["assistenza"].value;
	var opzione13 =  document.forms["inviaquestionario"]["servizi"].value;



	var tirocinante =  document.forms["inviaquestionario"]["tirocinante"].value;
	var periodosvolgimento =  document.forms["inviaquestionario"]["periodosvolgimento"].value;
	var titolo =  document.forms["inviaquestionario"]["titolodeltirocinio"].value;
	var ente =  document.forms["inviaquestionario"]["ente"].value;
	var sede =  document.forms["inviaquestionario"]["sede"].value;
	var provincia =  document.forms["inviaquestionario"]["provincia"].value;
	var tutorente =  document.forms["inviaquestionario"]["enteospitante"].value;
	var email =  document.forms["inviaquestionario"]["email"].value;
	var tutoraccademico =  document.forms["inviaquestionario"]["tutoraccademico"].value;
	var firmaStudente = document.forms["inviaquestionario"]["firmastudente"].value;

	if(tirocinante == "" || periodosvolgimento =="" || titolo ==""|| ente ==""
		|| sede ==""|| provincia ==""|| tutorente ==""|| email ==""|| tutoraccademico ==""){
		alert("Compila i campi")
		return false;
	}

	if(firmaStudente == "Non Firmato"){
		alert("Non hai firmato");
		return false;
	}

	if(opzione1 == ""){
		alert("Barrare casella 1");
		return false;
	}

	if(opzione2 == ""){
		alert("Barrare casella 2");
		return false;
	}

	if(opzione3 == ""){
		alert("Barrare casella 3");
		return false;
	}

	if(opzione4 == ""){
		alert("Barrare casella 4");
		return false;
	}

	if(opzione5 == ""){
		alert("Barrare casella 5");
		return false;
	}

	if(opzione6 == ""){
		alert("Barrare casella 6");
		return false;
	}

	if(opzione7 == ""){
		alert("Barrare casella 7");
		return false;
	}

	if(opzione8 == ""){
		alert("Barrare casella 8");
		return false;
	}

	if(opzione9 == ""){
		alert("Barrare casella 9");
		return false;
	}

	if(opzione10 == ""){
		alert("Barrare casella 10");
		return false;
	}

	if(opzione11 == ""){
		alert("Barrare casella 11");
		return false;
	}

	if(opzione12 == ""){
		alert("Barrare casella 12");
		return false;
	}

	if(opzione13 == ""){
		alert("Barrare casella 13");
		return false;
	}
}

function validator2() {

	var opzione1 =  document.forms["inviaquestionario"]["conoscenze"].value;
	var opzione2 =  document.forms["inviaquestionario"]["formazione"].value;
	var opzione3 =  document.forms["inviaquestionario"]["skill"].value;
	var opzione4 =  document.forms["inviaquestionario"]["durata"].value;
	var opzione5 =  document.forms["inviaquestionario"]["allente"].value;
	var opzione6 =  document.forms["inviaquestionario"]["Ambiente"].value;
	var opzione7 =  document.forms["inviaquestionario"]["Competenze"].value;
	var opzione8 =  document.forms["inviaquestionario"]["strumentale"].value;
	var opzione9 =  document.forms["inviaquestionario"]["esaustive"].value;
	var opzione10 =  document.forms["inviaquestionario"]["assistenza"].value;
	var opzione11 =  document.forms["inviaquestionario"]["servizi"].value;


	var enteospitante =  document.forms["inviaquestionario"]["enteospitante"].value;
	var sedetirocinio =  document.forms["inviaquestionario"]["sedetirocinio"].value;
	var provincia =  document.forms["inviaquestionario"]["provincia"].value;
	var tutorenteospitante =  document.forms["inviaquestionario"]["tutorenteospitante"].value;
	var posizionericoperta =  document.forms["inviaquestionario"]["posizionericoperta"].value;
	var email =  document.forms["inviaquestionario"]["email"].value;
	var tutoraccademico =  document.forms["inviaquestionario"]["tutoraccademico"].value;
	var tirocinante =  document.forms["inviaquestionario"]["tirocinante"].value;
	var periodosvolgimento =  document.forms["inviaquestionario"]["periodosvolgimento"].value;
	var titolotirocinio = document.forms["inviaquestionario"]["titolotirocinio"].value;

	if(enteospitante == "" || sedetirocinio =="" || provincia ==""|| tutorenteospitante ==""
		|| posizionericoperta ==""|| email ==""|| tutoraccademico ==""|| tirocinante ==""|| periodosvolgimento =="" || titolotirocinio==""){
		alert("Compila i campi")
		return false;
	}

	if(firmaStudente == "Non Firmato"){
		alert("Non hai firmato");
		return false;
	}

	if(opzione1 == ""){
		alert("Barrare casella 1");
		return false;
	}

	if(opzione2 == ""){
		alert("Barrare casella 2");
		return false;
	}

	if(opzione3 == ""){
		alert("Barrare casella 3");
		return false;
	}

	if(opzione4 == ""){
		alert("Barrare casella 4");
		return false;
	}

	if(opzione5 == ""){
		alert("Barrare casella 5");
		return false;
	}

	if(opzione6 == ""){
		alert("Barrare casella 6");
		return false;
	}

	if(opzione7 == ""){
		alert("Barrare casella 7");
		return false;
	}

	if(opzione8 == ""){
		alert("Barrare casella 8");
		return false;
	}

	if(opzione9 == ""){
		alert("Barrare casella 9");
		return false;
	}

	if(opzione10 == ""){
		alert("Barrare casella 10");
		return false;
	}

	if(opzione11 == ""){
		alert("Barrare casella 11");
		return false;
	}




}


