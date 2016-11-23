package my.project.juja.controller.web.servlets.listener;

import my.project.juja.model.PostgresDatabaseManger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Nikol on 11/23/2016.
 */
public class SessionCreateListener implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("store", new PostgresDatabaseManger());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
