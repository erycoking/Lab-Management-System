package main.servlet_filter;

import main.beans.Role;
import main.beans.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/login", "/register"})
public class redirectFilter  implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Role role = user.getRole();
            String url;
            switch (role){
                case client:
                    url = resp.encodeRedirectURL("/client");
                case technician:
                    url = resp.encodeRedirectURL("/technician");
                case admin:
                    url = resp.encodeRedirectURL("/admin");
                case staff:
                    url = resp.encodeRedirectURL("/admin");
                default:
                    url = "/login";
            }
            resp.sendRedirect(url);
        }else {
            resp.sendRedirect("/login");
        }
    }
}
