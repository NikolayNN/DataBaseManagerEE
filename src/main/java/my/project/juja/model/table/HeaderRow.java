package my.project.juja.model.table;

import java.util.List;

/**
 * Created by Nikol on 11/10/2016.
 */
public class HeaderRow {
    private List<HeaderCell> headerCells;

    public HeaderRow(List<HeaderCell> headerCells) {
        this.headerCells = headerCells;
    }

    public List<HeaderCell> getHeaderCells() {
        return headerCells;
    }

    public int size(){
        return headerCells.size();
    }

    public HeaderCell getHeaderCell(int index){
        return headerCells.get(index);
    }

}
