package com.demo.servlet;

import com.demo.dao.TokenDao;
import com.demo.dao.impl.TokenDaoImpl;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.entity.Access;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.service.RoleService;
import com.demo.service.UserService;
import com.demo.service.impl.RoleServiceImpl;
import com.demo.service.impl.UserServiceImpl;
import com.demo.tool.TokenHelp;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String password=req.getParameter("password");
        UserService userService=new UserServiceImpl();
        RoleService roleService=new RoleServiceImpl();
       if(userService.login(name,password)){
           HttpSession session=req.getSession();
           //无论是否免登录，都在session中放一个用户名，便于后续的操作。（以后可能要放一个集合？）
           session.setAttribute("userOn",name);
           Set<Role> roles=userService.getAllRoles(name);
           Set<Access> allAccess=new HashSet<>();
           for(Role role:roles){
               Set<Access> temp=roleService.getAllAccess(role.getRid());
               allAccess.addAll(temp);
           }
           session.setAttribute("AccessSet",allAccess);
           for (Access access:(Set<Access>)session.getAttribute("AccessSet")){
               System.out.println(access.getName());
           }


           if (req.getParameter("isFlag") != null){
               System.out.println("免登录");
               User user=new User(0,name,password);
               Cookie cookie = new Cookie("username", name);
               cookie.setMaxAge(60 * 50);
               //设置关联路径,默认根路径就行
               cookie.setPath(req.getContextPath());
               //发送Cookie给浏览器
               resp.addCookie(cookie);
               String token=TokenHelp.getToken(user);
               session.setAttribute(name,token);
               TokenDao tokenDao=new TokenDaoImpl();
               tokenDao.addToken(name,token);
           }

           resp.sendRedirect("home.jsp");

       }
       else {
           resp.getWriter().println("Wrong!");
       }
    }
}
