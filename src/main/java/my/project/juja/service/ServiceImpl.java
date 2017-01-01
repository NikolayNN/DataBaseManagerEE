package my.project.juja.service;

import my.project.juja.model.DatabaseManager;
import my.project.juja.model.table.HeaderRow;
import my.project.juja.model.table.Table;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Nikol on 10/10/2016.
 */

@Component
public class ServiceImpl implements Service {
    private Map<String, String> commands;

    public ServiceImpl(Map<String, String> commands) {
        this.commands = commands;
    }

    @Override
    public void connectToServer(DatabaseManager store, String serverURL, String userName, String password) {
        store.connectToServer(serverURL, userName, password);
    }

    @Override
    public void connectToDataBase(DatabaseManager store, String dataBaseName) {
        store.connectToDataBase(dataBaseName);
    }

    @Override
    public void disconnectDataBase(DatabaseManager store) {
        store.disconectDataBase();
    }

    @Override
    public Set<String> getDataBaseNames(DatabaseManager store) {
        return store.getDataBasesNames();
    }

    @Override
    public Set<String> getTableList(DatabaseManager store) {
        return store.getTableList();
    }

    @Override
    public Table getTableData(DatabaseManager store, String tableName) {
        return store.getTableData(tableName);
    }

    @Override
    public void createDatabase(DatabaseManager store, String dbName) {
        store.createDataBase(dbName);
    }

    @Override
    public void dropDatabase(DatabaseManager store, String dbName) {
        store.dropDataBase(dbName);
    }

    @Override
    public HeaderRow getColumnHeaders(DatabaseManager store, String tableName) {
        return store.getHeaderRow(tableName);
    }

    @Override
    public void addRecord(DatabaseManager store, Table table) {
        store.addRecord(table);
    }

    @Override
    public void clearTable(DatabaseManager store, String tableName) {
        store.clearTable(tableName);
    }

    @Override
    public void dropTable(DatabaseManager store, String tableName) {
        store.dropTable(tableName);
    }

    @Override
    public Map<String, String> getCommands() {
        return commands;
    }
}
