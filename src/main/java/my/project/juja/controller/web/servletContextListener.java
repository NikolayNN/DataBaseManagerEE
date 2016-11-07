package my.project.juja.controller.web;

import my.project.juja.service.Service;
import my.project.juja.service.ServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Created by Nikol on 11/7/2016.
 */
public class servletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        Service service = new ServiceImpl();
        sc.setAttribute("service", service);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
