package zadanie_4;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SumaPerformanceTest {

    private Suma solution;
    private int[] largeArray;

    @Before
    public void setUp() {
        solution = new Suma();
        largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i;
        }
    }

    @Test(timeout = 1000)
    public void testPerformance() throws EmptyArrayException {
        List<List<Integer>> result = solution.suma(largeArray);
        assertTrue(result.isEmpty());
    }
}
