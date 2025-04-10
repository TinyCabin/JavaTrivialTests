package zadanie_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CodeTest {

    private Code solution;

    @Before
    public void setUp() {
        solution = new Code();
    }

    @Test
    public void testConvertExample0() {
        String s = "PAYPALISHIRING";
        int numRows = 1;
        try {
            String result = solution.convert(s, numRows);
            assertEquals("PAYPALISHIRING", result);
        } catch (InvalidConversionException | EmptyStringException e) {
            fail("Unexpected InvalidConversionException");
        }
    }

    @Test
    public void testConvertExample1() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        try {
            String result = solution.convert(s, numRows);
            assertEquals("PAHNAPLSIIGYIR", result);
        } catch (InvalidConversionException | EmptyStringException e) {
            fail("Unexpected InvalidConversionException");
        }
    }

    @Test
    public void testConvertExample2() {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        try {
            String result = solution.convert(s, numRows);
            assertEquals("PINALSIGYAHRPI", result);
        } catch (InvalidConversionException | EmptyStringException e) {
            fail("Unexpected InvalidConversionException");
        }
    }

    @Test(expected = InvalidConversionException.class)
    public void testConvertInvalidNumRows() throws InvalidConversionException {
        String s = "PAYPALISHIRING";
        int numRows = 0;
        try {
            solution.convert(s, numRows);
        } catch (EmptyStringException e) {
        }
    }

    @Test(expected = EmptyStringException.class)
    public void testConvertEmptyString() throws EmptyStringException, InvalidConversionException {
        String s = "";
        int numRows = 2;
        solution.convert(s, numRows);
    }

}
