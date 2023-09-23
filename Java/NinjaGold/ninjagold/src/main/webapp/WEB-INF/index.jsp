<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en" xmlns:th="http://www.thymeleaf.org">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Ninja Gold Game</title>
    </head>

    <body>
        <div class="container mt-5">
            <h1 class="text-center">Ninja Gold Game</h1>
            <div class="gold-box">
                <p>Your Gold: <span>${ninja.gold}</span></p>
            </div>

            <div class="row">
                <div class="row">
                    <div class="col-md-3">
                        <div class="bordered-block text-center">
                            <h4 class="text-center">Farm</h4>
                            <p class="text-center">earns 10-20 gold</p>
                            <form action="/farm" method="post">
                                <button type="submit" class="btn btn-primary btn-block">Find Gold!</button>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="bordered-block text-center">
                            <h4 class="text-center">Cave</h4>
                            <p class="text-center">earns 5-10 gold</p>
                            <form action="/cave" method="post">
                                <button type="submit" class="btn btn-primary btn-block">Find Gold!</button>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="bordered-block text-center">
                            <h4 class="text-center">House</h4>
                            <p class="text-center">earns 2-5 gold</p>
                            <form action="/house" method="post">
                                <button type="submit" class="btn btn-primary btn-block">Find Gold!</button>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="bordered-block text-center">
                            <h4 class="text-center">Casino</h4>
                            <p class="text-center">earns /takes 0-50 gold</p>
                            <form action="/casino" method="post">
                                <button type="submit" class="btn btn-primary btn-block">Find Gold!</button>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="bordered-block text-center">
                            <h4 class="text-center">Spa</h4>
                            <p class="text-center">loses 5-20 gold</p>
                            <form action="/spa" method="post">
                                <button type="submit" class="btn btn-primary btn-block">Visit Spa</button>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="bordered-block text-center">
                            <h4 class="text-center">Reset</h4>
                            <p class="text-center">reset gold</p>
                            <form action="/reset" method="post">
                                <button type="submit" class="btn btn-primary btn-block">Reset</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="bordered-block">
                <h2 class="text-center">Activities:</h2>
                <ul>
                    <c:forEach items="${activities}" var="activity">
                        <li>
                            <c:out value="${activity}" />
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    </body>

    </html>