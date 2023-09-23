<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" href="/css/layouts/aside.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<aside>
    <div class="container-sidebar">
        <div class="title-one text-light mb-3">
            <h2>Hola,<strong>
                <c:out value="${sessionScope.nombreUsuario}" />
            </strong></h2>
        </div>
        <div class="img-profile">
            <img src="../img/perfil.jpg" alt="Imagen de perfil">
            <sec:authorize access="isAuthenticated()">
                <p class="text-secondary"><small><sec:authentication property="name"/></small></p>
            </sec:authorize>
        </div>
        <div class="title-two text-light">
            <small>Menu principal</small>
        </div>
        <div class="sidebar">

            <ul class="sidebar-options">
                <li class="me-4"><i class="bi bi-menu-button-wide"></i><a href="/dashboard">Productos</a></li>
                <li class="me-4"><i class="bi bi-menu-button-wide"></i><a href="/dashboard/categories">Categorias</a></li>
                <li class="me-4"><i class="bi bi-menu-button-wide"></i><a href="/dashboard/animals">Animales</a></li>
                <li class="me-4"><i class="bi bi-menu-button-wide"></i><a href="/dashboard/brands">Marcas</a></li>
                <li class="me-4"><i class="bi bi-receipt"></i><a href="/dashboard/bills">Facturas</a></li>
                <!-- <li class="me-4"><i class="bi bi-people-fill"></i><a href="#">Usuarios</a></li> -->
            </ul>

        </div>
        <div class="img-buttom btn-logout">
            <a href="/logout">Cerrar Sesión</a>
        </div>
    </div>
</aside>

<script src="/js/sidebar.js"></script>
<script src="/js/logout.js"></script>