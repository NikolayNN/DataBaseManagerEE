package my.project.juja.model.table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikol on 9/7/2016.
 */
public class Table {
    private String name; // TODO final
    private HeaderRow headerRow; // TODO final
    private List<Row> rows;
    private int columnCount;// TODO final

    public Table(String name, HeaderRow headerRow) {
        this.name = name;
        this.headerRow = headerRow;
        this.columnCount = headerRow.size();
        rows = new ArrayList<>();
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public int getColumnCount() {
        return columnCount;
    }

    public HeaderRow getHeaderRow() {
        return headerRow;
    }

    public HeaderCell getCellInfo(int columnIndex) {
        return headerRow.getHeaderCell(columnIndex);
    }

    public List<Row> getRows() {
        return rows;
    }

    public Row getRow(int rowIndex) {
        return rows.get(rowIndex);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int[] maxLength = getMaxColumnsLengths(this);
        String columnNames = printColumnNames(maxLength);
        String tableHeaderSeparator = addSymbol("", columnNames.length(), "-");
        String rows = printRows(maxLength);
        result.append(name);
        result.append("\n");
        result.append(tableHeaderSeparator);
        result.append("\n");
        result.append(columnNames);
        result.append("\n");
        result.append(tableHeaderSeparator);
        result.append("\n");
        result.append(rows);
        return result.toString();
    }

    private String printRows(int[] maxLength) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.rows.size(); i++) {
            Row row = rows.get(i);
            for (int j = 0; j < columnCount; j++) {
                String value = row.getCell(j).getValue();
                result.append(value + addSymbol(value, maxLength[j], " "));
                result.append(" | ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private String printColumnNames(int[] maxLength) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < columnCount; i++) {
            String columnName = getCellInfo(i).getColumnName();
            result.append(columnName + addSymbol(columnName, maxLength[i], " "));
            result.append(" | ");
        }
        return result.toString();
    }

    private int[] getMaxColumnsLengths(Table table) {
        int[] result = new int[table.getColumnCount()];
        for (int i = 0; i < table.getColumnCount(); i++) {
            result[i] = getMaxLength(i);
        }
        return result;
    }

    private int getMaxLength(int columnIndex) {
        int max = getCellInfo(columnIndex).getColumnName().length();
        for (Row row : rows) {
            int currentLength = row.getCell(columnIndex).value.length();
            if (currentLength > max) {
                max = currentLength;
            }
        }
        return max;
    }

    private String addSymbol(String value, int maxLength, String symbol) {
        int count = maxLength - value.length();
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < count; i++) {
            result.append(symbol);
        }
        return result.toString();
    }
}
