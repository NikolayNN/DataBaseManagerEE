package my.project.juja.controller.web;

import my.project.juja.service.Service;
import my.project.juja.service.ServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nikol on 10/8/2016.
 */
public class MainServlet extends HttpServlet {
    private Service service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new ServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        if (action.startsWith("/menu") || action.equals("/")) {
            req.setAttribute("items", service.commandList());
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        }
    }
    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        return requestURI.substring(req.getContextPath().length(), requestURI.length());
    }
}