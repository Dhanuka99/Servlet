package lk.ijse.javaee.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/lifecycle2")

public class MyServlet2 extends HttpServlet {

    public MyServlet2() {
        System.out.println("onna object ekak heduwa..(Myservlet2)");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("onna den meka servlet ekak..");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service method called..");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("life cycle get method called..");
        resp.getWriter().write("life cycle get method called..");
    }

    @Override
    public void destroy() {
        System.out.println("onna Myservlet2 merennai yanne");
    }
}
