package my.project.juja.service;

import my.project.juja.model.DatabaseManager;
import my.project.juja.model.table.HeaderRow;
import my.project.juja.model.table.Table;

import java.util.Map;
import java.util.Set;

/**
 * Created by Nikol on 10/10/2016.
 */
public interface Service {

    void connectToServer(DatabaseManager store, String serverURL, String userName, String password);

    void connectToDataBase(DatabaseManager store, String dataBaseName);

    void disconnectDataBase(DatabaseManager store);

    Set<String> getDataBaseNames(DatabaseManager store);

    Set<String> getTableList(DatabaseManager store);

    Table getTableData(DatabaseManager store, String tableName);

    void createDatabase(DatabaseManager store, String dbName);

    void dropDatabase(DatabaseManager store, String dbName);

    HeaderRow getColumnHeaders(DatabaseManager store, String tableName);

    void addRecord(DatabaseManager store, Table table);

    void clearTable(DatabaseManager store, String tableName);

    void dropTable(DatabaseManager store, String tableName);

    Map<String, String> commandList();
}
