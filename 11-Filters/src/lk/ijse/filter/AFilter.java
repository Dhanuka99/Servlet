package lk.ijse.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/customer")
public class AFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("A filer Initialized..");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("D filter call");
        servletRequest.setAttribute("x","Dhanuka");
        //methona thama ona dewal okkoma kliyannea..ex.selected users can be access the customer servlet

        filterChain.doFilter(servletRequest,servletResponse);

        //response
        servletResponse.setContentType("application/json");

        //redirect the responce
//        HttpServletResponse http = (HttpServletResponse) servletResponse;
//        http.sendRedirect();

    }

    @Override
    public void destroy() {
        System.out.println("filter Destroyed");
    }
}
