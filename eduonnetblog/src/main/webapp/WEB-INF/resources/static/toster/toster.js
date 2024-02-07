/**
 * success
 * warning
 * info 
 * error
 * first parameter is toster type : success, warning, info, error
 * second parameter is header of toster,
 * third parameter is message of toster,
 * fourth parameter is timeout time in second. = 1, 2, 3, 4, 5.
 * style of toster : right , fulltop , fullbotom
 */

 
function showToster(type, header, message, time, size){
	let style = "toast-top-right";
	if (size != undefined && size != "") {
		switch (size) {
			case "right":
				style = "toast-top-right";
				break;
			case "fulltop":
				style = "toast-top-full-width";
				break;
			case "fullbotom":
				style = "toast-bottom-full-width";
				break;
		}
	}
	
	let timeOut = time * 1000;
	toastr.options = {
		"closeButton": false,
		"debug": false,
		"newestOnTop": false,
		"progressBar": false,
		"positionClass": style,
		"preventDuplicates": false,
		"onclick": null,
		"showDuration": "300",
		"hideDuration": "1000",
		"timeOut": timeOut,
		"extendedTimeOut": "1000",
		"showEasing": "swing",
		"hideEasing": "linear",
		"showMethod": "fadeIn",
		"hideMethod": "fadeOut"
	}
	
	toastr[type](header, message);
	
}