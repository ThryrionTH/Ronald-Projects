let carrito = [];
let total = 0;
let pagina = 1;

let datos = {
    nombre: '',
    apellido: '',
    documento: '',
    telefono: '',
    correo: '',
    ciudad: '',
    municipio: '',
    direccion: '',
    descripcion: '',
    entrega: 1,
    items_cantidad: '',
    items_id: ''
};


function fnObtenerSesion() {
    if (localStorage.getItem("carrito") !== null && localStorage.getItem("carrito") !== undefined) {
        carrito = JSON.parse(localStorage.getItem("carrito"));
    } else {
        window.location.href = "/";
    }
}


function fnVisualizarBloque(bloque) {
    document.getElementById("bloque1").style.display = 'none';
    document.getElementById("bloque2").style.display = 'none';
    document.getElementById("bloque3").style.display = 'none';

    pagina = bloque;

    if (bloque === 1) {
        document.getElementById("bloque1").style.display = 'block';
    } else if (bloque === 2) {
        document.getElementById("bloque2").style.display = 'block';
    } else {
        document.getElementById("bloque3").style.display = 'block';
    }
}

function fnValidarBloque(bloque) {
    // BLOQUE 1
    datos.nombre = document.getElementById("nombre").value.trim();
    datos.apellido = document.getElementById("apellido").value.trim();
    datos.documento = document.getElementById("documento").value.trim();
    datos.telefono = document.getElementById("telefono").value.trim();
    datos.correo = document.getElementById("correo").value.trim();

    // BLOQUE 2
    datos.ciudad = document.getElementById("ciudad").value.trim();
    datos.municipio = document.getElementById("municipio").value.trim();
    datos.direccion = document.getElementById("direccion").value.trim();
    datos.descripcion = document.getElementById("descripcion").value.trim();

    // BLOQUE 3
    var numero = document.getElementById("tarjeta").value.trim();
    var fecha = document.getElementById("fecha_vencimiento").value.trim();
    var cvv = document.getElementById("cvv").value.trim();

    var bloqAnt = bloque - 1;

    if (bloqAnt === 1) {
        /*
         * // Se elimina la validacion por cliente logeado
         if (datos.nombre.length === 0) {
            Info("El campo nombre es requerido");
            return false;
        } else if (!(datos.nombre.length >= 3 && datos.nombre.length <= 40)) {
            Info("El campo nombre debe contener 3 a 40 caracteres");
            return false;
        }

        if (datos.apellido.length === 0) {
            Info("El campo apellido es requerido");
            return false;
        } else if (!(datos.apellido.length >= 3 && datos.apellido.length <= 40)) {
            Info("El campo apellido debe contener 3 a 40 caracteres");
            return false;
        }


        if (datos.documento.length === 0) {
            Info("El campo documento es requerido");
            return false;
        } else if (!(datos.documento.length >= 7 && datos.documento.length <= 13)) {
            Info("El campo documento debe contener 7 a 13 digitos");
            return false;
        }

        if (datos.telefono.length === 0) {
            Info("El campo telefono es requerido");
            return false;
        } else if (!(datos.documento.length >= 9 && datos.documento.length <= 15)) {
            Info("El campo documento debe contener 9 a 15 digitos");
            return false;
        }


        if (datos.correo.length === 0) {
            Info("El campo correo electronico es requerido");
            return false;
        } 
          
         */

    } else if (bloqAnt === 2) {
        if (datos.entrega === 1) {
            if (datos.ciudad.length === 0) {
                Info("El campo ciudad es requerido");
                return false;
            }
            if (datos.municipio.length === 0) {
                Info("El campo municipio es requerido");
                return false;
            }
            if (datos.direccion.length === 0) {
                Info("El campo direccion es requerido");
                return;
            }

            if (datos.descripcion.length === 0) {
                Info("El campo descripción es requerido");
                return false;
            }
        }
    } else if (bloqAnt === 3) {
        if (numero.trim().length === 0) {
            Info("El numero de tarjeta es requerido");
            return false;
        } else if (!(/^[0-9]+$/).test(numero)) {
            Info("El numero de tarjeta debe contener solo números");
            return false;
        }

        if (fecha.trim().length === 0) {
            Info("La fecha es requerido es requerido");
            return false;
        } else if (!(/^\d{2}\/\d{2}$/).test(fecha)) {
            Info("El Formato correcto de la fecha de vencimiento debe ser: mm/yy , ejem: 07/29");
            return false;
        }

        if (cvv.trim().length === 0) {
            Info("El cvv es requerido");
            return false;
        } else if (!(/^[0-9]+$/).test(cvv)) {
            Info("El cvv debe contener solo números");
            return false;
        } else if (cvv.length !== 3) {
            Info("El cvv debe contener 3 digitos");
            return false;
        }
    }

    if (bloqAnt !== 3) {
        fnVisualizarBloque(bloque);
    }

    return true;
}

