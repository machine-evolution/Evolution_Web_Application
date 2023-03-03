function submit() {
    let id = document.getElementById("id").value;
    let password = document.getElementById("password").value;
    let name = document.getElementById("name").value;
    let gender = document.getElementById("gender").value;
    // let age = 参照上面姓名(name)的获取方式，获取年龄(age)
    // let education = 参照上面性别(gender)的获取方式，获取学历(education)
    get("http://localhost:8080/checkId", true, checkIdResponse => {
        let idValid = checkIdResponse.valid;// 用户ID是否有效
        if (idValid) {
            let registerRequest = {
                id : id,
                password : password,
                name : name,
                gender : gender,
                // 年龄(age)需要传
                // 学历(education)需要传
                // 请注意逗号的细节问题
            };
            post("http://localhost:8080/register", registerRequest, true, registerResponse => {
                let message = registerResponse.message;
                document.getElementById("message").textContent = message;
            });
        } else {
            document.getElementById("message").textContent = checkIdResponse.message;
        }
    });
}

function clearAll() {
    document.getElementById("id").value = "";
    document.getElementById("password").value = "";
    document.getElementById("name").value = "";
    document.getElementById("gender").value = "";
    // 参照上边四行代码，将年龄(age)清除
    // 参照上边四行代码，将学历(education)清除
    document.getElementById("message").textContent = "";
}

function post(url, request, asynchronous, consumer) {
	let http = new XMLHttpRequest();
	http.open("POST", url, asynchronous);
	http.setRequestHeader("Content-type", "application/json;charset=UTF-8");
	http.onload = function() {
    	consumer(JSON.parse(this.responseText));
    }
	http.send(JSON.stringify(request));
}

function get(url, asynchronous, consumer) {
    let http = new XMLHttpRequest();
    http.open("GET", url, asynchronous);
    http.onload = function() {
        consumer(JSON.parse(this.responseText));
    }
    http.send();
}