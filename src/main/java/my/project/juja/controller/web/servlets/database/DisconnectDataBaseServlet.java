package my.project.juja.controller.web.servlets.database;

import my.project.juja.model.DatabaseManager;
import my.project.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikol on 11/8/2016.
 */
public class DisconnectDataBaseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Service service = (Service) getServletContext().getAttribute("service");
            DatabaseManager store = (DatabaseManager) request.getSession().getAttribute("store");
            service.disconnectDataBase(store);
            request.getSession().setAttribute("dbName", "");
            request.getRequestDispatcher("menu.do").forward(request, response);
        }catch (RuntimeException ex){
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
