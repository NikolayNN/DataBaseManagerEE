package my.project.juja.controller.web.servlets;

import my.project.juja.model.Storeable;
import my.project.juja.service.Service;
import my.project.juja.service.ServiceImpl;

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
        service = new ServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dbName = request.getParameter("dbname");
        try {
            Storeable store = (Storeable) request.getSession().getAttribute("store");
            service.connectToDataBase(store, dbName);
            response.sendRedirect("menu.do");
        } catch (RuntimeException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Storeable store = (Storeable) request.getSession().getAttribute("store");
        request.setAttribute("dbnames", service.getDataBaseNames(store));
        request.getRequestDispatcher("connectToDataBase.jsp").forward(request, response);
    }
}
