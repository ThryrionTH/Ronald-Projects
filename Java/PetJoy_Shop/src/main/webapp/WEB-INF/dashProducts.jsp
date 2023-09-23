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
    <link href="https://cdn.jsdelivr.net/npm/aos@2.3.4/dist/aos.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="shortcut icon" href="/img/favicon.png">
    <title>Productos | Panel Administración</title>
</head>

<body id="body-dashboard">
    
    <%@ include file="./layouts/aside.jsp"%>

    <div class="container-all">
        
        <!-- Productos-->
        <div class="container mt-5 mb-5 px-4">
            <div>

                <div class="d-flex justify-content-between mb-4">
                    <a href="/dashboard/add" type="button" class="btn btn-success me-4">
                        <i class="bi bi-file-earmark-plus-fill me-1"></i> Agregar producto 
                    </a>
                
                    <!-- Formulario de búsqueda -->
                    <form class="d-flex col-md-3" action="${pageContext.request.contextPath}/buscar-producto" method="GET">
                        <input class="form-control me-2" type="search" name="nombreProducto" placeholder="Buscar producto"
                            aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Buscar</button>
                    </form>
                
                </div>

                <!-- Productos-->
                <div>
                    <div class="d-flex flex-wrap justify-content-between">
                        <c:forEach items="${products}" var="product" varStatus="status">
                            <div class="card m-1 card-product" data-aos="fade-up">
                                <div class="card-header d-flex justify-content-center align-self-cente" id="container-img">
                                    <img src="/img/products/${product.imagen}" alt="${product.nombre}" height="150px" loading="lazy">
                                    <button type="button" class="btn btn-secondary modal-product"
                                        data-bs-toggle="modal" data-bs-target="#modalProduct-${status.index}">
                                        <i class="bi bi-search"></i>
                                    </button>
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">${product.nombre}</h5>
                                    <fmt:formatNumber value="${product.precio}" type="currency" currencyCode="COP" pattern="¤ #,##0"/>
                                </div>
                                <div class="card-footer d-flex justify-content-between">
                                    <form action="/dashboard/${product.id}/delete" method="post" class="delete-form">
                                    <input type="hidden" name="_method" value="delete">
                                    <a href="/dashboard/${product.id}/edit" class="btn btn-dark"><i class="bi bi-pencil-square me-2"></i>Editar</a>
                                    <button type="button" class="btn btn-danger" onclick="confirmDelete(this)"> 
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                        <i class="bi bi-trash3-fill me-2"></i>Eliminar
                                    </button>
                                </form>
                                </div>
                            </div>

                            <!-- Modal -->
                            <div class="modal fade" id="modalProduct-${status.index}" tabindex="-1"
                                aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">
                                                ${product.nombre}
                                            </h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="mb-3" style="max-width: 540px;">
                                                <div class="row g-0">
                                                    <div class="col-md-5 d-flex align-items-center">
                                                        <img src="/img/products/${product.imagen}"
                                                            class="img-fluid rounded-start"
                                                            alt="${producto.nombre}" width="80%" loading="lazy">
                                                    </div>
                                                    <div class="col-md-7">
                                                        <div class="card-body">
                                                            <h5 class="card-title">${product.nombre}</h5>
                                                            <p class="card-text"><small
                                                                    class="text-body-secondary">Código de
                                                                    producto: ${product.codigo}</small></p>
                                                                    <fmt:formatNumber value="${product.precio}" type="currency" currencyCode="COP" pattern="¤ #,##0"/>
                                                            <hr width="215px">
                                                        </div>
                                                    </div>
                                                    <p class="mt-4">${product.descripcion}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary"
                                                data-bs-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                </c:forEach>
            </div>
        </div>
    </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="/js/deleteAlert.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/aos@2.3.4/dist/aos.js"></script>
        <script>
            AOS.init();
        </script>
</body>

</html>