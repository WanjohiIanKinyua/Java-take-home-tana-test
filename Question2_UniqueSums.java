import java.util.*;

/**
 * Question 2:
 * Given a target result and an array of integers, find the number of unique ways
 * to add elements from the array so that their sum equals the target.
 *
 * Example:
 * result = 10, array = [1,2,3,4,5] -> 3 ways:
 * 1+2+3+4, 1+4+5, 2+3+5
 */
public class Question2_UniqueSums {

    /**
     * Finds all unique combinations of numbers that sum up to the target.
     *
     * @param nums   The array of numbers.
     * @param target The target sum.
     * @return The total number of unique ways.
     */
    public static int countCombinations(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        printCombinations(result); // For debugging and verification
        return result.size();
    }

    /**
     * Helper method: Backtracking to explore all combinations.
     */
    private static void backtrack(int[] nums, int remaining, int start,
                                  List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }
        if (remaining < 0) {
            return; // Exceeded target
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, remaining - nums[i], i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }

    /**
     * Prints all found combinations for verification.
     */
    private static void printCombinations(List<List<Integer>> result) {
        if (result.isEmpty()) {
            System.out.println("No combinations found.");
        } else {
            System.out.println("Combinations found:");
            for (List<Integer> combination : result) {
                System.out.println(combination);
            }
        }
    }

    /**
     * Test the function with sample inputs.
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 10;
        System.out.println("Target: " + target1 + ", Ways: " + countCombinations(nums1, target1));
        // Expected: 3 (1+2+3+4, 1+4+5, 2+3+5)

        System.out.println();

        int[] nums2 = {1, 2, 4, 7, 5};
        int target2 = 17;
        System.out.println("Target: " + target2 + ", Ways: " + countCombinations(nums2, target2));
        // Expected: 1 (1+4+5+7)

        System.out.println();

        int[] nums3 = {2, 4, 6, 8};
        int target3 = 8;
        System.out.println("Target: " + target3 + ", Ways: " + countCombinations(nums3, target3));
        // Expected: 2 (2+6, 8)

        System.out.println();

        int[] nums4 = {5, 10, 12};
        int target4 = 20;
        System.out.println("Target: " + target4 + ", Ways: " + countCombinations(nums4, target4));
        // Expected: 0
    }
}
