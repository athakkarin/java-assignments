var fnameError = document.getElementById('fname-error');
var lnameError = document.getElementById('lname-error');
var emailError = document.getElementById('email-error');
var passwordError = document.getElementById('password-error');
var mobileError = document.getElementById('mobile-error');
var genderError = document.getElementById('gender-error');
var submitError = document.getElementById('submit-error');

function validateFname(){
	var fname = document.getElementById('f-name').value; 
	if(fname.length == 0){
		fnameError.innerHTML = 'FName is required';
		return false;
	} 
	if(!fname.match(/^[A-Za-z]*\s{1}[A-Za-z]*8/)){ 
		fnameError.innerHTML = 'Write f name';
		return false;
	} 
	fnameError.innerHTML= 'valid' 
	return true;
}

function validateLname(){
	var lname = document.getElementById('l-name').value; 
	if(lname.length == 0){
		lnameError.innerHTML = 'LName is required';
		return false;
	} 
	if(!lname.match(/^[A-Za-z]*\s{1}[A-Za-z]*8/)){ 
		lnameError.innerHTML = 'Write l name';
		return false;
	} 
	lnameError.innerHTML= 'valid' 
	return true;
}

function validateEmail(){
	var email = document.getElementById('c-email').value;
	if(email.length == 0){
		emailError.innerHTML = 'Email is required'
		return false;
	} 
	if(!email.match(/^[A-Za-z]\.\-[0-9]*[@][A-Za-z] [\.][a-z]{2,4}$/)){ 
		emailError.innerHTML = 'Email Invalid'
		return false;
	}
	emailError.innerHTML= 'valid';
	return true;
}

function validatePassword(){
	var password = document.getElementById('p-password').value;
	if(password.length == 0){
		passwordError.innerHTML = 'Password is required'
		return false;
	} 
	if(!password.match(/^[A-Za-z]\w{7,14}$/)){ 
		passwordError.innerHTML = 'Password Invalid'
		return false;
	}
	passwordError.innerHTML= 'valid';
	return true;
}

function validateMobile(){ 
	var mobile = document.getElementById('m-phone').value;
	if(mobile.length == 0){
		mobileError.innerHTML= 'Mobile no is required';
		return false;
	}
	if(mobile.length !== 10){
		mobileError.innerHTML = 'Mobile no should be 10 digits';
		return false;
	} 
	if(!mobile.match(/^[0-9]{10}$/)){
		phoneError.innerHTML = 'Phone no is required'; 
		return false;
	}
	mobileError.innerHTML= 'valid';
	return true;
}


	