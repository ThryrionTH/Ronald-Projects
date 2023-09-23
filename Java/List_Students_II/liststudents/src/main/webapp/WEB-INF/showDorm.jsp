<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Show Dojo</title>
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container mt-5">
                <h1 class="mb-4">
                    <c:out value="${dorm.name}" /> Dormitory
                </h1>
                <div class="mb-3">
                    <h3>Add Student to Dorm</h3>
                    <form action="/dorms/${dorm.id}" method="post">
                        <label for="studentId" class="form-label">Select a Student: </label>
                        <select name="studentId" class="form-control">
                            <option value="">-- Select a Student --</option>
                            <c:forEach var="student" items="${studentsWithoutDorm}">
                                <option value="${student.id}">${student.firstName} ${student.lastName}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <input type="submit" value="Add" class="btn btn-primary">
                    </form>
                </div>

                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Name:</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${studentsInDorm}">
                            <tr>
                                <td>
                                    <c:out value="${student.firstName} ${student.lastName}" />
                                </td>
                                <td>
                                    <form action="/dorms/${dorm.id}/${student.id}/delete" method="post"
                                        class="d-inline">
                                        <input type="hidden" name="_method" value="delete">
                                        <input type="submit" value="Delete" class="btn btn-danger">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>


                <a href="/dorms" class="btn btn-secondary">Back to Dorms</a>

            </div>
        </body>

        </html>