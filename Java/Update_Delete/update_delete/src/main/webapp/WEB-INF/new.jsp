<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>New Book</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h1 class="mb-4">New Book</h1>
                <form:form action="/books" method="post" modelAttribute="book">
                    <div class="mb-3">
                        <form:label path="title" class="form-label">Title</form:label>
                        <form:errors path="title" class="text-danger" />
                        <form:input path="title" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <form:label path="description" class="form-label">Description</form:label>
                        <form:errors path="description" class="text-danger" />
                        <form:textarea path="description" class="form-control" rows="4" />
                    </div>
                    <div class="mb-3">
                        <form:label path="language" class="form-label">Language</form:label>
                        <form:errors path="language" class="text-danger" />
                        <form:input path="language" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <form:label path="numberOfPages" class="form-label">Pages</form:label>
                        <form:errors path="numberOfPages" class="text-danger" />
                        <form:input type="number" path="numberOfPages" class="form-control" />
                    </div>
                    <input type="submit" value="Submit" class="btn btn-primary" />
                </form:form>
            </div>
        </body>

        </html>