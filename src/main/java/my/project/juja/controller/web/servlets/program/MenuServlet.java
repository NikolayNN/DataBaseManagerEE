package my.project.juja.controller.web.servlets.program;

import my.project.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikol on 11/1/2016.
 */
public class MenuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = (Service) getServletContext().getAttribute("service");
        request.setAttribute("items", service.getCommands());
        request.getRequestDispatcher("menu.jsp").forward(request, response);
        //todo redirect to connect servlet if we hasn' connect
    }

}
