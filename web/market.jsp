<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 16.12.17
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function sale() {
        seeAll();
        var a = [];
        var b = [];
        a = document.getElementsByClassName('product-item');
        for(var i = 0; i < a.length; i++) {
            a.item(i).parentNode.parentNode.style.display = 'none';
        }

    }

    function addInBasket(name, input) {
        if(input.value === "В корзину") {
            input.value ="Убрать из корзины";
            var req = new XMLHttpRequest();
            req.open("GET", "/basket?staffNameForAdd=" + name.toString());
            req.send();
        } else {
            input.value = "В корзину";
            var req = new XMLHttpRequest();
            req.open("GET", "/basket?staffNameForRemove=" + name.toString());
            req.send();
        }

   /*     setTimeout(function () {
            window.location.reload(true);
        }, 100); */

    }

    function seeAll() {
        var notSaleItem = [];
        var saleItem = [];
        var notSalePlusWidth = [];
        var salePlusWidth = [];
        notSaleItem = document.getElementsByClassName('product-item');
        saleItem = document.getElementsByClassName('product-item-sale');
        for(var i = 0; i < notSaleItem.length; i++) {
            notSaleItem.item(i).parentNode.parentNode.style.display = 'inline-block';
        }
        for(var i = 0; i < saleItem.length; i++) {
            saleItem.item(i).parentNode.parentNode.style.display = 'inline-block';
        }
    }

    function itemOfDay() {
        var notSaleItem = [];
        var saleItem = [];
        var notSalePlusWidth = [];
        var salePlusWidth = [];
        notSaleItem = document.getElementsByClassName('product-item');
        saleItem = document.getElementsByClassName('product-item-sale');
        for(var i = 0; i < notSaleItem.length; i++) {
            notSaleItem.item(i).parentNode.parentNode.style.display = 'none';
        }
        for(var i = 0; i < saleItem.length; i++) {
            if(i !== 1) {
                saleItem.item(i).parentNode.parentNode.style.display = 'none';
            }
        }
    }
</script>
<html>
<head>
    <title>Marketplace</title>
</head>
<body>
<div class="head">
    <div class="hydra">
        <img src="images/cutResizeHydra.png">
    </div>
    <div class="inHead">
        <a class="link" onclick="itemOfDay()">
            <div class="options">
                <div class="inOptions">
                    Товар дня
                </div>
            </div>
        </a>
        <a class="link" onclick="seeAll()">
            <div class="options">
                <div class="inOptions">
                    Все товары
                </div>
            </div>
        </a>
        <a class="link" onclick="sale()">
            <div class="options">
                <div class="inOptions">
                    Скидки
                </div>
            </div>
        </a><%if(request.getSession().getAttribute("username") == null) {
            out.println("<a href=\"login.jsp\" class=\"link\">\n" +
                    "            <div class=\"options\">\n" +
                    "                <div class=\"inOptions\">\n" +
                    "                    Вход\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </a>");
    }%>

        <a href="/basket" class="link">
            <div class="options">
                <div class="inOptions">
                    Корзина
                </div>
            </div>
        </a>

        <%if(request.getSession().getAttribute("username") != null) {
            out.println("<a class=\"link\">\n" +
                    "            <div class=\"welcome\">\n" +
                    "                <div class=\"inOptionsWelcome\">\n" +
                    "                    Добрый день " + request.getSession().getAttribute("username").toString());
            out.println("</div>\n" +
                    "                <a href=\"/reg\" class=\"inOptionsExit\">\n" +
                    "                    Выход\n" +
                    "                </a>\n" +
                    "            </div>\n" +
                    "        </a>");
        }%>
    </div>
</div>
<div class="wrap">
        <% if(request.getSession().getAttribute("cards") != null) {

            ArrayList<String> list = (ArrayList<String>) request.getSession().getAttribute("cards");
            for(int i = 0; i < list.size(); i++) {
                if(i == 0) {
       //             out.println("<div class=\"gridRow\">");
                }
                if((i + 1) % 3 == 0) {
                    out.println(list.get(i));
      //              out.println("</div>");
       //             out.println("<div class=\"gridRow\">");
                } else {
                    out.println(list.get(i));
                }

            }
        }
        %>

</div>
</body>
<link rel="stylesheet" href="market.css" type="text/css">
<link rel="stylesheet" href="card.css" type="text/css">
</html>
