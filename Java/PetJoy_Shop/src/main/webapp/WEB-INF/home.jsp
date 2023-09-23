<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/aos@2.3.4/dist/aos.css" rel="stylesheet">
        <link rel="stylesheet" href="./css/style.css">
        <link rel="shortcut icon" href="/img/favicon.png">
        <title>PetJoy Shop</title>
    </head>

    <body>

        <%@ include file="./layouts/navbar.jsp"%>
       
       <!-- Carousel -->
        <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="./img/img4.png" class="d-block w-100" alt="img1" loading="lazy">
                </div>
                <div class="carousel-item">
                    <img src="./img/img1.webp" class="d-block w-100" alt="img1" loading="lazy">
                </div>
                <div class="carousel-item">
                    <img src="./img/img2.webp" class="d-block w-100" alt="img2" loading="lazy">
                </div>
                <div class="carousel-item">
                    <img src="./img/img3.webp" class="d-block w-100" alt="img3" loading="lazy">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <!-- Carrito de compras -->
        <div class="offcanvas offcanvas-end col-md-8" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasRightLabel">Carrito de compras</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <jsp:include page="layouts/carrito.jsp"></jsp:include>
                </div>
            </div>

            <div class="container mt-5 mb-5">
                <!-- Card Principal-->
                <div class="card mb-3 card-init" style="max-width: 100%;">
                    <div class="row g-0">
                        <div class="col-md-4" data-aos="fade-right">
                            <img src="./img/img1.jpg" class="img-fluid rounded-start" alt="..." loading="lazy">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body" data-aos="fade-left">
                              <h4 class="card-title ml-green">¡Descubre el poder de nuestros productos!</h4>
                              <p class="card-text mt-4">Descubre una nueva forma de vivir con nuestra amplia gama de productos de alta calidad. Nuestros productos están diseñados para brindarte comodidad y satisfacción en cada uso, elevando tu experiencia a un nivel superior. ¡No esperes más para experimentar la diferencia y transformar tu vida!</p>
                              <a href="/products" class="btn btn-success mt-2">Ver Productos</a>
                        </div>
                        </div>
                    </div>
                </div>

                <!-- Category -->
                <div class="my-4">
                    <h2 class="ml-green my-4">Lo que necesitas para tus mascotas</h2>
                    <div class="d-flex">
                        <div class="mundo container-fluid me-3" data-aos="fade-up">
                            <h1 class="title">Mundo gatuno</h1>
                            <div class="gatuno">
                            </div>
                        </div>
                        <div class="mundo container-fluid ms-3" data-aos="fade-up">
                            <div class="perruno">
                            </div>
                            <h1 class="title">Mundo perruno</h1>
                        </div>
                    </div>
                </div>

                <!-- Productos recomendados -->
                <div>
                    <div class="my-4" >
                        <h2 class="ml-green my-4">Productos recomendados</h2>
                        <div class="d-flex flex-wrap justify-content-between" id="lista-cursos">
                        <c:forEach items="${randomProducts}" var="producto" varStatus="status">
                            <div class="card m-1" style="width: 18rem;" data-aos="fade-up">
                                <div class="card-header d-flex justify-content-center align-self-cente">
                                    <img src="/img/products/${producto.imagen}" alt="${producto.nombre}" height="150px" loading="lazy">
                                    <button type="button" class="btn btn-secondary modal-product" data-bs-toggle="modal"
                                            data-bs-target="#modalProduct-${status.index}">
                                        <i class="bi bi-search"></i>
                                    </button>
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">${producto.nombre}</h5>
                                    <p class="card-text precio d-none"><span>$${producto.precio}</span></p>
                                    <fmt:formatNumber value="${producto.precio}" type="currency" currencyCode="COP" pattern="¤ #,##0"/>
                                </div>
                                <div class="card-footer d-flex justify-content-center">
                                    <button id="cart-button" class="btn btn-success add-to-cart-button agregar-carrito" data-id="$${producto.id}"
                                            data-product-id="2">
                                        <i class="bi bi-cart-fill me-2"></i>Agregar
                                    </button>


                                </div>
                            </div>

                            <!-- Modal -->
                            <div class="modal fade" id="modalProduct-${status.index}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">${producto.nombre}</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="mb-3" style="max-width: 540px;">
                                                <div class="row g-0">
                                                    <div class="card-body">
                                                        <div class="row">
                                                            <div class="col-sm-5 d-flex align-items-center">
                                                                <img src="/img/products/${producto.imagen}" alt="${producto.nombre}" height="150px" loading="lazy">
                                                            </div>
                                                            <div class="col-sm-7">
                                                                <h5 class="card-title">${producto.nombre}</h5>
                                                                <p class="card-text"><small class="text-body-secondary">Código de producto:${producto.codigo}</small></p>
                                                                <p class="card-text precio d-none"><span>$${producto.precio}</span></p>
                                                                <fmt:formatNumber value="${producto.precio}" type="currency" currencyCode="COP" pattern="¤ #,##0" />
                                                                <hr width="215px">
                                                                <button id="cart-button" class="btn btn-success add-to-cart-button agregar-carrito" data-id="$${producto.id}"
                                                                        data-product-id="2">
                                                                    <i class="bi bi-cart-fill me-2"></i>Agregar
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <p class="mt-4">${producto.descripcion}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        <hr>
        <h2 class="text-center">Marcas asociadas</h2>
        <div class="carousel-container" data-aos="fade">
            <div class="carousel-track">
                <img src="/img/brands/agilitygold.png" alt="Marca agilitygold" loading="lazy" />
                <img src="/img/brands/cat-licius.png" alt="Marca cat-licius" loading="lazy" />
                <img src="/img/brands/chunky.png" alt="Marca chunky" loading="lazy" />
                <img src="/img/brands/monello.png" alt="Marca monello" loading="lazy" />
                <img src="/img/brands/pedigree.png" alt="Marca pedigree" loading="lazy" />
                <img src="/img/brands/purina.png" alt="Marca purina" loading="lazy" />
                <img src="/img/brands/trixie.png" alt="Marca trixie" loading="lazy" />
                <img src="/img/brands/agilitygold.png" alt="Marca agilitygold" loading="lazy" />
                <img src="/img/brands/cat-licius.png" alt="Marca cat-licius" loading="lazy" />
                <img src="/img/brands/chunky.png" alt="Marca chunky" loading="lazy" />
                <img src="/img/brands/monello.png" alt="Marca monello" loading="lazy" />
                <img src="/img/brands/pedigree.png" alt="Marca pedigree" loading="lazy" />
                <img src="/img/brands/purina.png" alt="Marca purina" loading="lazy" />
                <img src="/img/brands/trixie.png" alt="Marca trixie" loading="lazy" />

            </div>
        </div>
    </div>

    <%@ include file="./layouts/footer.jsp"%>

    <script src="/js/car.js"></script>
    <script src="/js/slider.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/aos@2.3.4/dist/aos.js"></script>
    <script>
        AOS.init();
    </script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


</body>

</html>