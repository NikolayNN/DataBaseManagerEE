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
 * Created by Nikol on 11/2/2016.
 */
public class ConnectToServerServlet extends HttpServlet {
    Service service;

    @Override
    public void init() throws ServletException {
        service = new ServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serverUrl = request.getParameter("serverurl");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Storeable store = service.connectToServer(serverUrl, userName, password);
            request.getSession().setAttribute("store", store);
            request.getSession().setAttribute("serverUrl", serverUrl);
            response.sendRedirect(response.encodeRedirectURL("menu.do"));
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("connectToServer.jsp");
    }
}
