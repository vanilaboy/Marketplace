<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17.12.17
  Time: 21:53
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
        <div class="text"><strong><%
            if(request.getAttribute("whatDo").toString().toLowerCase().contains("nullpointerexception")) {
                out.println("Something Went Wrong");
            } else {
                out.println(request.getAttribute("whatDo"));
            }%></strong></div>
    </div>
</div>
</body>
<style>
    .text {
        color: #7c7c7c;
        text-shadow: #757575;
        font-family: "URW Gothic L";
        font-size: 40pt;

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
</style>
</html>
