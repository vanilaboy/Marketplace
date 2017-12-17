<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17.12.17
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
</script>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div class="head">
    <div class="hydra">
        <img onclick="location.href = '/'" src="images/cutResizeHydra.png">
    </div>
    <div class="inHead">
        <a class="link" onclick="itemOfDay()">
            <div class="options">
                <div class="inOptions">

                </div>
            </div>
        </a>
        <a class="link" onclick="seeAll()">
            <div class="options">
                <div class="inOptions">

                </div>
            </div>
        </a>
        <a class="link" onclick="location.href = '/'">
            <div class="options">
                <div class="inOptions">
                    Главная
                </div>
            </div>
        </a>
        <a href="login.jsp" class="link">
            <div class="options">
                <div class="inOptions">
                    Вход
                </div>
            </div>
        </a>
        <a href="" class="link">
            <div class="options">
                <div class="inOptions">
                    Корзина
                </div>
            </div>
        </a>
    </div>
</div>
<div class="parent">
    <div class="signInArea">
        <div class="loginForm">
            <form action="/reg" method="post">
                <div class="whatIsThisUp">
                    Логин
                </div>
                <input name="username" placeholder=" Username..." class="inputUsername" required>
                <div class="whatIsThisDown">
                    Пароль
                </div>
                <input name="password" type="password" placeholder=" Password..." class="inputPassword" required>
                <button class="button">Вход</button>
            </form>
        </div>
        <div class="txtList">
            <div class="aboutSignIn">
                <strong>Not a member yet?</strong>
                <ul>
                    <li>
                        <em>Enjoy your product to the fullest :</em>
                        <p>- Maximizing your LG product experience with helpful information about all your registered products</p>
                    </li>
                    <li>
                        <em>Let LG know how to reach you :</em>
                        <p>- Managing your customer profile so LG knows how and when to communicate with you</p>
                    </li>
                    <li>
                        <em>Everything in one location :</em>
                        <p>- A single account that allows for various interaction with LG</p>
                    </li>
                </ul>
                <a href="/reg">Регистрация</a>
            </div>
        </div>
    </div>
</div>
</body>
<link rel="stylesheet" type="text/css" href="login.css">
<link rel="stylesheet" type="text/css" href="market.css">
</html>
