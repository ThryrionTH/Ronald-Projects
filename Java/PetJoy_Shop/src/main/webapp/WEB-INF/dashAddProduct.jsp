<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
    <title>Agregar producto | Panel Administración</title>
</head>

<body id="body-dashboard">
    
    <%@ include file="./layouts/aside.jsp"%>

    <div class="container-all dash-add">
        <div class="container mt-4 mb-4 col-9">
            <h2 class="ml-green mb-4">Agregar producto</h2>
            <form:form action="/dashboard/add" modelAttribute="product" enctype="multipart/form-data" class="mt-4">
                <div class="col-md-8">
                    <div class="card-body d-flex align-items-center">
                        <div id="image-preview-container" class="col-md-8">
                            <div id="image-preview-placeholder" class="gray-bg">
                                <i class="bi bi-image"></i>
                            </div>
                            <img id="preview-image" src="" alt="Imagen previa" style="display: none">
                        </div>
                        <input type="file" id="imagenFile" name="imagenFile" accept="image/*" style="display: none;"
                            onchange="previewImage(this)" />
                        <label for="imagenFile" id="custom-file-button" class="btn btn-dark ms-5">
                            Seleccionar Imagen
                        </label>
                    </div>
                </div>
                <div class="d-flex justify-content-between">
                <div class="my-3 col-7">
                    <small><label for="nombre" class="form-label">Nombre</label></small>
                    <form:input type="text" path="nombre" cssClass="form-control" id="nombre"/>
                    <form:errors path="nombre" class="text-danger d-block text-end error"/>
                </div>
                <div class="my-3 container p-0 ms-4">
                    <small><label for="codigo" class="form-label">Código</label></small>
                    <form:input type="text" path="codigo" cssClass="form-control" id="codigo"/>
                    <form:errors path="codigo" class="text-danger d-block text-end error"/>
                </div></div>
                <div class="d-flex justify-content-between">
                    <div class="col-7 mb-3">
                        <small><label for="precio" class="form-label">Precio</label></small>
                        <form:input type="number" path="precio" cssClass="form-control" id="precio"/>
                        <form:errors path="precio" class="text-danger d-block text-end error"/>
                    </div>
                    <div class="container p-0 ms-4 mb-3">
                        <small><label for="stock" class="form-label">Stock</label></small>
                        <form:input type="number" path="stock" cssClass="form-control" id="stock"/>
                        <form:errors path="stock" class="text-danger d-block text-end error"/>
                    </div>
                </div>

                <div class="d-flex justify-content-between">
                <div class="container p-0 me-2">
                <small><label for="marca_producto">Marca | <a href="/dashboard/brands">Adicionar</a> </label></small>
                <form:select path="marca_producto.id" class="form-control mb-3">
                    <form:option value="">-- Seleccione una marca --</form:option>
                    <c:forEach items="${productsBrands}" var="brand">
                        <form:option value="${brand.id}">
                            <c:out value="${brand.nombremarca}" />
                        </form:option>
                    </c:forEach>
                </form:select><form:errors path="marca_producto.id" class="text-danger d-block text-end error"/></div>

                <div class="container p-0 mx-2">
                <small><label for="producto_animal">Animal | <a href="/dashboard/animals">Adicionar</a> </label></small>
                <form:select path="producto_animal.id" class="form-control mb-3">
                    <form:option value="">-- Seleccione un animal --</form:option>
                    <c:forEach items="${productsAnimals}" var="animal">
                        <form:option value="${animal.id}">
                            <c:out value="${animal.animal}" />
                        </form:option>
                    </c:forEach>
                </form:select></div>

                <div class="container p-0 ms-2">
                <small><label for="tipo_producto">Categoría | <a href="/dashboard/categories">Adicionar</a> </label></small>
                <form:select path="tipo_producto.id" class="form-control mb-3">
                    <form:option value="">-- Seleccione una categoría --</form:option>
                    <c:forEach items="${productsTypes}" var="type">
                        <form:option value="${type.id}">
                            <c:out value="${type.categoria}" />
                        </form:option>
                    </c:forEach>
                </form:select></div></div>

                <div class="d-flex justify-content-between">
                    <div class="container me-2 mb-3 p-0">
                        <small><label for="fechaElaboracion" class="form-label">Fecha elaboración</label></small>
                        <form:input type="date" path="fechaElaboracion" cssClass="form-control" id="fechaElaboracion"/>
                    </div>
                    <div class="container ms-2 mb-3 p-0">
                        <small><label for="fechaVencimiento" class="form-label">Fecha vencimiento</label></small>
                        <form:input type="date" path="fechaVencimiento" cssClass="form-control" id="fechaVencimiento"/>
                    </div>
                </div>

                <div class="mb-4">
                    <small>Descripción</small>
                    <form:textarea path="descripcion" cssClass="form-control" aria-label="description"/>
                    <form:errors path="descripcion" class="text-danger d-block text-end error"/>
                </div>
                <div class="mt-4 d-flex justify-content-end">
                    <a href="/dashboard" type="button" class="btn btn-dark me-4">Cancelar</a>
                    <button type="submit" class="btn btn-success">Agregar producto</button>
                </div>
            </form:form>
        </div>

    </div>

    <script src="/js/imagePreview.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous">
    </script>

</body>

</html>