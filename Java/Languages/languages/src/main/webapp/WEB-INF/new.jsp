<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>New Language</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h1 class="mb-4">New Language</h1>
                <form:form action="/languages" method="post" modelAttribute="language">
                    <div class="mb-3">
                        <form:label path="name" class="form-label">Name</form:label>
                        <form:errors path="name" class="text-danger" />
                        <form:input path="name" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <form:label path="creator" class="form-label">Creator</form:label>
                        <form:errors path="creator" class="text-danger" />
                        <form:input path="creator" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <form:label path="currentVersion" class="form-label">Current Version</form:label>
                        <form:errors path="currentVersion" class="text-danger" />
                        <form:input type="number" path="currentVersion" class="form-control"/>
                    </div>
                    <input type="submit" value="Submit" class="btn btn-primary" />
                </form:form>
            </div>
        </body>

        </html>