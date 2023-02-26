// Defines global constants.
var GET = "GET";
var POST = "POST";
var NEW_LINE = "\n";
var INPUT = "input";
var CLICK = "click";
var ASYNCHRONOUS = true;
var CONTENT_TYPE = "Content-type";
var DOM_CONTENT_LOADED = "DOMContentLoaded";
var APPLICATION_JSON = "application/json;charset=UTF-8";
// Defines global container.
var container = new Object();
container["http"] = new XMLHttpRequest();
container["baseUrl"] = "http://localhost:8080";

function sendNameAndAge() {
    let name = document.getElementById("name").value;
    let age = document.getElementById("age").value;
    request = {
        name : name,
        age : age
    }
    let url = "http://localhost:8080/week2/post";
    httpPost(url, request, function(response) {
    	alert(prettyJsonString(response));
    });
}

function copy(element) {
	let value = element.value;
	if (value != null && value != "") {
		navigator.clipboard.writeText(value);
	}
}

function arrayToString(array, separator, addNewLine) {
	let result = "";
	if (array == null) {
		return result;
	}
	let length = array.length;
	for (let [i, element] of array.entries()) {
		result += element;
		if (i < length - 1) {
			result += separator;
			if (addNewLine) {
				result += NEW_LINE;
			}
		}
	}
	return result;
}

function stringToArray(string, separator) {
	let result = [];
	if (string == null) {
		return result;
	}
	string = string.replace("\n", "");
	if (string.length == 0) {
		return result;
	}
	if (!string.includes(separator)) {
		result.push(string);
		return result;
	}
	for (let element of string.split(separator)) {
		result.push(element.trim());
	}
	return result;
}

function maxValueInJsObject(object) {
	return Math.max(...objectToMap(object).values());
}

function minValueInJsObject(object) {
	return Math.min(...objectToMap(object).values());
}

function objectToMap(object) {
	return new Map(Object.entries(object));
}

function clearMessage() {
	document.getElementById("message").textContent = "Message to be Displayed";
}

function messageConsumer(response) {
	document.getElementById("message").textContent = prettyJsonString(response);
}

function nonemptyIdValue(id) {
	let valid = false;
	let value = idValue(id);
	if (isEmpty(value)) {
		setIdValue(id, "Null Disallowed");
		return {value, valid};
	} else {
		valid = true;
		return {value, valid};
	}
}

function listen(eventName, consumer) {
	document.addEventListener(eventName, function(event) {
		let element = event.target;
		consumer(element);
	}, null);
}

function ready(supplier) {
	document.addEventListener(DOM_CONTENT_LOADED, supplier, null);
}

function synchronousHttpPost(url, request, consumer) {
	executeHttpPost(url, request, consumer, !ASYNCHRONOUS);
}

function httpPost(url, request, consumer) {
	executeHttpPost(url, request, consumer, ASYNCHRONOUS);
}

function executeHttpPost(url, request, consumer,
	asynchronous) {
	let http = container.http;
	http.onload = function() {
		consumer(JSON.parse(this.responseText));
	}
	http.open(POST, url, asynchronous);
	http.setRequestHeader(CONTENT_TYPE, APPLICATION_JSON);
	http.send(typeof(request) === "string" ? request : JSON.stringify(request));
}

function synchronoushttpGet(url, consumer) {
	executeHttpGet(url, consumer, !ASYNCHRONOUS);
}

function httpGet(url, consumer) {
	executeHttpGet(url, consumer, ASYNCHRONOUS);
}

function executeHttpGet(url, consumer, asynchronous) {
	let http = container.http;
	http.onload = function() {
		consumer(JSON.parse(this.responseText));
    }
  	http.open(GET, url, asynchronous);
  	http.send();
}

function prettyJsonString(object) {
	return JSON.stringify(object, null, 2);
}

function clearValue(element) {
	element.value = "";
}

function setIdImage(id, base64String, extension) {
	let value = "data:image/" + extension + ";base64," + base64String;
	document.getElementById(id).src = value;
}

function setIdEmpty(id) {
	setIdValue(id, "");
}

function setIdValue(id, value) {
	document.getElementById(id).value = value;
}

function idFloat(id) {
	let value = idValue(id);
	if (isEmpty(value)) {
		return null;
	}
	return parseFloat(value);
}

function idInt(id) {
	let value = idValue(id);
	if (isEmpty(value)) {
		return null;
	}
	return parseInt(value);
}

function isEmpty(value) {
	return value === null || value === undefined || value === "";
}

function idValue(id) {
	return document.getElementById(id).value;
}

// Enable this debugging tool by setting http.onreadystatechange = detectReadyStateChange
function detectReadyStateChange() {
	let readyState = http.readyState;
	if (readyState === XMLHttpRequest.OPENED) {
		alert(XMLHttpRequest.OPENED + " OPENED");// 1
	} else if (readyState === XMLHttpRequest.HEADERS_RECEIVED) {
		alert(XMLHttpRequest.HEADERS_RECEIVED + " HEADERS_RECEIVED");// 2
	} else if (readyState === XMLHttpRequest.LOADING) {
		alert(XMLHttpRequest.LOADING + " LOADING");// 3
	} else if (readyState === XMLHttpRequest.DONE) {
		alert(XMLHttpRequest.DONE + " DONE");// 4
	} else if (readyState === XMLHttpRequest.UNSENT) {
		alert(XMLHttpRequest.UNSENT + " UNSENT");// 0
	}
}

// Enable this debugging tool within call back function http.onload
function detectStatus() {
	let status = http.status;
	let statusText = http.statusText;
    if (status == 0 || 200 <= status && status < 400) {
		alert(status + " SUCCESS " + statusText);
	} else {
		alert(status + " FAILURE " + statusText);
	}
}

function replace(string, oldCharacter, newCharacter) {
	let result = "";
	for (let character of string) {
		if (character == oldCharacter) {
			result += newCharacter;
		} else {
			result += character;
		}
	}
	return result;
}