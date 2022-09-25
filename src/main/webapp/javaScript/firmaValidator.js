/**
 * 
 */
function validator() {
	var check = document.forms["firmapresenza"]["check"].checked;
	if(check == false){
		return false;
	}else {
		return true;
	}
}