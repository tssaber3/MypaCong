<%@ page import="dao.pictureDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/27
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String name = request.getParameter("name");
    %>
    <title><%=name%></title>
</head>
<body>
<%
    pictureDao Dao = new pictureDao();
    List<String> list = new ArrayList<>();
    list = Dao.serach(name);
    for (int i = 0;i < list.size();i++)
    {
%>
<img src="<%=list.get(i)%>"><br>
<%
    }
%>
</body>
</html>
