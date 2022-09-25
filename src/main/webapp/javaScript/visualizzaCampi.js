$(document).ready(function() {
	$('#formRicerca').hide();
	$('#consultaRegistro').hide();
	$('#compilaModuli').hide();
	$('#progettoFormativo').hide();
	$('.richiestaStudente').click(function() {
		$('#consultaRegistro').hide();
		$('#compilaModuli').hide();
		$('#progettoFormativo').hide();
		$('#formRicerca').css('display');
		$('#formRicerca').show();
	});
});

$(document).ready(function() {
	$('#formRicerca').hide();
	$('#consultaRegistro').hide();
	$('#compilaModuli').hide();
	$('#progettoFormativo').hide();
	$('.consultaRegistro').click(function() {
		$('#formRicerca').hide();
		$('#compilaModuli').hide();
		$('#progettoFormativo').hide();
		$('#consultaRegistro').css('display');
		$('#consultaRegistro').show();
	});
});

$(document).ready(function() {
	$('#formRicerca').hide();
	$('#consultaRegistro').hide();
	$('#compilaModuli').hide();
	$('#progettoFormativo').hide();
	$('.compilaModuli').click(function() {
		$('#formRicerca').hide();
		$('#consultaRegistro').hide();
		$('#progettoFormativo').hide();
		$('#compilaModuli').css('display');
		$('#compilaModuli').show();
	});
});

$(document).ready(function() {
	$('#formRicerca').hide();
	$('#consultaRegistro').hide();
	$('#compilaModuli').hide();
	$('#progettoFormativo').hide();
	$('.progettoFormativo').click(function() {
		$('#formRicerca').hide();
		$('#consultaRegistro').hide();
		$('#compilaModuli').hide();
		$('#progettoFormativo').css('display');
		$('#progettoFormativo').show();
	});
});

$(document).ready(function() {
	$('#formRicerca').hide();
	$('#compilaModuli').hide();
	$('.richiestaStudente').click(function() {
		$('#compilaModuli').hide();
		$('#divListaRichieste').css('display');
		$('#divListaRichieste').show();
	});
});

$(document).ready(function() {
	$('#formRicerca').hide();
	$('#compilaModuli').hide();
	$('.compilaModuli').click(function() {
		$('#formRicerca').hide();
		$('#compilaModuli').css('display');
		$('#compilaModuli').show();
	});
});

