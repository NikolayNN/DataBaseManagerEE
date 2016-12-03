package my.project.juja.controller.web.servlets.listener;


import my.project.juja.service.DatabaseManagerFactory;
import my.project.juja.service.Service;
import my.project.juja.service.ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Nikol on 11/23/2016.
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        Service service = (Service) springContext.getBean("serviceImpl");
        sce.getServletContext().setAttribute("service", service);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
