<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 18.12.17
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basket</title>
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
        <%if(request.getSession().getAttribute("username") == null) {
            out.println("<a href=\"login.jsp\" class=\"link\">\n" +
                    "            <div class=\"options\">\n" +
                    "                <div class=\"inOptions\">\n" +
                    "                    Вход\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </a>");
        }%>
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
<div class="wrapBasket">
    <div class="textBasket">
        Корзина (<%if(request.getSession().getAttribute("inBasket") != null) {
        ArrayList <String> list = (ArrayList<String>) request.getSession().getAttribute("inBasket");
        if(list.size() == 1) {
            out.print(list.size() + " товар");
        } else {
            if(list.size() >= 2 && list.size() < 5) {
                out.print(list.size() + " товара");
            } else {
                out.print(list.size() + " товаров");
            }
        }
    }%>)
    </div>
    <div class="topCardBasket">
        <div class="one">
            Товар
        </div>
        <div class="three">
            Цена
        </div>
        <div class="two">
            Количество
        </div>

    </div>
    <div class="middleCardBasket">
        <%
            if(request.getSession().getAttribute("inBasket") != null) {
                ArrayList <String> list = (ArrayList<String>) request.getSession().getAttribute("inBasket");
                Double resultCost = 0.;
                for(int i = 0; i < list.size(); i++) {
                    String staff = list.get(i);
                    String[] about = staff.split(";;;;;;;;;;");
                    out.println("<div class=\"staffFrame\">\n" +
                            "            <div class=\"basketImage\">\n" +
                            "                <img src=\"" + about[1]);
                    out.println("\">\n" +
                            "            </div>\n" +
                            "            <div class=\"aboutStaff\">\n" +
                            "                <div class=\"staffName\">" + about[0]);
                    out.println("</div>\n" +
                            "                <div class=\"staffShortName\">" + about[3]);
                    out.println("</div>\n" +
                            "            </div>\n" +
                            "            <div class=\"quantity\">" + 1);
                    out.println(" </div>\n" +
                            "            <div class=\"price\">" + about[4] + "$");
                    resultCost += Double.parseDouble(about[4]);
                    out.println("</div>\n" +
                            "        </div>");
                }
                out.println("</div>\n" +
                        "    <div class=\"bottomCardBasket\">\n" +
                        "        <div class=\"subtotalValue\">" + resultCost.toString() + "$");
                out.println("</div>\n" +
                        "        <div class=\"subtotal\">\n" +
                        "            Итог:\n" +
                        "        </div>");
            } else {
                out.println("<br><br><br><br>Тут пусто!<br><br><br><br>");
            }%>
    </div>

</div>
</body>
<link rel="stylesheet" href="market.css" type="text/css">
<link rel="stylesheet" href="basket.css" type="text/css">
</html>
