package zadanie_3;

public class Mediana {
    public double Median(int[] nums1, int[] nums2) throws EmptyArrayException{
        if (nums1.length == 0 && nums2.length == 0) {
            throw new EmptyArrayException("Tablica danych jest pusta.");
        }


        if (nums1.length > nums2.length) {
            return Median(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionX = (left + right) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxX;
            if (partitionX == 0) {
                maxX = Integer.MIN_VALUE;
            } else {
                maxX = nums1[partitionX - 1];
            }
            int maxY;
            if (partitionY == 0) {
                maxY = Integer.MIN_VALUE;
            } else {
                maxY = nums2[partitionY - 1];
            }
            int minX;
            if (partitionX == m) {
                minX = Integer.MAX_VALUE;
            } else {
                minX = nums1[partitionX];
            }
            int minY;
            if (partitionY == n) {
                minY = Integer.MAX_VALUE;
            } else {
                minY = nums2[partitionY];
            }

            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return (double) Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                right = partitionX - 1;
            } else {
                left = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Niepoprawne wartosci wejsciowe.");
    }

    public static void main(String[] args) {
        Mediana solution = new Mediana();

        int[] num1 = {1, 3};
        int[] num2 = {2};
        System.out.println("Przyklad 1:");
        System.out.println("Wejscie: num1 = [" + (num1.length > 0 ? num1[0] : "") + ", " + (num1.length > 1 ? num1[1] : "") + "], num2 = [" + (num2.length > 0 ? num2[0] : "") + "]");
        try {
            System.out.println("Wyjscie: " + solution.Median(num1, num2));
        } catch (EmptyArrayException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        int[] num3 = {1, 2};
        int[] num4 = {3, 4};
        System.out.println("\nPrzykład 2:");
        System.out.println("Wejscie: num1 = [" + (num3.length > 0 ? num3[0] : "") + ", " + (num3.length > 1 ? num3[1] : "") + "], num2 = [" + (num4.length > 0 ? num4[0] : "") + "]");
        try {
            System.out.println("Wyjście: " + solution.Median(num3, num4));
        } catch (EmptyArrayException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}

class EmptyArrayException extends Exception {
    public EmptyArrayException(String message) {
        super(message);
    }
}