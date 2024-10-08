function login(){
    var email = document.getElementById("emailInput").value;
    var password = document.getElementById("passwordInput").value;
    if (email == null || email === ''){
        alert("请输入邮箱")
    }else {
        if (password == null || password === ''){
            alert("请输入密码")
        }
    }

    $.ajax({
        type: "POST",
        url: "/login",
        contentType: "application/json",
        data: JSON.stringify({
            "email": email,
            "password": password
        }),
        success: function (response) {
            if (response.code === 200) {
                window.location.href = "/";
            }else {
                alert(response.message);
            }
        },
        dataType: "json"
    });
}