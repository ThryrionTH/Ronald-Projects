<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="js/script.js"></script>
</head>

<body>
    <div class="container mt-5">
        <h1 class="mb-4">Estas a punto de hacer feliz a tu mascota, ${client.nombre} ${client.apellido}
        </h1>
        <a href="/logout">Log out</a>
        <h2 class="mb-4">Tu factura</h2>
        <a href="/">Home</a>
        <h3 class="mb-4">
            Nombre: <c:out value="${client.nombre}" />
        </h3>
        <h3 class="mb-4">
            Apellido: <c:out value="${client.apellido}" />
        </h3>
        <h3 class="mb-4">
            Nro de identificación: <c:out value="${client.nro_identificacion}" />
        </h3>
        <h3 class="mb-4">
            Email: <c:out value="${client.email}" />
        </h3>
        <h3 class="mb-4">
            Celular: <c:out value="${client.celular}" />
        </h3>
        
        <a href="/checkout/pay" class="btn btn-primary">Pagar</a>
    </div>
</body>

</html>