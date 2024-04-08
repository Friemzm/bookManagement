package cn.pdsu.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = {"/shopCarListServlet","/loginServlet","/deleteGoodsServlet","/contDeleteBookServlet","/contAllBookServlet","/allBookServlet","/userRegisterServlet","/userLoginServlet","/seekBookServlet","/shopCarServlet","/seekBookCarServlet","/personalCenterServlet","/contAddBookServlet","/contSeekBookServlet","/settleServlet"})
public class EncondingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }
}
