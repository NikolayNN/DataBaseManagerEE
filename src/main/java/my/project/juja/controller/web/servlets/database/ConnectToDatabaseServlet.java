package my.project.juja.controller.web.servlets.database;

import my.project.juja.model.DatabaseManager;
import my.project.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikol on 11/7/2016.
 */

public class ConnectToDatabaseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dbName = request.getParameter("dbname");
        try {
            Service service = (Service) getServletContext().getAttribute("service");
            DatabaseManager store = (DatabaseManager) request.getSession().getAttribute("store");
            service.connectToDataBase(store, dbName);
            request.getSession().setAttribute("dbName", dbName);
            response.sendRedirect("menu.do");
        } catch (RuntimeException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = (Service) getServletContext().getAttribute("service");
        DatabaseManager store = (DatabaseManager) request.getSession().getAttribute("store");
        request.setAttribute("dbnames", service.getDataBaseNames(store));
        request.getRequestDispatcher("connectToDataBase.jsp").forward(request, response);
    }
}
