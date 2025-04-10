//package zadanie_5;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//public class PrintMatrixTest {
//
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//
//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//    }
//
//    @Test
//    public void testPrintMatrix() {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//
//        Spiral.printMatrix(matrix);
//        String expectedOutput = "1, 2, 3, \n4, 5, 6, \n7, 8, 9, \n";
//        assertEquals(expectedOutput, outContent.toString());
//    }
//
//}
