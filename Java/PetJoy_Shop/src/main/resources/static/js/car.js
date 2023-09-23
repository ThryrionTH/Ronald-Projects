// Variables 
const carrito = document.querySelector('#carrito');
const contenedorCarrito = document.querySelector('#lista-carrito tbody');
const vaciarCarritoBtn = document.querySelector('#vaciar-carrito');
const listaCursos = document.querySelector('#lista-cursos');
const pagarCarritoBtn = document.querySelector('#pagar-carrito'); // Agrega este botón
let articulosCarrito = [];

cargarEventListeners();
function cargarEventListeners() {
    //"Btn Agregar al carrito"
    listaCursos.addEventListener('click', agregarProducto);

    //Eliminar del carrito
    carrito.addEventListener('click', eliminarProducto);

    //Vaciar el carrito
    vaciarCarritoBtn.addEventListener('click', () => {
        articulosCarrito = []; // Limpiamos arreglo
        carritoHTML();
        toggleBotonesCarrito(); // Ocultar botones después de vaciar el carrito
    });

    // Obtener Sesion
    if (localStorage.getItem("carrito") !== null) {
        articulosCarrito = JSON.parse(localStorage.getItem("carrito"));
    }
    carritoHTML();
    toggleBotonesCarrito(); // Ocultar botones al cargar la página
}

//Funciones
function agregarProducto(e) {
    e.preventDefault();
    if (e.target.classList.contains('agregar-carrito')) {
        const productoSeleccionado = e.target.parentElement.parentElement;
        leerDatosProducto(productoSeleccionado);
        mostrarToast('success', 'Producto agregado al carrito');
        toggleBotonesCarrito(); // Mostrar botones después de agregar un producto
    }
}

// Eliminar producto del carrito
function eliminarProducto(e) {
    if (e.target.classList.contains("borrar-producto")) {
        const productoId = e.target.getAttribute('data-id');

        //Eliminar del arreglo de articulosCarrito por el data-id
        articulosCarrito = articulosCarrito.filter(producto => producto.id !== productoId);
        localStorage.setItem("carrito", JSON.stringify(articulosCarrito));
        carritoHTML(); // Iterar sobre el carrito 
        toggleBotonesCarrito(); // Ocultar botones si se vacía el carrito
    }
}

function leerDatosProducto(producto) {
    const infoProducto = {
        imagen: producto.querySelector('img').src,
        titulo: producto.querySelector('h5').textContent,
        precio: fnRemoverCaracter(producto.querySelector('.precio span').textContent, "$"),
        id: producto.querySelector('#cart-button').getAttribute('data-id'),
        cantidad: 1
    };

    //Revisar si un elemento ya existe en el carrito
    const existe = articulosCarrito.some(producto => producto.id === infoProducto.id);
    if (existe) {
        // Actualiza cantidad
        const productos = articulosCarrito.map(producto => {
            if (producto.id === infoProducto.id) {
                producto.cantidad++;
            }
            return producto;
        });
        articulosCarrito = [...productos];

    } else {
        // Agregamos el item al carrito
        articulosCarrito = [...articulosCarrito, infoProducto];

    }

    localStorage.setItem("carrito", JSON.stringify(articulosCarrito));

    carritoHTML();
}

// Muestra el carrito de compras en el HTML
function carritoHTML() {
    limpiarHTML();
    articulosCarrito.forEach(producto => {
        const {imagen, titulo, precio, cantidad, id} = producto;
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>
                <img src="${imagen}" width="100">
            </td>
            <td>${titulo}</td>
            <td>${formatPrecioColombiano(precio)}</td>
            <td>
                <button class="disminuir-cantidad btn-cantidad" data-id="${id}">-</button>
                <span>${cantidad}</span>
                <button class="aumentar-cantidad btn-cantidad" data-id="${id}">+</button>
            </td>
            <td>
                <a href="#" class="borrar-producto" data-id="${id}"> X </a>
            </td>
        `;

        contenedorCarrito.appendChild(row);
    });

    let total = calcularTotal();
    
    const totalRow = document.createElement('tr');
    totalRow.classList.add('total-carrito');
    totalRow.innerHTML = `
        <td></td>
        <td class="text-end">Total:</td>
        <td colspan="2" class="text-center">${formatPrecioColombiano(total)}</td>
        
    `;
    contenedorCarrito.appendChild(totalRow);
}

// Calcula el total de los productos en el carrito
function calcularTotal() {
    return articulosCarrito.reduce((total, producto) => {
        return total + (producto.precio * producto.cantidad);
    }, 0);
}

function limpiarHTML() {
    while (contenedorCarrito.firstChild) {
        contenedorCarrito.removeChild(contenedorCarrito.firstChild);
    }
}

function fnRemoverCaracter(valor, caracter) {
    if (valor.indexOf(caracter) !== -1) {
        return valor.replace(caracter, "");
    }
    return valor;
}

function formatPrecioColombiano(precio) {
    const formatter = new Intl.NumberFormat('es-CO', {
        style: 'currency',
        currency: 'COP', 
        minimumFractionDigits: 0,
    });
    return formatter.format(precio);
}

contenedorCarrito.addEventListener('click', (e) => {
    if (e.target.classList.contains('aumentar-cantidad')) {
        const productoId = e.target.getAttribute('data-id');
        aumentarCantidad(productoId);
    }
    if (e.target.classList.contains('disminuir-cantidad')) {
        const productoId = e.target.getAttribute('data-id');
        disminuirCantidad(productoId);
    }
});

function aumentarCantidad(id) {
    articulosCarrito = articulosCarrito.map(producto => {
        if (producto.id === id) {
            producto.cantidad++;
        }
        return producto;
    });
    localStorage.setItem("carrito", JSON.stringify(articulosCarrito));
    carritoHTML();
}

function disminuirCantidad(id) {
    articulosCarrito = articulosCarrito.map(producto => {
        if (producto.id === id && producto.cantidad > 1) {
            producto.cantidad--;
        }
        return producto;
    });
    localStorage.setItem("carrito", JSON.stringify(articulosCarrito));
    carritoHTML();
}

function mostrarToast(icon, message) {
    Swal.fire({
        icon: icon,
        text: message,
        showConfirmButton: false,
        timer: 1000,
        position: 'top-end',
        toast: true,
        timerProgressBar: true,
        customClass: {
            container: 'position-fixed bottom-0 end-0 p-3',
            title: 'me-auto',
        }
    });
}

// Función para mostrar u ocultar botones según el contenido del carrito
function toggleBotonesCarrito() {
    if (articulosCarrito.length === 0) {
        // Si el carrito está vacío, ocultar los botones
        vaciarCarritoBtn.style.display = 'none';
        pagarCarritoBtn.style.display = 'none';
    } else {
        // Si el carrito tiene productos, mostrar los botones
        vaciarCarritoBtn.style.display = 'inline-block';
        pagarCarritoBtn.style.display = 'inline-block';
    }
}
