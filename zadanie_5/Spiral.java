package zadanie_5;

import java.util.*;

public class Spiral {
    public List<Integer> spiralOrder(int[][] matrix) throws EmptyMatrixException{
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            throw new EmptyMatrixException("Macierz jest pusta.");
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][left]);
            }
            left++;

            if (top <= bottom) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][right]);
                }
                right--;
            }

            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[top][i]);
                }
                top++;
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Spiral solution = new Spiral();

//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

        int[][] matrix = {
                {1, 2},
                {4, 5},
        };

//        int[][] matrix = {
//                {},
//        };

        System.out.println("Macierz:");
        printMatrix(matrix);

        try {
            List<Integer> result = solution.spiralOrder(matrix);
            System.out.println("Elementy macierzy w kolejnosci spiralnej:");
            System.out.println(result);
        } catch (EmptyMatrixException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}

class EmptyMatrixException extends Exception {
    public EmptyMatrixException(String message) {
        super(message);
    }
}