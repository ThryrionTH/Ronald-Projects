<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/app.js"></script>
        <title>SurveyDojo</title>
    </head>

    <body>
        <form action="/result" method="post">
            <table>
                <label for="name">Your name: </label>
                <input type="text" id="name" name="name">

                <p>
                    <label for="dojoLocation">Dojo Location</label>
                    <select name="dojoLocation">
                        <option value="San Jose">San Jose</option>
                        <option value="Miami">Miami</option>
                        <option value="Denver">Denver</option>
                        <option value="San Diego">San Diego</option>
                        <option value="Portland">Portland</option>
                        <option value="Seattle">Seattle</option>
                    </select>
                </p>

                <p>
                    <label for="favoriteLanguage">Favorite Language</label>
                    <select name="favoriteLanguage">
                        <option value="Javascript">JavaScript</option>
                        <option value="Python">Python</option>
                        <option value="C++">C++</option>
                        <option value="Java">Java</option>
                        <option value="Php">PHP</option>
                        <option value="R">R</option>
                    </select>
                </p>

                <p>Comment (optional):</p>
                <textarea name="description"></textarea>

                <br>
                <input type="submit" value="Button">
            </table>
        </form>
    </body>

    </html>