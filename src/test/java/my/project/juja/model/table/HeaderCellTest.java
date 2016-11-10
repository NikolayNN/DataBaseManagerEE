package my.project.juja.model.table;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nikol on 9/27/2016.
 */
public class HeaderCellTest {
    HeaderCell testHeaderCell;

    @Before
    public void setup() {
        testHeaderCell = new HeaderCell("TestColumnName", "integer", false, false, 0);
    }

    @Test
    public void getTypeTest() {
        assertEquals("integer", testHeaderCell.getType());
    }

    @Test
    public void getLengthTest() {
        assertEquals(0, testHeaderCell.getLength());
    }

    @Test
    public void isHasDefault() {
        assertEquals(false, testHeaderCell.isHasDefault());
    }

}
