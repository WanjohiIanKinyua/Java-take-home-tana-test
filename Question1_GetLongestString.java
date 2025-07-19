import java.util.*;

/**
 * Question 1:
 * Implement a function that returns the longest string from a given list
 * that meets two conditions:
 * 1. No two consecutive characters should be identical (e.g., "AABCD" is invalid).
 * 2. The string should only contain characters from a given valid character list.
 *
 * Example:
 * validCharacters: [A, B, C, D]
 * strings: ["AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"]
 * Expected Output: "ABCDABDCA"
 */
public class Question1_GetLongestString {

    /**
     * Finds the longest string that satisfies the given conditions.
     *
     * @param validCharacters A list of allowed characters.
     * @param strings An array of input strings to check.
     * @return The longest valid string, or an empty string if none is valid.
     */
    public static String getLongestString(List<Character> validCharacters, String[] strings) {
        // Convert validCharacters to a HashSet for O(1) lookup
        Set<Character> validSet = new HashSet<>(validCharacters);

        String longestValid = "";

        for (String str : strings) {
            if (isValidString(str, validSet)) {
                // Update longest string if current one is longer
                if (str.length() > longestValid.length()) {
                    longestValid = str;
                }
            }
        }

        return longestValid;
    }

    /**
     * Helper method to check if a string meets both conditions:
     * 1. Only valid characters.
     * 2. No consecutive identical characters.
     *
     * @param str The string to check.
     * @param validSet Set of valid characters.
     * @return true if valid, false otherwise.
     */
    private static boolean isValidString(String str, Set<Character> validSet) {
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            // Check if character is valid
            if (!validSet.contains(current)) {
                return false;
            }

            // Check for consecutive identical characters
            if (i > 0 && current == str.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Test the function with different cases.
     */
    public static void main(String[] args) {
        List<Character> validChars = Arrays.asList('A', 'B', 'C', 'D');

        String[] strings1 = {"AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"};
        System.out.println("Test 1 Output: " + getLongestString(validChars, strings1));
        // Expected: ABCDABDCA

        String[] strings2 = {"AA", "BB", "CC"};
        System.out.println("Test 2 Output: " + getLongestString(validChars, strings2));
        // Expected: "" (empty string)

        String[] strings3 = {"AB", "ACD", "BCD"};
        System.out.println("Test 3 Output: " + getLongestString(validChars, strings3));
        // Expected: ACD or BCD (both length 3)

        String[] strings4 = {"", "A", "B"};
        System.out.println("Test 4 Output: " + getLongestString(validChars, strings4));
        // Expected: A or B
    }
}
