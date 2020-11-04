package com.demo.filter;

import com.demo.dao.TokenDao;
import com.demo.dao.UserDao;
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

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter on");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (!req.getRequestURI().equals("/") && !req.getRequestURI().equals("/index.jsp") && !req.getRequestURI().equals("/user/register.jsp")) {
            HttpSession session = req.getSession();
            System.out.println(session.getAttribute("userOn"));
            if (session.getAttribute("userOn") != null) {
                filterChain.doFilter(req, resp);
            } else {
                String username = null;
                Cookie[] cookies = req.getCookies();
                if (cookies != null) {
                    for (int i = 0; i < cookies.length; i++) {
                        Cookie cookie = cookies[i];
                        if ("username".equals(cookie.getName())) {
                            username = cookie.getValue();
                        }
                    }
                }
                if (username != null) {
                    UserDao userDao = new UserDaoImpl();
                    User user = userDao.findByName(username);
                    boolean flag = false;
                    TokenDao tokenDao = new TokenDaoImpl();
                    String token = tokenDao.findByName(username);
                    System.out.println(token);
                    if (user != null && TokenHelp.verify(token)) {
                        UserService userService=new UserServiceImpl();
                        RoleService roleService=new RoleServiceImpl();
                        session.setAttribute("userOn",username);
                        Set<Role> roles=userService.getAllRoles(username);
                        Set<Access> allAccess=new HashSet<>();
                        for(Role role:roles){
                            Set<Access> temp=roleService.getAllAccess(role.getRid());
                            allAccess.addAll(temp);
                        }
                        session.setAttribute("AccessSet",allAccess);
                        filterChain.doFilter(req, resp);
                    }
                    else {
                        resp.sendRedirect("/");
                    }
                } else {
                    resp.sendRedirect("/");
                }
                }
            }
        else {
            filterChain.doFilter(req, resp);
        }
    }
}
