/**
 * Question 5:
 * Given an array of integers, find the distance between the two closest occurrences
 * of the minimum value in the array. The array is guaranteed to have the minimum at least twice.
 *
 * Example:
 * Input: [1,2,3,1,4,5,2]
 * Output: 3 (indexes 0 and 3 both have the minimum value 1)
 */
public class Question5_ClosestMinimumDistance {

    /**
     * Finds the smallest distance between two occurrences of the minimum element.
     *
     * @param arr Input array of integers.
     * @return The distance between two closest minimum values.
     */
    public static int findClosestMinDistance(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        // Step 1: Find the minimum value
        int minVal = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < minVal) {
                minVal = num;
            }
        }

        // Step 2: Track positions of min values and compute closest distance
        int prevIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == minVal) {
                if (prevIndex != -1) {
                    minDistance = Math.min(minDistance, i - prevIndex);
                }
                prevIndex = i;
            }
        }

        return minDistance;
    }

    /**
     * Test cases for verification.
     */
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 1, 4, 5, 2};
        System.out.println("Test 1 Output: " + findClosestMinDistance(test1));
        // Expected: 3

        int[] test2 = {5, 1, 1, 1, 5};
        System.out.println("Test 2 Output: " + findClosestMinDistance(test2));
        // Expected: 1 (between consecutive 1's)

        int[] test3 = {2, 2, 2, 2};
        System.out.println("Test 3 Output: " + findClosestMinDistance(test3));
        // Expected: 1 (all elements equal)

        int[] test4 = {10, 3, 5, 3, 10, 3};
        System.out.println("Test 4 Output: " + findClosestMinDistance(test4));
        // Expected: 2 (indexes 1 and 3)

        int[] test5 = {1, 9, 8, 7, 1, 2, 1};
        System.out.println("Test 5 Output: " + findClosestMinDistance(test5));
        // Expected: 2 (between index 4 and 6)
    }
}
