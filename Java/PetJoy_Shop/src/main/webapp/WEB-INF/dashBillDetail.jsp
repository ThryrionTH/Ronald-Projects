<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
                crossorigin="anonymous">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
            <link rel="stylesheet" href="/css/style.css">
            <link rel="shortcut icon" href="/img/favicon.png">
            <title>Facturas | Panel Administración</title>
        </head>

        <body id="body-dashboard">

            <%@ include file="./layouts/aside.jsp" %>

                <div class="container-all">
                    <header class="bill-header"></header>

                    <div class="container col-10 my-4 px-4 mx-auto">

                        <!-- <img src="/img/default.png" alt="Logo PetJoyBundler" class="bill-logo"> -->

                        <div class="d-flex align-items-center detail mb-4">
                            <div class="me-5">
                                <h4>Datos del cliente</h4>
                                <p><b>Nombre:</b> ${factura.cliente.nombre} ${factura.cliente.apellido}</p>
                                <p><b>Dirección:</b> ${factura.cliente.direccion}</p>
                                <p><b>Correo electrónico:</b> ${factura.cliente.email}</p>
                                <p><b>Teléfono:</b> ${factura.cliente.celular}</p>
                            </div>

                            <div class="ms-5"> 
                                <p><b>N° Factura:</b> ${factura.codigo}</p>
                                <p><b>Fecha facturación:</b> ${factura.createdAt}</p>
                                <p><b>N° Cliente:</b> ${factura.cliente.id}</p>
                            </div>
                        </div>
                        <table class="table">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col" class="text-center">Código producto</th>
                                    <th scope="col">Descripción</th>
                                    <th scope="col" class="text-center">Cantidad</th>
                                    <th scope="col" class="text-center">Precio</th>
                                    <th scope="col" class="text-center">Total</th>
                                </tr>
                            </thead>
                            <tbody class="table-group-divider">
                                <c:forEach items="${factura.pedidos}" var="pedido">
                                    <tr>
                                        <td class="text-center">${pedido.producto.codigo}</td>
                                        <td>${pedido.producto.nombre}</td>
                                        <td class="text-center">${pedido.cantidad}</td>
                                        <td class="text-center"><fmt:formatNumber value="${pedido.producto.precio}" type="currency" currencyCode="COP" pattern="¤ #,##0"/></td>
                                        <td class="text-center"><fmt:formatNumber value="${pedido.cantidad * pedido.producto.precio}" type="currency" currencyCode="COP" pattern="¤ #,##0"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <div class="col-4 float-end">
                            <table class="table text-center">
                                <tbody class="table-group-divider">
                                    <tr>
                                        <th>Subtotal</th>
                                        <td><fmt:formatNumber value="${factura.total}" type="currency" currencyCode="COP" pattern="¤ #,##0"/></td>
                                    </tr>
                                    <tr>
                                        <th class="bg-dark text-white">TOTAL</th>
                                        <td class="bg-dark text-white"><fmt:formatNumber value="${factura.total}" type="currency" currencyCode="COP" pattern="¤ #,##0"/></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <footer class="bill-footer bg-green text-center py-2">
                        <strong>¿Alguna pregunta?</strong>
                        <p>Envíanos un correo a support@petjoybundler.com o llámanos al (601) 123456</p>
                    </footer>
                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
                    crossorigin="anonymous">
                    </script>
                <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
                <script src="/js/deleteAlert.js"></script>
        </body>

        </html>