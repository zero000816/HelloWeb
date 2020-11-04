<%--
  Created by IntelliJ IDEA.
  User: zero
  Date: 2020/10/25
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<legend>REGISTER</legend> <br />
<!-- form 表单的action 属性值要和配置在web.xml文件中的servlet的url-pattern相同 -->
<form action="/register" method="post" name="login">
    USERNAME: <input type="text" name="username" /> <br /> <br />
    PASSWORD: <input type="password" name="password" /> <br /> <br />
    <input type="submit" value="REGISTER" />
</form>
</html>
