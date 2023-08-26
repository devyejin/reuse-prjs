document.getElementById("formAuthentication").addEventListener("submit", e => {
    e.preventDefault();
    e.stopPropagation();

    const pwd = document.getElementById("password").value;
    const confirmPwd = document.getElementById("confirmPassword").value;

    if(pwd !== confirmPwd) {
        document.getElementById("message").innerHTML = "비밀번호가 일치하지 않습니다.";
        return false;
    } else {
        document.getElementById("message").innerHTML = "비밀번호가 일치하지 않습니다.";
        return true;
    }
});


