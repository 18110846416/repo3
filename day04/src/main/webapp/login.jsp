<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="index.jsp">返回到主页面</a>
    <h2>登录</h2>
    <form action="login" method="post">
        用户名：<input type="text" name="username"><br>
        密　码：<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
    <span style="color: red">
        <% if(request.getAttribute("msg") != null) {%>
            <%=request.getAttribute("msg") %>
        <%}%>
    </span>
</body>
</html>
