package zadanie_3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class MedianaTest {

    private Mediana solution;

    @Before
    public void setUp() {
        solution = new Mediana();
    }

    @Test
    public void testMedianExample1() {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        try {
            double result = solution.Median(num1, num2);
            assertEquals(2.0, result, 0.001);
        } catch (EmptyArrayException e) {
            fail("Unexpected EmptyArrayException");
        }
    }

    @Test
    public void testMedianExample2() {
        int[] num3 = {1, 2};
        int[] num4 = {3, 4};
        try {
            double result = solution.Median(num3, num4);
            assertEquals(2.5, result, 0.001);
        } catch (EmptyArrayException e) {
            fail("Unexpected EmptyArrayException");
        }
    }

    @Test
    public void testMedianExample3() {
        int[] num3 = {};
        int[] num4 = {3, 4};
        try {
            double result = solution.Median(num3, num4);
            assertEquals(3.5, result, 0.001);
        } catch (EmptyArrayException e) {
            fail("Unexpected EmptyArrayException");
        }
    }

    @Test
    public void testMedianEmptyArrays() {
        int[] num1 = {};
        int[] num2 = {};
        try {
            solution.Median(num1, num2);
            fail("Expected EmptyArrayException, but no exception was thrown");
        } catch (EmptyArrayException e) {
            assertEquals("Tablica danych jest pusta.", e.getMessage());
        }
    }

}
