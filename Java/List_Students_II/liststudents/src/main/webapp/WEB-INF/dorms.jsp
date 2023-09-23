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
                <a href="/dorms/new" class="btn btn-primary">New Dorm</a>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Dorm Name</th>
                            <th>Student Count</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dorm" items="${dorms}">
                            <tr>
                                <td><a href="/dorms/${dorm.id}">${dorm.name}</a></td>
                                <td>${dorm.studentCount}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="/" class="btn btn-secondary">Back to Home</a>
            </div>
            
        </body>

        </html>