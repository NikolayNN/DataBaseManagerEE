package my.project.juja.service;

        import my.project.juja.model.PostgresDataBase;
        import my.project.juja.model.Storeable;
        import my.project.juja.model.table.Table;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.Set;

/**
 * Created by Nikol on 10/10/2016.
 */
public class ServiceImpl implements Service {

    @Override
    public Storeable connectToServer(String serverURL, String userName, String password) {
        Storeable store = new PostgresDataBase();
        store.connectToServer(serverURL, userName, password);
        return store;
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
    public Map<String, String> commandList() {
        Map<String, String> commands = new HashMap<>();
        commands.put("menu", "menu.do");
        commands.put("help", "help.do");
        commands.put("connect to server", "connecttoserver.do");
        commands.put("available Databases", "basesnames.do");
        commands.put("connect to Databases", "connecttodatabase.do");
        commands.put("available tables", "tablelist.do");
        commands.put("Show table", "showtable.do");
        commands.put("Disconnect current DataBase", "disconnectdb.do");
        return commands;
    }


}
