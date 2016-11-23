package my.project.juja.service;

        import my.project.juja.model.PostgresDataBase;
        import my.project.juja.model.Storeable;
        import my.project.juja.model.table.HeaderRow;
        import my.project.juja.model.table.Table;
        import org.springframework.stereotype.Component;

        import java.util.*;

/**
 * Created by Nikol on 10/10/2016.
 */

@Component
public class ServiceImpl implements Service {

    @Override
    public void connectToServer(Storeable store, String serverURL, String userName, String password) {
        store.connectToServer(serverURL, userName, password);
    }

    @Override
    public void connectToDataBase(Storeable store, String dataBaseName) {
        store.connectToDataBase(dataBaseName);
    }

    @Override
    public void disconnectDataBase(Storeable store){
        store.disconectDataBase();
    }

    @Override
    public Set<String> getDataBaseNames(Storeable store) {
        return store.getDataBasesNames();
    }

    @Override
    public Set<String> getTableList(Storeable store) {
        return store.getTableList();
    }

    @Override
    public Table getTableData(Storeable store, String tableName){
        return store.getTableData(tableName);
    }

    @Override
    public void createDatabase(Storeable store, String dbName){
        store.createDataBase(dbName);
    }

    @Override
    public void dropDatabase(Storeable store, String dbName){
        store.dropDataBase(dbName);
    }

    @Override
    public HeaderRow getColumnHeaders(Storeable store, String tableName){
        return store.getHeaderRow(tableName);
    }

    @Override
    public void addRecord(Storeable store, Table table){
        store.addRecord(table);
    }

    @Override
    public void clearTable(Storeable store, String tableName){
        store.clearTable(tableName);
    }

    @Override
    public void dropTable(Storeable store, String tableName){
        store.dropTable(tableName);
    }

    @Override
    public Map<String, String> commandList() {
        Map<String, String> commands = new HashMap<>();
        commands.put("menu", "menu.do");
        commands.put("help", "help.do");
        commands.put("connect to server", "connecttoserver.do");
        commands.put("available Databases", "basesnames.do");
        commands.put("connect to Databases", "connecttodatabase.do");
        commands.put("available tables", "tablelist.do");
        commands.put("Show table", "showtable.do");
        commands.put("Disconnect current Database", "disconnectdb.do");
        commands.put("Create new Database", "createdb.do");
        commands.put("Drop Database", "dropdb.do");
        commands.put("Add record", "gettableheaders.do");
        commands.put("Clear Table", "cleartable.do");
        commands.put("Drop Table", "droptable.do");
        return commands;
    }


}
