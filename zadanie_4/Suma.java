package zadanie_4;

import java.util.*;

public class Suma {
    public List<List<Integer>> suma(int[] nums) throws EmptyArrayException {
        if (nums.length == 0) {
            throw new EmptyArrayException("Tablica danych jest pusta.");
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[left], nums[right]);
                    if (!result.isEmpty() && !triplet.equals(result.get(result.size() - 1))) {
                        result.add(triplet);
                    } else if (result.isEmpty()) {
                        result.add(triplet);
                    }
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Suma solution = new Suma();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        try {
            List<List<Integer>> result1 = solution.suma(nums1);
            System.out.println("\nPrzykład 1:");
            System.out.println("Wejście: nums = " + Arrays.toString(nums1));
            System.out.println("Wyjście: " + result1);
        } catch (EmptyArrayException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        int[] nums2 = {0, 1, 1};
        try {
            List<List<Integer>> result2 = solution.suma(nums2);
            System.out.println("\nPrzykład 2:");
            System.out.println("Wejście: nums = " + Arrays.toString(nums2));
            System.out.println("Wyjście: " + result2);
        } catch (EmptyArrayException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        int[] nums3 = {0, 0, 0};
        try {
            List<List<Integer>> result3 = solution.suma(nums3);
            System.out.println("\nPrzykład 3:");
            System.out.println("Wejście: nums = " + Arrays.toString(nums3));
            System.out.println("Wyjście: " + result3);
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
