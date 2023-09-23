<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <link rel="stylesheet" href="./css/style.css">
        <link rel="shortcut icon" href="/img/favicon.png">
        <title>Registro</title>
    </head>

    <body>
        <%@ include file="./layouts/navbar.jsp"%>
    <!-- Carrito de compras -->
    <div class="offcanvas offcanvas-end" width="500px" tabindex="-1" id="offcanvasRight"
         aria-labelledby="offcanvasRightLabel">
        <div class="offcanvas-header" id="lista-cursos">
            <h5 class="offcanvas-title" id="offcanvasRightLabel">Carrito de
                compras</h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas"
                    aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <jsp:include page="layouts/carrito.jsp"></jsp:include>
            </div>
        </div> 

        <div class="container mt-5">
            <h1 class="mb-4">Registrate para poder comprar!!</h1>
            <h2>Register</h2>
        <form:form action="/signup" method="post" modelAttribute="client">
            <div class="mb-3">
                <form:label path="nombre" class="form-label">Nombre:</form:label>
                <form:input path="nombre" class="form-control" />
                <form:errors path="nombre" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="apellido" class="form-label">Apellido:</form:label>
                <form:input path="apellido" class="form-control" />
                <form:errors path="apellido" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="nro_identificacion" class="form-label"># de identificación:</form:label>
                <form:input path="nro_identificacion" class="form-control" />
                <form:errors path="nro_identificacion" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="ciudad" class="form-label">Ciudad:</form:label>
                <form:input path="ciudad" class="form-control" />
                <form:errors path="ciudad" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="departamento" class="form-label">Departamento:</form:label>
                <form:input path="departamento" class="form-control" />
                <form:errors path="departamento" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="direccion" class="form-label">Dirección:</form:label>
                <form:input path="direccion" class="form-control" />
                <form:errors path="direccion" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="email" class="form-label">Email:</form:label>
                <form:input type="email" path="email" class="form-control" />
                <form:errors path="email" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="celular" class="form-label">Celular:</form:label>
                <form:input path="celular" class="form-control" />
                <form:errors path="celular" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="contrasena" class="form-label">Contraseña:</form:label>
                <form:password path="contrasena" class="form-control" />
                <form:errors path="contrasena" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="confirmarContrasena" class="form-label">Confirmación Contraseña:</form:label>
                <form:password path="confirmarContrasena" class="form-control" />
                <form:errors path="confirmarContrasena" class="text-danger" />
            </div>
            <c:if test="${not empty error}">
                <p class="text-danger">${error}</p>
            </c:if>
            <input type="submit" value="Registrarse" class="btn btn-primary" />
        </form:form>
        <br>
        <a href="/" class="btn btn-secondary">Cancelar</a>
    </div>
    <script src="/js/car.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous">
    </script>
</body>

</html>