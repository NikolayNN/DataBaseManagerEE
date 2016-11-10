package my.project.juja.utilsForTest;

import my.project.juja.model.table.HeaderCell;
import my.project.juja.model.table.Row;
import my.project.juja.model.table.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikol on 9/25/2016.
 */
public class TestTable {
    Table table;


    public TestTable() {
        table = createTable();
    }

    public Table getTable() {
        return table;
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
        Table table = new Table("testTable174856", headerCells);
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

}
