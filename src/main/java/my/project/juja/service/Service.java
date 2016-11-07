package my.project.juja.service;

import my.project.juja.model.table.Table;

import java.util.Map;
import java.util.Set;

/**
 * Created by Nikol on 10/10/2016.
 */
public interface Service {
    void connectToServer(String serverURL, String userName, String password);

    void connectToDataBase(String dataBaseName);

    Set<String> getDataBaseNames();

    Set<String> getTableList();

    Table getTableData(String tableName);

    Map<String, String> commandList();
}
