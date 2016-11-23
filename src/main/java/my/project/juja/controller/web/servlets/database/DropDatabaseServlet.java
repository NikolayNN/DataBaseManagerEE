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
public class DropDatabaseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Service service = (Service) getServletContext().getAttribute("service");
            DatabaseManager store = (DatabaseManager) request.getSession().getAttribute("store");
            service.dropDatabase(store, request.getParameter("dbname"));
            response.sendRedirect("/menu.do");
        }catch (RuntimeException ex){
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("dropDatabase.jsp");
    }
}
