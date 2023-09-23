<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Show Books</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    </head>

    <body>
        <div class="container mt-5">
            <h1 class="mb-4">
                <c:out value="${book.title}" />
            </h1>
            <p>Description:
                <c:out value="${book.description}" />
            </p>
            <p>Language:
                <c:out value="${book.language}" />
            </p>
            <p>Number of pages:
                <c:out value="${book.numberOfPages}" />
            </p>

            <a href="/" class="btn btn-secondary">Back to Books</a>
            <a href="/books/${book.id}/edit" class="btn btn-primary">Edit Book</a>

            <form action="/books/${book.id}" method="post" class="d-inline">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete" class="btn btn-danger">
            </form>
        </div>
    </body>

    </html>