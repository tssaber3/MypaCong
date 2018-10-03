<%@ page import="java.io.PrintWriter" %>
<%@ page import="dao.pictureDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/26
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>我的爬虫</title>
  </head>
  <body>
<%
  PrintWriter printout = response.getWriter();
  printout.println("WORLD COSPLAY");
%>
<form action="servlet/pictureServlet" method="post">
<%
  pictureDao Dao = new pictureDao();
  List<String> list;
  list = Dao.show();
  for (int i = 0;i < list.size();i++)
  {
%>
  <a href="detail.jsp?name=<%=list.get(i)%>" name="<%=list.get(i)%>"><%=list.get(i)%></a>
  <%
    }
  %>
</form>
  </body>
</html>
