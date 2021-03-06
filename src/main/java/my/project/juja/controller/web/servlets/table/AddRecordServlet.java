package my.project.juja.controller.web.servlets.table;

import my.project.juja.model.DatabaseManager;
import my.project.juja.model.table.*;
import my.project.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Nikol on 11/10/2016.
 */
public class AddRecordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Service service = (Service) getServletContext().getAttribute("service");
            DatabaseManager store = (DatabaseManager) request.getSession().getAttribute("store");
            String tableName = request.getParameter("inputedTableName");
            Table tableToAdd = createTable(tableName, store, request);
            service.addRecord(store, tableToAdd);
            response.sendRedirect("/menu.do");
        } catch (RuntimeException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private Table createTable(String tableName, DatabaseManager store, HttpServletRequest request){
        HeaderRow headerRow = store.getHeaderRow(tableName);
        Table table = new Table(tableName, headerRow);
        Row row = new Row(headerRow);
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameter = parameterNames.nextElement();
            for (Cell cell : row.getCells()) {
                if(cell.getColumnName().equals(parameter)){
                    String value = request.getParameter(parameter);
                    cell.setValue(value, true);
                }
            }
        }
        table.addRow(row);
        return table;
    }
}
