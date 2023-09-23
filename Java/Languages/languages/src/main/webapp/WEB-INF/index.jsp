<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Index</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    </head>

    <body>
        <div class="container mt-5">
            <h1 class="mb-4">All Languages</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Creator</th>
                        <th>Current Version</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${languages}" var="language">
                        <tr>
                            <td>
                                <a href="/languages/${language.id}"><c:out value="${language.name}" /></a>
                            </td>
                            <td>
                                <c:out value="${language.creator}" />
                            </td>
                            <td>
                                <c:out value="${language.currentVersion}" />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/languages/new" class="btn btn-primary">New Language</a>
        </div>
    </body>

    </html>