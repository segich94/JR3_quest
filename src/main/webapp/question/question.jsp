<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>start</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Mono:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
    <link rel= "stylesheet" href="/question/question.css">
</head>
<body>
<div class="main">
    <div class="container">
        <div class="question">
            <span>${requestScope.get("question")}</span>
            <div class="all_buttons">
                <div class="options">
                    <form action="/firstAnswer" method="post" class="buttons">
                        <button value="option1">${requestScope.get("answer1")}</button>
                    </form>
                    <form action="/secondAnswer" method="post" class="buttons">
                        <button value="option2">${requestScope.get("answer2")}</button>
                    </form>
                </div>
                <div class="info_buttons">
                    <form action="/restart" method="post" class="form_retry">
                        <button class="retry">Начать заново</button>
                    </form>
                    <a href="#popup_background" class="popup_button">Статистика</a>

                </div>
            </div>
        </div>
        <div id="popup_background">
            <div class="popup">
                <ul>
                    <li>
                        <span class="type">Победы</span>
                        <span class="number">${requestScope.get("win")}</span>
                    </li>
                    <li>
                        <span class="type">Поражения</span>
                        <span class="number">${requestScope.get("lose")}</span>
                    </li>
                    <li>
                        <span class="type">Всего</span>
                        <span class="number">${requestScope.get("attempts")}</span>
                    </li>
                </ul></br>
                <a href="#" class="close">Закрыть</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>