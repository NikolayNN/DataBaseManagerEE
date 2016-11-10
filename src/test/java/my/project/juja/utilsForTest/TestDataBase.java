package my.project.juja.utilsForTest;

import my.project.juja.model.PostgresDataBase;
import my.project.juja.model.Storeable;
import my.project.juja.model.table.HeaderCell;
import my.project.juja.model.table.Row;
import my.project.juja.model.table.Table;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Nikol on 9/23/2016.
 */
public class TestDataBase {
    private Storeable store;
    private Properties properties;
    private String dbName;
    private String tableName;
    private String login;
    private String password;
    private String serverURL;
    private Table table;

    public Table getTable() {
        return table;
    }

    public TestDataBase() {

        properties = getProperties();
        store = new PostgresDataBase();
        serverURL = properties.getProperty("server.url");
        login = properties.getProperty("server.login");
        password = properties.getProperty("server.password");
        store.connectToServer(serverURL, login, password);
        dbName = properties.getProperty("test.dbName");
        tableName = properties.getProperty("test.tableName");
    }

    public void createTestDataBase() {
        try {
            store.createDataBase(dbName);
        } catch (RuntimeException ex) {
            store.dropDataBase(dbName);
            store.createDataBase(dbName);
        }
        store.disconectDataBase();
    }

    public void dropTestDataBase() {
        store.disconectDataBase();
        store.dropDataBase(dbName);
    }

    public void createTestTable() {
        store.connectToDataBase(dbName);
        try {
            store.dropTable(tableName);
        } catch (RuntimeException ex) {

        }
        table = createTable();
        store.createTable(tableName, table.getTableHeader());
        store.addRecord(table);

        store.disconectDataBase();
    }

    private List<HeaderCell> createCellInfos() {
        List<HeaderCell> headerCells = new ArrayList<>();
        headerCells.add(new HeaderCell("id", "integer", false, false, 0));
        headerCells.add(new HeaderCell("firstName", "text", false, false, 1));
        headerCells.add(new HeaderCell("lastName", "text", true, false, 2));
        HeaderCell column4 = new HeaderCell("password", "character", false, false, 3);
        column4.setLength(256);
        headerCells.add(column4);
        return headerCells;
    }

    private Table createTable() {
        List<HeaderCell> headerCells = createCellInfos();
        Table table = new Table(tableName, headerCells);
        Row row1 = new Row(headerCells);
        row1.getCell(0).setValue("1", false);
        row1.getCell(1).setValue("Vasya", false);
        row1.getCell(2).setValue("Pupkin", false);
        row1.getCell(3).setValue("qwerty", false);
        Row row2 = new Row(headerCells);
        row2.getCell(0).setValue("2", false);
        row2.getCell(1).setValue("Kirril", false);
        row2.getCell(2).setValue("Ivanov", false);
        row2.getCell(3).setValue("0000", false);
        Row row3 = new Row(headerCells);
        row3.getCell(0).setValue("3", false);
        row3.getCell(1).setValue("Pasha", false);
        row3.getCell(2).setValue("Sidorov", false);
        row3.getCell(3).setValue("157862asdw", false);
        table.addRow(row1);
        table.addRow(row2);
        table.addRow(row3);
        return table;
    }


    private Properties getProperties() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
        } catch (IOException e) {
            System.err.println("ERROR. property file is not exist");
        }
        return property;
    }

    public String getDbName() {
        return dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getServerURL() {
        return serverURL;
    }
}
