<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Result</title>
</head>

<body>
    <h2>Submitted Info</h2>
    <form>
        <table>
            <tr>
                <td>Name:</td>
                <td>${name}</td>
            </tr>
            <tr>
                <td>Dojo Location:</td>
                <td>${dojoLocation}</td>
            </tr>
            <tr>
                <td>Favorite Language:</td>
                <td>${favoriteLanguage} !!!</td>
            </tr>

            <tr>
                <td>Comment:</td>
                <td>${description}</td>
            </tr>
        </table>

        <br>
        <input type="submit" value="Go Back" formaction="/">
    </form>
</body>

</html>