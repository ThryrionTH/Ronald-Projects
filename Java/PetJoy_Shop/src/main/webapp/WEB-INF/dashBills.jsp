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
            <title>Detalle Factura | Panel Administración</title>
        </head>

        <body id="body-dashboard">

            <%@ include file="./layouts/aside.jsp" %>

                <div class="container-all bill-container">
                
                    <div class="container mt-5 mb-5 px-4">

                        <h2 class="ml-green mb-4">Facturas</h2>

                    <table class="table table-bordered table-responsive table-striped">
                        <thead>
                            <tr>
                                <th class="text-center">Código Factura</th>
                                <th class="text-center">Cliente</th>
                                <th class="text-center">Fecha</th>
                                <th class="text-center">Tipo de Entrega</th>
                                <th class="text-center">Forma Pago</th>
                                <th class="text-center">Total</th>
                                <th class="text-center"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${allBills}" var="factura" varStatus="status">
                                <tr>
                                    <td class="text-center">${factura.codigo}</td>
                                    <td >${factura.cliente.nombre} ${factura.cliente.apellido}</td>
                                    <td class="text-center">${factura.fecha}</td>
                                    <td class="text-center">${factura.tipoEntrega}</td>
                                    <td class="text-center">${factura.forma_pago.descripcion}</td>
                                    <td class="text-center">                                    <fmt:formatNumber value="${factura.total}" type="currency" currencyCode="COP" pattern="¤ #,##0"/></td>
                                    <td class="text-center">
                                        <a href="/dashboard/bills/${factura.id}" class="btn btn-dark">
                                            <i class="fa fa-info-circle"></i> Ver Detalle
                                        </a>
                                </tr>
                            </c:forEach>
                            <c:if test="${facturas.size() == 0}">
                                <tr>
                                    <td colspan="6" class="text-center">No hay datos</td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
            
                    </div>
                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
                    crossorigin="anonymous">
                    </script>
                <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
                <script src="/js/deleteAlert.js"></script>
        </body>

        </html>