document.addEventListener("DOMContentLoaded", function () {
    var previewImage = document.getElementById("preview-image");
    var imageIcon = document.getElementById("image-icon");

    // Verificar si product.imagen está vacío
    if (!previewImage.getAttribute("src")) {
        imageIcon.style.display = "none";
    }
});

document.getElementById("imagenFile").addEventListener("change", function () {
    previewImage(this);
    updateCustomFileButtonText();
});

// Función para mostrar la previsualización de la imagen
function previewImage(input) {
    var previewImage = document.getElementById("preview-image");
    var previewPlaceholder = document.getElementById("image-preview-placeholder");

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            previewImage.src = e.target.result;
            previewImage.style.display = "block";
            previewPlaceholder.style.display = "none";
        };

        reader.readAsDataURL(input.files[0]);
    } else {
        previewImage.src = "";
        previewImage.style.display = "none";
        previewPlaceholder.style.display = "block";
    }
}

// Función para actualizar el texto del botón personalizado
function updateCustomFileButtonText() {
    var customFileButton = document.getElementById("custom-file-button");

    if (document.getElementById("imagenFile").files.length > 0) {
        customFileButton.textContent = "Cambiar Imagen";
    } else {
        customFileButton.textContent = "Seleccionar Imagen";
    }
}
