package my.project.juja.controller.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nikol on 10/8/2016.
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUrl = req.getRequestURI();
        String action = requestUrl.substring(req.getContextPath().length(), requestUrl.length());

        if(action.startsWith("/menu")){
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        }else if(action.startsWith("/help")) {
            req.getRequestDispatcher("help.jsp").forward(req, resp);
        }

    }
}