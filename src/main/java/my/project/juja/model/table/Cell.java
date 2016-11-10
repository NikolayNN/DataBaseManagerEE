package my.project.juja.model.table;

/**
 * Created by Nikol on 8/22/2016.
 */
public class Cell {
    HeaderCell headerCell;
    String value;

    public HeaderCell getHeaderCell() {
        return headerCell;
    }

    public String getValue() {
        return value;
    }

    public String getColumnName() {
        return headerCell.getColumnName();
    }

    public Cell(HeaderCell headerCell) {
        this.headerCell = headerCell;
    }

    public Cell(HeaderCell headerCell, String value) {
        this.headerCell = headerCell;
        this.value = value;
    }

    public void setValue(String value, boolean check) {
        if (!check) {
            this.value = value;
            return;
        }
        if (value.equals("") && !headerCell.isCanBeNull()) {
            throw new IllegalArgumentException("column \"" + headerCell.getColumnName() + "\" can't be null");
        }
        this.value = value;

    }


}
