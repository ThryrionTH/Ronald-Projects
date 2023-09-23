<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Index</title>
</head>
<body>
    <h2 class="center">What is the code?</h2>
    <p class="center">${error}</p>
    <form action="/checkcode" method="POST">
        <input class="center" type="text" name="code">
        <button class ="center">Try Code</button>
    </form>
</body>
</html>