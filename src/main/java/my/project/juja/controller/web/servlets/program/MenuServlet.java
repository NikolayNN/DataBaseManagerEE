package my.project.juja.controller.web.servlets.program;

import my.project.juja.service.Service;
import my.project.juja.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nikol on 11/1/2016.
 */
public class MenuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = (Service) getServletContext().getAttribute("service");
        request.setAttribute("items", service.commandList());
        request.getRequestDispatcher("menu.jsp").forward(request, response);
        //todo redirect to connect servlet if we hasn' connect
    }

}
