<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Show Song</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <p>Title:
                    <c:out value="${song.title}" />
                </p>
                <p>Artist:
                    <c:out value="${song.artist}" />
                </p>
                <p>Rating (1-10):
                    <c:out value="${song.rating}" />
                </p>

                <a href="/dashboard" class="btn btn-secondary">Dashboard</a>

                <form action="/songs/${song.id}" method="post" class="d-inline">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete" class="btn btn-danger">
                </form>
            </div>
        </body>

        </html>