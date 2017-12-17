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
        var a = [];
        var b = [];
        a = document.getElementsByClassName('product-item');
        b = document.getElementsByClassName('plusWidth');
        for(var i = 0; i < a.length; i++) {
            a.item(i).style.display = 'none';
            b.item(i).style.display = 'none';
        }
    }

    function seeAll() {
        var notSaleItem = [];
        var saleItem = [];
        var notSalePlusWidth = [];
        var salePlusWidth = [];
        notSaleItem = document.getElementsByClassName('product-item');
        saleItem = document.getElementsByClassName('product-item-sale');
        notSalePlusWidth = document.getElementsByClassName('plusWidth');
        salePlusWidth = document.getElementsByClassName('plusWidthSale');
        for(var i = 0; i < notSaleItem.length; i++) {
            notSaleItem.item(i).style.display = 'block';
            notSalePlusWidth.item(i).style.display = 'block';
        }
        for(var i = 0; i < saleItem.length; i++) {
            saleItem.item(i).style.display = 'block';
            salePlusWidth.item(i).style.display = 'block';
        }
    }

    function itemOfDay() {
        var notSaleItem = [];
        var saleItem = [];
        var notSalePlusWidth = [];
        var salePlusWidth = [];
        notSaleItem = document.getElementsByClassName('product-item');
        saleItem = document.getElementsByClassName('product-item-sale');
        notSalePlusWidth = document.getElementsByClassName('plusWidth');
        salePlusWidth = document.getElementsByClassName('plusWidthSale');
        for(var i = 0; i < notSaleItem.length; i++) {
            notSaleItem.item(i).style.display = 'none';
            notSalePlusWidth.item(i).style.display = 'none';
        }
        for(var i = 0; i < saleItem.length; i++) {
            if(i !== 1) {
                saleItem.item(i).style.display = 'none';
                salePlusWidth.item(i).style.display = 'none';
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

        <a href="" class="link">
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
<div class="parent">
    <div class="wrap">
        <ul>
            <% if(request.getSession().getAttribute("cards") != null) {

                ArrayList<String> list = (ArrayList<String>) request.getSession().getAttribute("cards");
                for(int i = 0; i < list.size(); i++) {
                    out.println(list.get(i));
                }
            }
            %>
        </ul>
    </div>
</div>
</body>
<link rel="stylesheet" href="market.css" type="text/css">
<link rel="stylesheet" href="card.css" type="text/css">
</html>
