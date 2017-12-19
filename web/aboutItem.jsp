<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 16.12.17
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
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
</script>
<html>
<head>
    <title><%out.println(request.getParameter("itemName"));%></title>
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
<div class="aboutWrap">
    <div class="nameItem">
        <strong> <%if(request.getAttribute("aboutThisItem") != null) {
            String about = (String) request.getAttribute("aboutThisItem");
            String mas[] = about.split(";;;;;;;;;;");
            out.println(mas[0]);
        }%>
        </strong>
    </div>
    <br>
    <div class="images">
        <div class="firstImage">
            <img src="<%if(request.getAttribute("aboutThisItem") != null) {
                String about = (String) request.getAttribute("aboutThisItem");
                String mas[] = about.split(";;;;;;;;;;");
                out.println(mas[1]);
            }%>">
        </div>
    </div>
    <div class="shortAbout">
        <%if(request.getAttribute("aboutThisItem") != null) {
            String about = (String) request.getAttribute("aboutThisItem");
            String mas[] = about.split(";;;;;;;;;;");
            out.println(mas[3]);
        }%>
    </div>
    <br><br>
    <div class="aboutItem">
        <%if(request.getAttribute("aboutThisItem") != null) {
            String about = (String) request.getAttribute("aboutThisItem");
            String mas[] = about.split(";;;;;;;;;;");
            out.println(mas[2]);
        }%>
    </div>
    <div class="price">
        <%if(request.getAttribute("aboutThisItem") != null) {
            String about = (String) request.getAttribute("aboutThisItem");
            String mas[] = about.split(";;;;;;;;;;");
            if(Double.parseDouble(mas[5]) != 0) {
                out.println("<strike>" + mas[4] + " </strike>" + mas[5]);
            } else {
                out.println(mas[4]);
            }
        }%>
    </div>
    <div class="divButton">
    <input type="button" value="<%
        if(request.getSession().getAttribute("inBasket") != null) {
                ArrayList<String> inBasket = (ArrayList<String>) request.getSession().getAttribute("inBasket");
                String about = (String) request.getAttribute("aboutThisItem");
                String mas[] = about.split(";;;;;;;;;;");
                boolean set = false;
                for(int i = 0; i < inBasket.size(); i++) {
                    if(inBasket.get(i).contains(mas[0])) {
                        out.print("Убрать из корзины");
                        set = true;
                        break;
                    }
                }
                if(!set) {
                    out.print("В корзину");
                }
        } else {
            out.print("В корзину");
        }
    %>" class="button" onclick="addInBasket('<%if(request.getAttribute("aboutThisItem") != null) {
            String about = (String) request.getAttribute("aboutThisItem");
            String mas[] = about.split(";;;;;;;;;;");
            out.print(mas[0]);
            }
%>', this)"/>
    </div>
</div>
</body>
<link rel="stylesheet" href="aboutItem.css" type="text/css">
<link rel="stylesheet" href="market.css" type="text/css">
</html>
