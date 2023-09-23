<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Home</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <a href="/persons/new" class="btn btn-primary">New Person</a>
                <a href="/licenses/new" class="btn btn-primary">New License</a>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>License Number</th>
                            <th>State</th>
                            <th>Expiration Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="person" items="${person}">
                            <tr>
                                <td><a href="/persons/${person.id}" class="btn btn-primary">${person.firstName} ${person.lastName}</a></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${person.license != null}">
                                            ${person.license.number}
                                        </c:when>
                                        <c:otherwise>
                                            No License
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${person.license != null}">
                                            ${person.license.state}
                                        </c:when>
                                        <c:otherwise>
                                            -
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${person.license != null}">
                                            ${person.license.expirationDate}
                                        </c:when>
                                        <c:otherwise>
                                            -
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </body>

        </html>