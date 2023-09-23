<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Show Language</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    </head>

    <body>
        <div class="container mt-5">
            <p>Name:
                <c:out value="${language.name}" />
            </p>
            <p>Creator:
                <c:out value="${language.creator}" />
            </p>
            <p>Current Version:
                <c:out value="${language.currentVersion}" />
            </p>

            <a href="/" class="btn btn-secondary">Back to Languages</a>
            <a href="/languages/${language.id}/edit" class="btn btn-primary">Edit Language</a>

            <form action="/languages/${language.id}" method="post" class="d-inline">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete" class="btn btn-danger">
            </form>
        </div>
    </body>

    </html>