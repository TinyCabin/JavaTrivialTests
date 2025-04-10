package zadanie_5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SpiralTest {

    private Spiral solution;

    @Before
    public void setUp() {
        solution = new Spiral();
    }

    @Test
    public void testSpiralOrderExample1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        try {
            List<Integer> result = solution.spiralOrder(matrix);
            assertEquals(List.of(1, 4, 7, 8, 9, 6, 3, 2, 5), result);
        } catch (EmptyMatrixException e) {
            fail("Unexpected EmptyMatrixException");
        }
    }

    @Test
    public void testSpiralOrderExample2() {
        int[][] matrix = {
                {1}
        };

        try {
            List<Integer> result = solution.spiralOrder(matrix);
            assertEquals(List.of(1), result);
        } catch (EmptyMatrixException e) {
            fail("Unexpected EmptyMatrixException");
        }
    }

    @Test
    public void testSpiralOrderEmptyMatrix() {
        int[][] matrix = {};

        try {
            solution.spiralOrder(matrix);
            fail("Expected EmptyMatrixException");
        } catch (EmptyMatrixException e) {
            assertEquals("Macierz jest pusta.", e.getMessage());
        }
    }

}