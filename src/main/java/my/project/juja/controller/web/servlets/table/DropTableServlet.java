package my.project.juja.controller.web.servlets.table;

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
 * Created by Nikol on 11/13/2016.
 */
@Component
public class DropTableServlet extends HttpServlet {
    @Autowired
    private Service service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Storeable store = (Storeable) request.getSession().getAttribute("store");
            service.dropTable(store, request.getParameter("tableName"));
            response.sendRedirect("menu.do");
        } catch (RuntimeException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Storeable store = (Storeable) request.getSession().getAttribute("store");
        request.setAttribute("tables", service.getTableList(store));
        request.getRequestDispatcher("dropTable.jsp").forward(request, response);
    }
}