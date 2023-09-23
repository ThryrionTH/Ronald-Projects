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
            <h1 class="mb-4">All Books</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Language</th>
                        <th>Number of Pages</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td>
                                <c:out value="${book.title}" />
                            </td>
                            <td>
                                <c:out value="${book.description}" />
                            </td>
                            <td>
                                <c:out value="${book.language}" />
                            </td>
                            <td>
                                <c:out value="${book.numberOfPages}" />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/books/new" class="btn btn-primary">New Book</a>
        </div>
    </body>

    </html>