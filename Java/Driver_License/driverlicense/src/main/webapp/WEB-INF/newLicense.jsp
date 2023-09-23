<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>New License</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h1 class="mb-4">New License</h1>
                <form:form action="/licenses" method="post" modelAttribute="license">
                    <div class="mb-3">
                        <form:label path="person" class="form-label">Person:</form:label>
                        <form:select path="person" class="form-control">
                            <form:option value="" label="-- Select a person --" />
                            <form:options items="${personsWithoutLicense}" itemValue="id" itemLabel="firstNameAndLastName"/>
                        </form:select>
                        <form:errors path="person" class="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="state" class="form-label">State:</form:label>
                        <form:input path="state" class="form-control" />
                        <form:errors path="state" class="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="expirationDate" class="form-label">Expiration Date</form:label>
                        <form:input type="date" path="expirationDate" class="form-control" />
                        <form:errors path="expirationDate" class="text-danger" />
                    </div>

                    <input type="submit" value="Create" class="btn btn-primary" />
                    <a href="/" class="btn btn-secondary">Back to Home</a>
                </form:form>
            </div>
        </body>

        </html>