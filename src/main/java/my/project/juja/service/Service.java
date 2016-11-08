package my.project.juja.service;

import my.project.juja.model.Storeable;
import my.project.juja.model.table.Table;

import java.util.Map;
import java.util.Set;

/**
 * Created by Nikol on 10/10/2016.
 */
public interface Service {
    Storeable connectToServer(String serverURL, String userName, String password);


    void connectToDataBase(Storeable store, String dataBaseName);

    void disconnectDataBase(Storeable store);

    Set<String> getDataBaseNames(Storeable store);

    Set<String> getTableList(Storeable store);

    Table getTableData(Storeable store, String tableName);

    Map<String, String> commandList();
}
