<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="/css/layouts/aside.css">

<aside>
    <div class="container-sidebar">
        <div class="title-one text-light mb-3">
            <h2>Hola,<strong>${sessionScope.cliente.nombre} ${sessionScope.cliente.apellido}</strong></h2>
        </div>
        <div class="img-profile">
            <img src="../img/perfil.jpg" alt="Imagen de perfil">
            <p class="text-secondary"><small>${sessionScope.cliente.email}</small></p>
        </div>
        <div class="title-two text-light">
            <small>Menu principal</small>
        </div>
        <div class="sidebar">
            <ul class="sidebar-options">
                <li class="me-3 active">
                    <i class="bi bi-menu-button-wide"></i><a href="/dash/edit">Editar</a>
                </li>
                <li class="me-3 img-buttom">
                    <a href="/logout">Cerrar Sesión</a>
                </li>
            </ul>
        </div>
    </div>
</aside>