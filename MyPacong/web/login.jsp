<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/27
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    PrintWriter responseWriter = response.getWriter();
    responseWriter.println("bilibili");
    String login = "login";
    String register = "register";
%>
<h1>用户登录</h1>
<hr>
<div id="container">
    <div id="box">
        <form action="servlet/pictureServlet" method="post">
            <p class="main">
                <label>用户名: </label>
                <input name="username" value="" />
                <label>密码: </label>
                <input type="password" name="password" value="">
            </p>
            <p class="space">
                <input type="submit" value="login" class="login" style="cursor: pointer;" name="action"/>
            </p>
            <p class="space">
                <input type="submit" value="register" class="register" style="cursor: pointer;" name="action"/>
            </p>
        </form>
    </div>
</div>
</body>
</html>
