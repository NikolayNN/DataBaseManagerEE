package my.project.juja.controller.web.servlets.database;

import my.project.juja.model.Storeable;
import my.project.juja.service.Service;
import my.project.juja.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikol on 11/8/2016.
 */
public class DisconnectDataBaseServlet extends HttpServlet {
    private Service service;

    @Override
    public void init() throws ServletException {
        service = new ServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Storeable store = (Storeable) request.getSession().getAttribute("store");
        service.disconnectDataBase(store);
        request.getSession().setAttribute("dbName", "");
        request.getRequestDispatcher("menu.do").forward(request, response);
    }
}
