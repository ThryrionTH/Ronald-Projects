<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>New Person</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h1 class="mb-4">New Person</h1>
                <form:form action="/persons" method="post" modelAttribute="person">
                    <div class="mb-3">
                        <form:label path="firstName" class="form-label">First Name:</form:label>
                        <form:input path="firstName" class="form-control" />
                        <form:errors path="firstName" class="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="lastName" class="form-label">Last Name</form:label>
                        <form:input path="lastName" class="form-control" />
                        <form:errors path="lastName" class="text-danger" />
                    </div>
                    
                    <input type="submit" value="Create" class="btn btn-primary" />
                    <a href="/" class="btn btn-secondary">Back to Home</a>
                </form:form>
            </div>
        </body>

        </html>