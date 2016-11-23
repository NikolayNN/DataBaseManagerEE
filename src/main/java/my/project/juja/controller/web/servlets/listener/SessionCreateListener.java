package my.project.juja.controller.web.servlets.listener;

import my.project.juja.model.PostgresDataBase;
import my.project.juja.service.ServiceImpl;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Nikol on 11/23/2016.
 */
public class SessionCreateListener implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("store", new PostgresDataBase());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
