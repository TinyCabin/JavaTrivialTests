package zadanie_1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private Sorter sorter;

    @Before
    public void setUp() {
        sorter = new Sorter(null);
    }

    @Test
    public void testSortBubbleSort() {
        int[] input = {5, 3, 8, 4, 2, 7, 1, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        sorter = new Sorter(new BubbleSort());
        try {
            sorter.sort(input);
            assertArrayEquals(expected, input);
        } catch (InvalidSortingAlgorithmException e) {
            fail("Unexpected InvalidSortingAlgorithmException");
        }
    }

    @Test
    public void testSortInsertionSort() {
        int[] input = {5, 3, 8, 4, 2, 7, 1, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        sorter = new Sorter(new InsertionSort());
        try {
            sorter.sort(input);
            assertArrayEquals(expected, input);
        } catch (InvalidSortingAlgorithmException e) {
            fail("Unexpected InvalidSortingAlgorithmException");
        }
    }

    @Test
    public void testSortMergeSort() {
        int[] input = {5, 3, 8, 4, 2, 7, 1, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        sorter = new Sorter(new MergeSort());
        try {
            sorter.sort(input);
            assertArrayEquals(expected, input);
        } catch (InvalidSortingAlgorithmException e) {
            fail("Unexpected InvalidSortingAlgorithmException");
        }
    }

    @Test
    public void testSortQuickSort() {
        int[] input = {5, 3, 8, 4, 2, 7, 1, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        sorter = new Sorter(new QuickSort());
        try {
            sorter.sort(input);
            assertArrayEquals(expected, input);
        } catch (InvalidSortingAlgorithmException e) {
            fail("Unexpected InvalidSortingAlgorithmException");
        }
    }

    @Test
    public void testSortSelectionSort() {
        int[] input = {5, 3, 8, 4, 2, 7, 1, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        sorter = new Sorter(new SelectionSort());
        try {
            sorter.sort(input);
            assertArrayEquals(expected, input);
        } catch (InvalidSortingAlgorithmException e) {
            fail("Unexpected InvalidSortingAlgorithmException");
        }
    }

    @Test(expected = InvalidSortingAlgorithmException.class)
    public void testSortInvalidAlgorithm() throws InvalidSortingAlgorithmException {
        sorter.sort(new int[] {1, 2, 3});
    }

    @Test
    public void testSortTime() {
        Random random = new Random();
        int[] input = new int[1000];
        int[] expected = new int[1000];
        for (int i = 0; i < input.length; i++) {
            int num = random.nextInt(1000);
            input[i] = num;
            expected[i] = num;
        }
        Arrays.sort(expected);

        sorter = new Sorter(new QuickSort());
        long startTime = System.nanoTime();
        try {
            sorter.sort(input);
        } catch (InvalidSortingAlgorithmException e) {
            fail("Unexpected InvalidSortingAlgorithmException");
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Czas sortowania szybkiego: " + duration + " nanosekund");

        assertArrayEquals(expected, input);
    }
}