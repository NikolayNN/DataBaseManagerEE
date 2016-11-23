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
import java.util.List;
import java.util.Set;

/**
 * Created by Nikol on 11/2/2016.
 */
@Component
public class BasesNameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Service service = (Service) getServletContext().getAttribute("service");
            Storeable store = (Storeable) request.getSession().getAttribute("store");
            request.setAttribute("databases", service.getDataBaseNames(store));
            request.getRequestDispatcher("dataBases.jsp").forward(request, response);
        }catch (RuntimeException ex){
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
