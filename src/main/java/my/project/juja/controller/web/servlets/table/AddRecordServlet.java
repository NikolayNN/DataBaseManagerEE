package my.project.juja.controller.web.servlets.table;

import my.project.juja.model.Storeable;
import my.project.juja.model.table.HeaderCell;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikol on 11/10/2016.
 */
public class AddRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Storeable store = (Storeable) request.getSession().getAttribute("store");
        String tableName = request.getParameter("inputedTableName");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void createTable(String tableName, Storeable store){
        List<HeaderCell>
    }
}
