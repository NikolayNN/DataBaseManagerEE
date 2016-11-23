package my.project.juja.controller.web.servlets.table;

import my.project.juja.model.DatabaseManager;
import my.project.juja.model.table.Table;
import my.project.juja.service.Service;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikol on 11/7/2016.
 */
@Component
public class ShowTableServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = (Service) getServletContext().getAttribute("service");
        DatabaseManager store = (DatabaseManager) request.getSession().getAttribute("store");
        request.setAttribute("tables", service.getTableList(store));
        Table tableToShow = service.getTableData(store, request.getParameter("selectedtable"));
        request.setAttribute("table", tableToShow);
        request.getRequestDispatcher("showTable.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseManager store = (DatabaseManager) request.getSession().getAttribute("store");
        Service service = (Service) request.getSession().getAttribute("service");
        request.setAttribute("tables", service.getTableList(store));
        request.getRequestDispatcher("showTable.jsp").forward(request, response);
    }
}
