<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!-- Navbar -->
<nav class="navbar navbar-expand-lg bg-body-tertiary" id="navbar-petjoy">
    <div class="container-fluid">
        <a class="navbar-brand c-white font-lobster" href="/"><i class="bi bi-shop"></i> PetJoyBundler</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
      
        <!-- <c:if test="${sessionScope.cliente == null}">
            <a class="navbar-brand c-white" href="/login"><i class="bi bi-shop"></i> Iniciar Sesión</a>
            <a class="navbar-brand c-white" href="/signup"><i class="bi bi-shop"></i> Registrarse</a>
        </c:if> -->

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <c:if test="${not empty sessionScope.cliente}">
                    <li class="nav-item">
                        <a class="nav-link active c-white" aria-current="page" href="/dash/edit"><i
                                class="bi bi-person-circle"></i> ${sessionScope.cliente.nombre} ${sessionScope.cliente.apellido}</a>
                    </li>
                </c:if>
            </ul>
            <div class="d-flex">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <sec:authorize access="!isAuthenticated()">
                            <a class="nav-link active c-white" href="/login" aria-current="page"><i class="bi bi-box-arrow-in-right"></i> Iniciar Sesión</a>
                        </sec:authorize>
                    </li>
                    <li>
                        <sec:authorize access="!isAuthenticated()">
                            <a class="nav-link active c-white" href="/signup" aria-current="page"><i class="bi bi-r-square"></i> Registrarse</a>
                        </sec:authorize>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active c-white" aria-current="page" href="products"><i
                                class="bi bi-gift-fill"></i> Productos</a>
                    </li>
                    <c:if test="${sessionScope.cliente != null}">
                        <li class="nav-item">
                            <a href="/pedidos" class="nav-link active c-white" aria-current="page" >
                                <i class="bi bi-basket-fill"></i> Mis Pedidos
                            </a>
                        </li>

                        <li class="nav-item btn-logout">
                            <a class="nav-link active c-white" aria-current="page" href="<c:url value='/logout' />">
                                <i class="bi bi-box-arrow-right"></i> Cerrar sesión
                            </a>
                        </li>
                    </c:if>


                    <li class="nav-item">
                        <!-- Button trigger modal -->
                        <button id="btnProdCart" class="btn btn-outline-success c-white b-white" type="submit" data-bs-toggle="offcanvas"
                                data-bs-target="#offcanvasRight" aria-controls="offcanvasRight"><i class="bi bi-cart4"></i> <span
                                class="badge bg-success rounded-pill">Tus productos</span> </button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<script src="/js/logout.js"></script>
