package my.project.juja.service;

import my.project.juja.model.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by Nikol on 11/23/2016.
 */
public class DatabaseManagerFactoryImpl implements DatabaseManagerFactory {
    private String className;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public DatabaseManager createDatabaseManger(){
        return (DatabaseManager) applicationContext.getBean(className);
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
