package my.project.juja.service;

        import my.project.juja.model.PostgresDataBase;
        import my.project.juja.model.Storeable;

        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Set;

/**
 * Created by Nikol on 10/10/2016.
 */
public class ServiceImpl implements Service {
    private Storeable store;

    public ServiceImpl() {
        store = new PostgresDataBase();
    }

    @Override
    public void connectToServer(String serverURL, String userName, String password) {
        store.connectToServer(serverURL, userName, password);
    }

    @Override
    public void connectToDataBase(String dataBaseName) {
        store.connectToDataBase(dataBaseName);
    }

    @Override
    public Set<String> getDataBaseNames() {
        return store.getDataBasesNames();
    }

    @Override
    public Set<String> getTableList() {
        return store.getTableList();
    }

    @Override
    public Map<String, String> commandList() {
        Map<String, String> commands = new HashMap<>();
        commands.put("menu", "menu.do");
        commands.put("help", "help.do");
        commands.put("connect to server", "connecttoserver.do");
        commands.put("available Databases", "basesnames.do");
        commands.put("connect to Databases", "connecttodatabase.do");
        return commands;
    }


}
