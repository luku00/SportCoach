function validateNewAccount() {
    var emailObj = document.getElementById("email");
    if (!validateEmail(emailObj)) {
        return false;
    }
    var password1 = document.getElementById("password");
    var password2 = document.getElementById("password1");
    if (!validatePasswordMatch(password1.value, password2.value)) {
        alert("Passwords not match");
        password1.style.borderColor = "#FF0000";
        password2.style.borderColor = "#FF0000";
        return false;
    }
   return true;
}

function validateNewSubAccount() {
    var emailObj = document.getElementById("subAccountEmail");
    if (!validateEmail(emailObj)) {
        return false;
    }
//    var password1 = document.getElementById("subAccountPassword");
//    var password2 = document.getElementById("subAccountPassword1");
//    if (!validatePasswordMatch(password1.value, password2.value)) {
//        alert("Passwords not match");
//        password1.style.borderColor = "#FF0000";
//        password2.style.borderColor = "#FF0000";
//        return false;
//    }
    return true;
}

function validateEmail(email) {
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailPattern.test(email.value)) {
        alert("Email Id is not valid!");
        email.style.borderColor = "#FF0000";
        return false;
    }
    return true;
}

function validatePasswordMatch(password1, password2) {
    if (password1 === password2) {
        return true;
    } else {
        return false;
    }
}

function changeAccount() {
    document.getElementById("firstName").disabled = false;
    document.getElementById("lastName").disabled = false;
    document.getElementById("email").disabled = false;
    document.getElementById("streetName").disabled = false;
    document.getElementById("streetNumber").disabled = false;
    document.getElementById("city").disabled = false;
    document.getElementById("zip").disabled = false;
    document.getElementById("country").disabled = false;
}

function displaySubAccountForm() {
    document.getElementById("subAccountButtons").hidden = false;
    document.getElementById("subAccountRequestForm").hidden = false;
}

function validatePasswordChange() {
    var password1 = document.getElementById("passwd1");
    var password2 = document.getElementById("passwd2");
    if (!validatePasswordMatch(password1.value, password2.value)) {
        alert("Passwords not match");
        password1.style.borderColor = "#FF0000";
        password2.style.borderColor = "#FF0000";
        return false;
    }
    return true;
}