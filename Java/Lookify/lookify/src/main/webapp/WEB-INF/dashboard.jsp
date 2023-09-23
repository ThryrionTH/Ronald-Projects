<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Dashboard</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <a href="/songs/new" class="btn btn-primary">Add New</a>
                <a href="/songs/topTen" class="btn btn-primary">Top Songs</a>
                <form action="/search" method="post">
                    <div class="input-group mb-3">
                        <input type="text" name="artist" class="form-control" placeholder="Search by Artist" required>
                        <button type="submit" class="btn btn-primary">Search</button>
                    </div>
                </form>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Artists</th>
                            <th>Name</th>
                            <th>Rating</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${song}" var="song">
                            <tr>
                                <td>
                                    <c:out value="${song.artist}" />
                                </td>
                                <td>
                                    <a href="/songs/${song.id}">
                                        <c:out value="${song.title}" />
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${song.rating}" />
                                </td>
                                <td>
                                    <form action="/songs/${song.id}" method="post" class="d-inline">
                                        <input type="hidden" name="_method" value="delete">
                                        <input type="submit" value="Delete" class="btn btn-danger">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </body>

        </html>