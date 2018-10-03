<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/27
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户注册</h1>
<hr>
<div id="container">
    <div id="box">
        <form action="servlet/pictureServlet" method="post">
            <p class="main">
                <label>用户名: </label>
                <input name="username" value="" /><br>
                <label>密码: </label>
                <input type="password" name="password" value=""><br>
                <label>再次输入密码: </label>
                <input type="password" name="password" value=""><br>
            <p class="space">
                <input type="submit" value="registerUser" class="register" style="cursor: pointer;" name="action"/>
            </p>
            </p>
        </form>
    </div>
</div>
</body>
</html>
