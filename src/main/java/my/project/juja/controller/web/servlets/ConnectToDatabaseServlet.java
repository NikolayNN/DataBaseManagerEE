package my.project.juja.controller.web.servlets;

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
    private Service service;

    @Override
    public void init() throws ServletException {
        service = (Service)getServletContext().getAttribute("service");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dbName = request.getParameter("dbname");
        try {
            service.connectToDataBase(dbName);
            response.sendRedirect("menu.do");
        } catch (RuntimeException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dbnames", service.getDataBaseNames());
        request.getRequestDispatcher("connectToDataBase.jsp").forward(request,response);
    }
}