function fnListarCarrito() {
    var row = "";

    total = 0;

    for (const item of carrito) {
        row += `
         <tr>
            <td style='width: 30px;'>
                <img src="${item.imagen}" width="100">
            </td>
            <td>${item.titulo}</td>
            <td>${formatPrecio(item.cantidad * item.precio)}</td>
            </tr>
        `;
        total += item.cantidad * item.precio;
    }

    document.getElementById("list_checkout").innerHTML = row;
    document.getElementById("lblTotal").innerHTML = "$" + total;
}

function fnEfectuarPago() {
    var valBloque3 = fnValidarBloque(4);
    var separador = ";";
    if (valBloque3) {
        datos.items_cantidad = "";
        datos.items_id = "";

        for (const item of carrito) {
            datos.items_id += fnRemoverCaracter(item.id, "$") + separador;
            datos.items_cantidad += item.cantidad + separador;
        }

        datos.items_id = datos.items_id.substring(0, datos.items_id.length - 1);
        datos.items_cantidad = datos.items_cantidad.substring(0, datos.items_cantidad.length - 1);

        $.ajax({
            type: "get",
            url: "/checkout-save",
            data: datos,
            success: function (response) {
                if (response === "OK") {
                    Success("Felicidades! Su pedido se procesó de forma correcta.");
                    document.getElementById("btnEfectuarPago").disabled = true;
                    localStorage.removeItem("carrito");

                    setTimeout(() => {
                        window.location.href = "/";
                    }, 5000);
                } else {
                    Info(response);
                }
            },
            error: function (xhr, status, errorThrown) {
                Info("Error!, No se pudieron procesar los datos.");
                console.dir(xhr);
            }
        });
    }
}

function fnRemoverCaracter(valor, caracter) {
    if (valor.indexOf(caracter) !== -1) {
        return valor.replace(caracter, "");
    }
    return valor;
}

function fnSeleccionarEntrega(opcion) {
    document.getElementById("bloqueSel1").style.display = 'none';
    document.getElementById("bloqueSel2").style.display = 'none';
    document.getElementById("bloque_sec1").style.display = 'none';

    datos.entrega = opcion;

    if (opcion === 1) {
        document.getElementById("bloqueSel1").style.display = 'block';
        document.getElementById("bloque_sec1").style.display = 'block';
    } else {
        document.getElementById("bloqueSel2").style.display = 'block';
    }

}

function fnVolverAtras(anterior) {
    if (anterior !== pagina && anterior < pagina) {
        document.getElementById("bloque" + anterior).style.display = 'block';
        document.getElementById("bloque" + pagina).style.display = 'none';

        pagina = anterior;
    }
}

function fnInit() {
    fnObtenerSesion();
    fnListarCarrito();
    fnVisualizarBloque(pagina);
    fnSeleccionarEntrega(1);
    document.getElementById("btnProdCart").disabled = true;
}
fnInit();

function formatPrecio(precio) {
    const formatter = new Intl.NumberFormat('es-CO', {
        style: 'currency',
        currency: 'COP',
        minimumFractionDigits: 0, 
    });
    return formatter.format(precio);
}