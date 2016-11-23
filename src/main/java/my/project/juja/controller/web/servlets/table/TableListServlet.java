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
 * Created by Nikol on 11/7/2016.
 */
public class TableListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = (Service) getServletContext().getAttribute("service");
        Storeable store = (Storeable) request.getSession().getAttribute("store");
        request.setAttribute("tables", service.getTableList(store));
        request.getRequestDispatcher("tableList.jsp").forward(request, response);
    }
}
