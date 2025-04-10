package zadanie_4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SumaTest {

    private Suma solution;

    @Before
    public void setUp() {
        solution = new Suma();
    }

    @Test
    public void testSumaExample1() {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        try {
            List<List<Integer>> result1 = solution.suma(nums1);
            assertEquals(2, result1.size());
            assertTrue(result1.contains(List.of(-1, -1, 2)));
            assertTrue(result1.contains(List.of(-1, 0, 1)));
        } catch (EmptyArrayException e) {
            fail("Unexpected EmptyArrayException");
        }
    }

    @Test
    public void testSumaExample2() {
        int[] nums2 = {0, 1, 1};
        try {
            List<List<Integer>> result2 = solution.suma(nums2);
            assertEquals(0, result2.size());
        } catch (EmptyArrayException e) {
            fail("Unexpected EmptyArrayException");
        }
    }

    @Test
    public void testSumaExample3() {
        int[] nums3 = {0, 0, 0};
        try {
            List<List<Integer>> result3 = solution.suma(nums3);
            assertEquals(1, result3.size());
            assertTrue(result3.contains(List.of(0, 0, 0)));
        } catch (EmptyArrayException e) {
            fail("Unexpected EmptyArrayException");
        }
    }

    @Test(expected = EmptyArrayException.class)
    public void testSumaEmptyArray() throws EmptyArrayException {
        int[] nums = {};
        solution.suma(nums);
    }

}
