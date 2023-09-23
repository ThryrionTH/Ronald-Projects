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
                <a href="/students/new" class="btn btn-primary">New Student</a>
                <a href="/contacts/new" class="btn btn-primary">New Contact</a>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Address</th>
                            <th>City</th>
                            <th>State</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${student}">
                            <tr>
                                <td>${student.firstName} ${student.lastName}</td>
                                <td>${student.age}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${student.contact != null}">
                                            ${student.contact.address}
                                        </c:when>
                                        <c:otherwise>
                                            No Address
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${student.contact != null}">
                                            ${student.contact.city}
                                        </c:when>
                                        <c:otherwise>
                                            No City
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${student.contact != null}">
                                            ${student.contact.state}
                                        </c:when>
                                        <c:otherwise>
                                            No State
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