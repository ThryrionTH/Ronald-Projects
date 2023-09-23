<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Show Dojo</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h1 class="mb-4">
                    <c:out value="${dojo.name}" />
                </h1>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Age</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ninja" items="${ninjas}">
                            <tr>
                                <td><c:out value="${ninja.firstName}" /></td>
                                <td><c:out value="${ninja.lastName}" /></td>
                                <td><c:out value="${ninja.age}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <a href="/" class="btn btn-secondary">Back to Home</a>

            </div>
        </body>

        </html>