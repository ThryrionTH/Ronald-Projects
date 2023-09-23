<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>New Songs</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h1 class="mb-4">Add a song!</h1>
                <form:form action="/songs" method="post" modelAttribute="song">
                    <div class="mb-3">
                        <form:label path="title" class="form-label">Title:</form:label>
                        <form:input path="title" class="form-control" />
                        <form:errors path="title" class="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="artist" class="form-label">Artist</form:label>
                        <form:input path="artist" class="form-control" />
                        <form:errors path="artist" class="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="rating" class="form-label">Rating (1-10)</form:label>
                        <form:select path="rating" class="form-control">
                            <form:option value="1">1</form:option>
                            <form:option value="2">2</form:option>
                            <form:option value="3">3</form:option>
                            <form:option value="4">4</form:option>
                            <form:option value="5">5</form:option>
                            <form:option value="6">6</form:option>
                            <form:option value="7">7</form:option>
                            <form:option value="8">8</form:option>
                            <form:option value="9">9</form:option>
                            <form:option value="10">10</form:option>
                        </form:select>
                        <form:errors path="rating" class="text-danger" />
                    </div>
                    <input type="submit" value="Add Song" class="btn btn-primary" />
                    <a href="/dashboard" class="btn btn-secondary">Dashboard</a>
                </form:form>
            </div>
        </body>

        </html>