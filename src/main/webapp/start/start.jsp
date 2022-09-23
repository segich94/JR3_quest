<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>start</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Mono:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
    <link type="text/css" rel= "stylesheet" href="/start/start.css" >
</head>
<body>
    <div class="main">
        <div class="container">
            <h2>Привет! Как тебя зовут?</h2>
            <form action=/init method="post">
                <label>Name:
                    <input type="text" name="username" required pattern="\S*"><br/>
                </label>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
</body>
</html>
