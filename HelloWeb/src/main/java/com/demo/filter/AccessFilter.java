package com.demo.filter;

import com.demo.entity.Access;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class AccessFilter implements Filter {
    public AccessFilter() {
        super();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String requestURI=req.getRequestURI();
        System.out.println("AccessFliter On");
        String accessName=requestURI.split("/")[2].split("\\.")[0];
        Set<Access> accessSet=(Set<Access>)req.getSession().getAttribute("AccessSet");
        System.out.println(accessName);
        boolean flag=false;
        for (Access a: accessSet) {
            if (a.getName().equals(accessName)) {
                flag = true;
                break;
            }
        }
        if (flag ==false) {
                resp.sendRedirect("/Wrong.html");
            }
            filterChain.doFilter(req,resp);
        }


    @Override
    public void destroy() {

    }
}
