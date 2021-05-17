package lk.ijse.pos.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //gahter informations from req object
        String pathInfo = req.getPathInfo();
        String method = req.getMethod();
        String contextPath = req.getContextPath();
        String queryString = req.getQueryString();
        StringBuffer requestURL = req.getRequestURL();
        String servletPath = req.getServletPath();

        System.out.println("path info : "+pathInfo);
        System.out.println("method : "+method);
        System.out.println("context path : "+contextPath);
        System.out.println("Query String : "+queryString);
        System.out.println("path info : "+requestURL);
        System.out.println("servlet path : "+servletPath);

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");

        System.out.println(id+" "+name+" "+address+" "+salary);


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "danu", "1234");
            PreparedStatement pstm = conn.prepareStatement("insert into Customer values(?,?,?,?)");

            pstm.setObject(1,id);
            pstm.setObject(2,name);
            pstm.setObject(3,address);
            pstm.setObject(4,salary);

            int i = pstm.executeUpdate();
            PrintWriter writer = resp.getWriter();
            if (i<0){
                writer.write("customer not recorded..");
            }else{
                writer.write("Customer record successfully..");
            }



            writer.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
