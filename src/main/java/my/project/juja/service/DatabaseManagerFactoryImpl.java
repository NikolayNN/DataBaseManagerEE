package my.project.juja.service;

import my.project.juja.model.DatabaseManager;

/**
 * Created by Nikol on 11/23/2016.
 */
public class DatabaseManagerFactoryImpl implements DatabaseManagerFactory {
    private String className;

    @Override
    public DatabaseManager createDatabaseManger(){
        try {
            return (DatabaseManager) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
