<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>New Dorm</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h1 class="mb-4">New Dorm</h1>
                <form:form action="/dorms" method="post" modelAttribute="dorm">
                    <div class="mb-3">
                        <form:label path="name" class="form-label">Name:</form:label>
                        <form:input path="name" class="form-control" />
                        <form:errors path="name" class="text-danger" />
                    </div>
    
                    <input type="submit" value="Create" class="btn btn-primary" />
                    <a href="/dorms" class="btn btn-secondary">Back to Home</a>
                </form:form>
            </div>
        </body>

        </html>