package my.project.juja.controller.web.servlets.listener;

import my.project.juja.model.DatabaseManager;
import my.project.juja.model.PostgresDatabaseManger;
import my.project.juja.service.DatabaseManagerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Nikol on 11/23/2016.
 */

public class SessionCreateListener implements HttpSessionListener{
    private DatabaseManagerFactory databaseManagerFactory;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
        databaseManagerFactory = (DatabaseManagerFactory) context.getBean("databaseManagerFactory");
        se.getSession().setAttribute("store", databaseManagerFactory.createDatabaseManger());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

}
