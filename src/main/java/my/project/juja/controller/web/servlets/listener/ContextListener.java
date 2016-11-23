package my.project.juja.controller.web.servlets.listener;


import my.project.juja.service.DatabaseManagerFactory;
import my.project.juja.service.ServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Nikol on 11/23/2016.
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context INIT!!!!!!!!!!!!");
        sce.getServletContext().setAttribute("service", new ServiceImpl());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
