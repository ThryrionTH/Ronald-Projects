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
                <a href="/dojos/new" class="btn btn-primary">New Dojo</a>
                <a href="/ninjas/new" class="btn btn-primary">New Ninja</a>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Dojo Name</th>
                            <th>Ninja Count</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dojo" items="${dojos}">
                            <tr>
                                <td><a href="/dojos/${dojo.id}">${dojo.name}</a></td>
                                <td>${dojo.ninjaCount}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </body>

        </html>