function submit() {
    let name = document.getElementById("name").value;
    let gender = document.getElementById("gender").value;
    let age = document.getElementById("age").value;
    let request = {
        name : name,
        gender : gender,
        age : age
    };
    post("http://localhost:8080/post", request, true, response => {
        let message = response.message;
        alert(message);
        document.getElementById("message").textContent = message;
    });
}

function countUsers() {
    get("http://localhost:8080/get", true, response => {
        document.getElementById("message").textContent = "Number of Users: " + response.userCount;
    });
}

function clearAll() {
    document.getElementById("name").value = "";
    document.getElementById("gender").value = "";
    document.getElementById("age").value = "";
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