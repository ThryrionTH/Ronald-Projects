<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
    <title>Categorías | Panel Administración</title>
</head>

<body id="body-dashboard">

    <%@ include file="./layouts/aside.jsp"%>

    <div class="container-all bg-categories">
        <main class="container mt-5 mb-5 px-4">
            <h2 class="ml-green mb-3">Categorías de productos</h2>
            <nav aria-label="breadcrumb" class="d-flex justify-content-center">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/dashboard" class="text-decoration-none">Lista de productos</a></li>
                    <li class="breadcrumb-item"><a href="/dashboard/add" class="text-decoration-none">Agregar producto</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Categorías de producto</li>
                </ol>
            </nav>
            <form:form action="" method="post" modelAttribute="productType" class="d-flex flex-column justify-content-between col-7 m-auto">
                <div class="p-0 m-0 mb-4">
                    <div class="card-body">
                        <div>
                            <small><label for="imagen" class="form-label">Imagen</label></small>
                            <form:input type="text" path="imagen" cssClass="form-control" id="imagen"/>
                            <form:errors path="imagen" class="text-danger d-block text-end error"/>
                        </div>
                    </div>
                </div>
                <div class="p-0 m-0 mb-4">
                    <small><form:label path="categoria" class="form-label">Nombre de categoría de producto</form:label></small>
                    <form:input path="categoria" class="form-control"/>
                    <form:errors path="categoria" class="text-danger d-block text-end error"/>
                </div>
                <button type="submit" class="btn btn-dark col-2">Agregar</button>
            </form:form>
            <ul class="list-categories col-7 d-flex justify-content-between flex-wrap">
                <c:forEach items="${productsTypes}" var="type" varStatus="loop">
                    <li class="list-item d-flex align-items-center">
                        <img src="${type.imagen}" class="img-type" alt="${type.categoria}">
                        <p class="m-0 ms-4"><c:out value="${type.categoria}" /></p>
                    </li>
                    <form action="/dashboard/categories/${type.id}/delete" method="post" class="delete-form">
                        <input type="hidden" name="_method" value="delete">
                        <button type="button" class="btn btn-dark" data-bs-toggle="modal"
                                data-bs-target="#modalEdicion-${loop.index}" data-animal="${type.categoria}">
                                <i class="bi bi-pencil-square"></i>
                        </button>
                        <button type="button" class="btn btn-danger delete-button" onclick="confirmDelete(this)">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <i class="bi bi-trash3-fill"></i>
                        </button>
                    </form>

                    <!-- Modal Edición -->
                    <div class="modal fade" id="modalEdicion-${loop.index}" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">
                                        ${type.categoria} - Edición
                                    </h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form:form action="/dashboard/categories/${type.id}/editProductType" modelAttribute="productType"
                                        method="post" class="mt-4">
                                        <input type="hidden" name="_method" value="put">
                                        <div class="col-md-8">
                                            <div class="card-body">
                                                <div>
                                                    <small><label for="imagen" class="form-label">Imagen de categoría de producto</label></small>
                                                    <form:input type="text" path="imagen" cssClass="form-control" id="categoria"
                                                        value="${type.imagen}" />
                                                    <form:errors path="imagen" class="text-danger d-block error" />
                                                </div>
                                                <div>
                                                    <small><label for="categoria" class="form-label">Nombre de categoría de producto</label></small>
                                                    <form:input type="text" path="categoria" cssClass="form-control" id="categoria"
                                                        value="${type.categoria}" />
                                                    <form:errors path="categoria" class="text-danger d-block error" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer mt-4">
                                            <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Cancelar</button>
                                            <button type="submit" class="btn btn-success" data-bs-dismiss="modal">Guardar cambios</button>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </ul>
        </main>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="/js/deleteAlert.js"></script>

</body>

</html>
