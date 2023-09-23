<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Top Ten</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h2 class="mb-4">Top Ten Songs</h2>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Artist</th>
                            <th>Rating</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${topTenSongs}" var="song">
                            <tr>
                                <td>
                                    <c:out value="${song.title}" />
                                </td>
                                <td>
                                    <c:out value="${song.artist}" />
                                </td>
                                <td>
                                    <c:out value="${song.rating}" />
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="/dashboard" class="btn btn-secondary">Dashboard</a>

            </div>
        </body>

        </html>