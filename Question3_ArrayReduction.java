/**
 * Question 3:
 * You are given an integer array `a` with positive elements.
 * The goal is to make all elements zero (except the first) by repeatedly applying:
 * a[i] = a[i] - a[i-1] for i > 0
 * Return 1 if possible, else 0.
 *
 * Example:
 * a = [1, 2, 3]
 * Steps:
 * [1, 2, 3] -> choose i=3 -> [1, 2, 1]
 * choose i=2 -> [1, 1, 1]
 * choose i=3 -> [1, 1, 0]
 * choose i=2 -> [1, 0, 0]
 * Output: 1 (possible)
 */
public class Question3_ArrayReduction {

    /**
     * Checks if it's possible to make all elements zero except the first
     * using the given operation.
     *
     * @param arr The input array with positive integers.
     * @return 1 if possible, 0 otherwise.
     */
    public static int canReduceToZero(int[] arr) {
        // The logic: For the operation to work, the array must be non-decreasing.
        // Because a[i] will always reduce by a[i-1], and we can't allow negative numbers.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return 0; // Not possible if any element is smaller than the previous
            }
        }
        return 1; // Possible if array is non-decreasing
    }

    /**
     * Test cases for verification.
     */
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        System.out.println("Result for [1,2,3]: " + canReduceToZero(test1));
        // Expected: 1

        int[] test2 = {2, 4, 8};
        System.out.println("Result for [2,4,8]: " + canReduceToZero(test2));
        // Expected: 1 (non-decreasing)

        int[] test3 = {3, 6, 14};
        System.out.println("Result for [3,6,14]: " + canReduceToZero(test3));
        // Expected: 1

        int[] test4 = {5, 3, 7};
        System.out.println("Result for [5,3,7]: " + canReduceToZero(test4));
        // Expected: 0 (because 3 < 5)

        int[] test5 = {1};
        System.out.println("Result for [1]: " + canReduceToZero(test5));
        // Expected: 1 (only one element)
    }
}
