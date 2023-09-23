function Alert(message) {
    alert(message);
}

var pageAlert = {
    "/date": "This is the date template",
    "/time": "This is the time template"
};

var currentPath = window.location.pathname;
var message = pageAlert[currentPath];

if (message) {
    showAlert(message);
}
