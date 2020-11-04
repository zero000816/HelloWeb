<%@ page import="com.demo.entity.Role" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.demo.service.UserService" %>
<%@ page import="com.demo.service.impl.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: zero
  Date: 2020/11/1
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
welcome!!<br>
your role is
<%
    String username=(String)request.getSession().getAttribute("userOn");
    UserService userService=new UserServiceImpl();
    Set<Role> roles=userService.getAllRoles(username);
    for(Role role:roles){
        System.out.println(role.getName());
        out.write(role.getName()+" ");
    }

%>

<br>
<a href="user/high.jsp">high<br></a>
<a href="user/med.jsp">med<br></a>
<a href="user/low.jsp">low<br></a>
<a href="/logout">logout</a>
</body>
</html>
