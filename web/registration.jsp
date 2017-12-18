<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17.12.17
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div class="head">
    <div class="hydra">
        <img onclick="location.href = '/'" src="images/cutResizeHydra.png">
    </div>
    <div class="inHead">

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
    </div>
</div>
<div class="parent">
    <div class="container">
        <div class="tip">
            <p class="aboutRequired"><span class="required">*</span> поля обязательные к заполнению</p>
        </div>
        <form action="/reg" method="post">
            <fieldset class="fieldbox">
                <div class="email">
                    <div class="textEmail">
                        Ваш Email <span class="required">*</span>
                    </div>
                    <span><input name="email" placeholder=" Email..." class="inputUsername" required></span>
                </div>
                <div class="username">
                    <div class="textUsername">
                        Имя пользователя <span class="required">*</span>
                    </div>
                    <span><input name="email" placeholder=" Username..." class="inputUsername" required></span>
                </div>
                <div class="password">

                    <div class="passwordFirst">
                        <div class="textPasswordFirst">
                            Имя <span class="required">*</span>
                        </div>
                        <span><input name="email" placeholder=" Password..." class="inputUsername" required></span>
                    </div>
                    <div class="passwordSecond">
                        <div class="textPasswordSecond">
                            Отчество <span class="required">*</span>
                        </div>
                        <span><input name="email" placeholder=" Password..." class="inputUsername" required></span>
                    </div>
                </div>
                <button class="button">Регистрация</button>
            </fieldset>
        </form>
    </div>
</div>
</body>
<link rel="stylesheet" href="market.css" type="text/css">
<link rel="stylesheet" href="registration.css" type="text/css">
</html>
