package lk.ijse.javaee.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/lifecycle")

public class MyServlet extends HttpServlet {

    public MyServlet() {
        System.out.println("onna object ekak heduwa..(Myservlet)");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("onna den meka servlet ekak..");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("life cycle get method called..");
        resp.getWriter().write("life cycle get method called..");
    }

    @Override
    public void destroy() {
        System.out.println("onna (Myservlet) merennai yanne");
    }
}
