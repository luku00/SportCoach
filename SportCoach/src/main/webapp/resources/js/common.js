function validateNewAccount() {
    var emailObj = document.getElementById("email");
    var email = document.getElementById("email").value;
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailPattern.test(email)) {
        alert("Email Id is not valid!");
        emailObj.style.borderColor = "#FF0000";
        return false;
    }
    if (!validatePasswordMatch()) {
        alert("Passwords not match");
        document.getElementById("password").style.borderColor = "#FF0000";
        document.getElementById("password1").style.borderColor = "#FF0000";
        return false;
    }
   return true;
}

function validatePasswordMatch() {
    var password1 = document.getElementById("password").value;
    var password2 = document.getElementById("password1").value;
    if (password1 === password2) {
        return true;
    } else {
        return false;
    }
}
