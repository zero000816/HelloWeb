<%--
  Created by IntelliJ IDEA.
  User: zero
  Date: 2020/10/19
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE HTML>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>LOGIN</title>
</head>
<body>
<fieldset>
  <legend>LOGIN</legend> <br />
  <!-- form 表单的action 属性值要和配置在web.xml文件中的servlet的url-pattern相同 -->
 <form action="/login" method="post" name="login">
     USERNAME: <input type="text" name="username" /> <br /> <br />
     PASSWORRD:  <input type="password" name="password" /> <br /> <br />
     REMEBER ME: <input type="checkbox" name="isFlag" > <br>
     <input type="submit" value="submit" />
     <a name="register" href="/user/register.jsp">  REGISTER</a>
  </form>

</fieldset>
</body>
</html>
