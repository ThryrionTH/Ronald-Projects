<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>New Contact</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h1 class="mb-4">New Contact</h1>
                <form:form action="/contacts" method="post" modelAttribute="contact">
                    <div class="mb-3">
                        <form:label path="student" class="form-label">Student:</form:label>
                        <form:select path="student" class="form-control">
                            <form:option value="" label="-- Select a person --" />
                            <form:options items="${studentsWithoutContact}" itemValue="id" itemLabel="firstNameAndLastName"/>
                        </form:select>
                        <form:errors path="student" class="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="address" class="form-label">Address:</form:label>
                        <form:input path="address" class="form-control" />
                        <form:errors path="address" class="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="city" class="form-label">City:</form:label>
                        <form:input path="city" class="form-control" />
                        <form:errors path="city" class="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="state" class="form-label">State:</form:label>
                        <form:input path="state" class="form-control" />
                        <form:errors path="state" class="text-danger" />
                    </div>

                    <input type="submit" value="Create" class="btn btn-primary" />
                    <a href="/" class="btn btn-secondary">Back to Home</a>
                </form:form>
            </div>
        </body>

        </html>