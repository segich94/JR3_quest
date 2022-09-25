<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>result</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Mono:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
    <link rel= "stylesheet" href="/result/result.css">
</head>
<body>
<div class="main">
    <div class="container">
        <h2>${requestScope.get("result")}</h2>
        <form action="/restart" method="post" class="buttons">
            <button class="retry">Начать заново</button>
        </form>
    </div>
</div>
</body>
</html>
