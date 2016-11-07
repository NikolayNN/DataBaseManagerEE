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
public class TableListServlet extends HttpServlet {
    private Service service;

    @Override
    public void init() throws ServletException {
        service = (Service)getServletContext().getAttribute("service");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tables", service.getTableList());
        request.getRequestDispatcher("tableList.jsp").forward(request, response);
    }
}
