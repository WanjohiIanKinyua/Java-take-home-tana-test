import java.util.*;

/**
 * Question 4:
 * Find the first product in an array that occurs only once.
 * If no unique product exists, return null.
 *
 * Example:
 * Input: ["Apple", "Computer", "Apple", "Bag"]
 * Output: "Computer"
 */
public class Question4_FirstUniqueProduct {

    /**
     * Finds the first unique product in the array.
     *
     * @param products Array of product names.
     * @return The first unique product or null if none exists.
     */
    public static String firstUniqueProduct(String[] products) {
        if (products == null || products.length == 0) {
            return null;
        }

        // Step 1: Count occurrences of each product
        Map<String, Integer> frequencyMap = new LinkedHashMap<>(); // preserves insertion order
        for (String product : products) {
            frequencyMap.put(product, frequencyMap.getOrDefault(product, 0) + 1);
        }

        // Step 2: Find the first product with frequency 1
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null; // No unique product found
    }

    /**
     * Test cases for the function.
     */
    public static void main(String[] args) {
        String[] test1 = {"Apple", "Computer", "Apple", "Bag"};
        System.out.println("Test 1 Output: " + firstUniqueProduct(test1));
        // Expected: "Computer"

        String[] test2 = {"Pen", "Pen", "Book", "Book", "Eraser"};
        System.out.println("Test 2 Output: " + firstUniqueProduct(test2));
        // Expected: "Eraser"

        String[] test3 = {"Laptop", "Laptop"};
        System.out.println("Test 3 Output: " + firstUniqueProduct(test3));
        // Expected: null

        String[] test4 = {};
        System.out.println("Test 4 Output: " + firstUniqueProduct(test4));
        // Expected: null

        String[] test5 = {"One"};
        System.out.println("Test 5 Output: " + firstUniqueProduct(test5));
        // Expected: "One"
    }
}
