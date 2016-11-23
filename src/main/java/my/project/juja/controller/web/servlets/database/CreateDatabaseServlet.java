package my.project.juja.controller.web.servlets.database;

import my.project.juja.model.Storeable;
import my.project.juja.service.Service;
import my.project.juja.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikol on 11/8/2016.
 */
public class CreateDatabaseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Service service = (Service) getServletContext().getAttribute("service");
            Storeable store = (Storeable) request.getSession().getAttribute("store");
            service.createDatabase(store, request.getParameter("dbname"));
            response.sendRedirect("menu.do");
        }catch (RuntimeException ex){
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("createDataBase.jsp");
    }
}
