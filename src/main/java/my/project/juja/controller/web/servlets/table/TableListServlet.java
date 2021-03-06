package my.project.juja.controller.web.servlets.table;

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
public class TableListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = (Service) getServletContext().getAttribute("service");
        DatabaseManager store = (DatabaseManager) request.getSession().getAttribute("store");
        request.setAttribute("tables", service.getTableList(store));
        request.getRequestDispatcher("tableList.jsp").forward(request, response);
    }
}
