<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Show Person</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h1 class="mb-4">
                    <c:out value="${person.firstName} ${person.lastName}" />
                </h1>
                <p>License Number:
                    <c:choose>
                        <c:when test="${license != null}">
                            <c:out value="${license.number}" />
                        </c:when>
                        <c:otherwise>
                            No License
                        </c:otherwise>
                    </c:choose>
                </p>
                <p>State:
                    <c:choose>
                        <c:when test="${license != null}">
                            <c:out value="${license.state}" />
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </p>
                <p>Expiration Date:
                    <c:choose>
                        <c:when test="${license != null}">
                            <c:out value="${license.expirationDate}" />
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </p>

                <a href="/" class="btn btn-secondary">Back to Home</a>

            </div>
        </body>

        </html>