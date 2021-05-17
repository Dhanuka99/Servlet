package lk.ijse.pos.listner;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;


@WebListener
public class MyListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Application Servlet Context Was Created");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Company");
        dataSource.setUsername("root");
        dataSource.setPassword("11356");
        dataSource.setMaxTotal(2);
        dataSource.setInitialSize(2);
        servletContextEvent.getServletContext().setAttribute("ds", dataSource);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Application Servlet Context Was Destroyed");
    }
}
