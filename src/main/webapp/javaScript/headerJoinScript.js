
$(document).ready (function (){
	$('#registerForm').hide();
	$('#buttonAccedi').hide();
	$('.showForm').click(function(){
		$('#loginForm').hide();
		$('#registerForm').css('display');
		$('#buttonRegistrati').hide();
		$('#buttonAccedi').css('display');
		$('#registerForm').show();
		$('#buttonAccedi').show();
		
	});
});

$(document).ready (function (){
	$('#registerForm').hide();
	$('#buttonAccedi').hide();
	$('.showForm1').click(function(){
		$('#registerForm').hide();
		$('#loginForm').css('display');
		$('#buttonAccedi').hide();
		$('#buttonRegistrati').css('display');
		$('#loginForm').show();
		$('#buttonRegistrati').show();
		
	});
});