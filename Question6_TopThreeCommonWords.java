import java.util.*;

/**
 * Question 6:
 * Given a sentence, return the three most common strings in it, sorted alphabetically.
 *
 * Example:
 * Input: "hi there care to discuss algorithm basis or how to solve algorithm or"
 * Output: ["algorithm", "or", "to"]
 */
public class Question6_TopThreeCommonWords {

    /**
     * Finds the three most common words in a sentence.
     *
     * @param sentence Input sentence (words separated by spaces).
     * @return A list of the top three words in ascending alphabetical order.
     */
    public static List<String> topThreeCommonWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return new ArrayList<>();
        }

        // Normalize to lowercase and split into words
        String[] words = sentence.toLowerCase().split("\\s+");

        // Count frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Sort by frequency (descending), then alphabetically
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(freqMap.entrySet());
        sortedEntries.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // Higher frequency first
            }
            return a.getKey().compareTo(b.getKey()); // Alphabetical if tie
        });

        // Take top 3 words
        List<String> topThree = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedEntries.size()); i++) {
            topThree.add(sortedEntries.get(i).getKey());
        }

        // Sort result alphabetically as per requirement
        Collections.sort(topThree);
        return topThree;
    }

    /**
     * Test cases for verification.
     */
    public static void main(String[] args) {
        String input1 = "hi there care to discuss algorithm basis or how to solve algorithm or";
        System.out.println("Test 1 Output: " + topThreeCommonWords(input1));
        // Expected: ["algorithm", "or", "to"]

        String input2 = "apple banana apple orange banana apple grape";
        System.out.println("Test 2 Output: " + topThreeCommonWords(input2));
        // Expected: ["apple", "banana", "grape"]

        String input3 = "one two two three three three four four four four";
        System.out.println("Test 3 Output: " + topThreeCommonWords(input3));
        // Expected: ["four", "three", "two"]

        String input4 = "a b c";
        System.out.println("Test 4 Output: " + topThreeCommonWords(input4));
        // Expected: ["a", "b", "c"]

        String input5 = "";
        System.out.println("Test 5 Output: " + topThreeCommonWords(input5));
        // Expected: []
    }
}
