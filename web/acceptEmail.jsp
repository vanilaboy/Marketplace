<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 18.12.17
  Time: 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Something wrong</title>
</head>
<body>
<div class="parent">
    <div class="block">
        <input name="validEmail" type="number" placeholder=" Passcode..." class="inputPassword" required>
        <button class="button">Вход</button>
    </div>
</div>
</body>
<link rel="stylesheet" type="text/css" href="default2.css">
<style>
    html {
        background-color: rgba(0, 0, 0, 0.09);
    }

    .parent {
        width: 100%;
        height: 100%;
        position: fixed;
        top: 0;
        left: 0;
        display: flex;
        align-items: center;
        align-content: center;
        justify-content: center;
        overflow: auto;
    }

    .inputPassword {
        border-radius:8px;
        border:rgba(0,0,0,.3) 2px solid;
        box-sizing:border-box;
        font-family: 'Open Sans', sans-serif;
        font-size:16px;

        height:43px;
        width: 85%;
        margin-left: 7.5%;
        margin-top: 5px;
        margin-bottom: 15px;
    }

    .button {
        border: none;
        font-weight: 700;
        outline: none;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        background: #a8a8a8;
        box-shadow: 0 -3px #7a7a7a inset;
        transition: 0.2s;
        font-size: 20pt;
        width: 85%;
        height: 43px;
        margin-top: 27px;
        margin-left: 7.5%;
    }
    .button:hover { background: #fc5a5a; }
    .button:active {
        background: #ca5757;
        box-shadow: 0 4px #bd3334 inset;
    }
</style>
</html>
