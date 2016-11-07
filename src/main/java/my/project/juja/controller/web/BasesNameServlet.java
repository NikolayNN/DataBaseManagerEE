package my.project.juja.controller.web;

import my.project.juja.service.Service;
import my.project.juja.service.ServiceImpl;

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
public class BasesNameServlet extends HttpServlet {
    private Service service;

    @Override
    public void init() throws ServletException {
        service = (Service)getServletContext().getAttribute("service");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("databases", service.getDataBaseNames());
        request.getRequestDispatcher("dataBases.jsp").forward(request,response);
    }
}
