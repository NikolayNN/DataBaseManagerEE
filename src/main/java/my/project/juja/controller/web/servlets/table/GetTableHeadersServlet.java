package my.project.juja.controller.web.servlets.table;

import my.project.juja.model.Storeable;
import my.project.juja.model.table.HeaderCell;
import my.project.juja.model.table.HeaderRow;
import my.project.juja.service.Service;
import my.project.juja.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikol on 11/9/2016.
 */
public class GetTableHeadersServlet extends HttpServlet {
    private Service service;

    @Override
    public void init() throws ServletException {
        service = new ServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Storeable store = (Storeable) request.getSession().getAttribute("store");
        String tableName = request.getParameter("tableName");
        HeaderRow headerRow = store.getHeaderRow(tableName);
        request.setAttribute("columnHeaders", headerRow.getHeaderCells());
        request.setAttribute("columnNames", getColumnNames(headerRow.getHeaderCells()));
        request.setAttribute("inputedTableName", tableName);
        request.getRequestDispatcher("addRecord.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("addRecord.jsp");

    }

    private List<String> getColumnNames(List<HeaderCell> columnHeaders){
        List<String> columnNames = new ArrayList<>();
        for (HeaderCell headerCell : columnHeaders) {
            columnNames.add(headerCell.getColumnName());
        }
        return columnNames;
    }
}
