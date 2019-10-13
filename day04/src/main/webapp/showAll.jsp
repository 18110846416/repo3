<%@ page import="com.xiong.pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/27
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        td {
            width: 80px;
            text-align: center;
        }
    </style>
</head>
<body>
    <a href="logout">安全退出</a>
    <h2>成功！！！</h2>
    <h4>当前登录人数：
        <%=application.getAttribute("count")  %>
        人
    </h4>
    <table border="1" cellspacing="0">
        <%
            if(request.getAttribute("list") != null) {
                List<User> list = (List<User>) request.getAttribute("list");
                for(User u : list) {
        %>
                <tr>
                    <td><%=u.getId()%></td>
                    <td><%=u.getUsername()%></td>
                    <td><%=u.getPassword()%></td>
                </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
