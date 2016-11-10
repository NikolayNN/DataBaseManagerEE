package my.project.juja.model.table;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nikol on 9/27/2016.
 */
public class CellTest {

    @Test
    public void test() {
//        given
        HeaderCell headerCell = new HeaderCell("columnName", "character", false, false, 0);
        String value = "columnValue";
//when
        Cell cell = new Cell(headerCell, value);
//then
        assertEquals("[columnName*(character)]", cell.getHeaderCell().toString());
    }
}
