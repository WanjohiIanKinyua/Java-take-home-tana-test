Take-Home Tana Test – Java Solutions

Environment
•	Programming Language: Java 21 (OpenJDK)
•	Compiler: javac 21.0.7
•	Runtime: Java SE Runtime Environment (OpenJDK)

Project Structure
take-home-tana-test
•	Question1_GetLongestString.java
•	Question2_UniqueSumCombinations.java
•	Question3_ArrayReduction.java
•	Question4_FirstUniqueProduct.java
•	Question5_ClosestMinimumDistance.java
•	Question6_TopThreeCommonWords.java
•	Question7_RotateList.java
•	README.md

How to Run
1.	Open a terminal in the project directory.
2.	Compile the Java file:

javac Question1_GetLongestString.java

3.	Run the program:

```java Question1_GetLongestString```

4.	Repeat steps 2 and 3 for each question file.

Solutions Summary
Question 1 – Longest Valid String
•	Approach: Checks each string to ensure no consecutive identical characters and only valid characters are allowed. Returns the longest valid string.
•	Run:
```
javac Question1_GetLongestString.java
java Question1_GetLongestString
```

Question 2 – Unique Sum Combinations
•	Approach: Uses backtracking to count all unique combinations of numbers in the array that sum to the target result.
•	Run:
```
javac Question2_UniqueSumCombinations.java
java Question2_UniqueSumCombinations
```
Question 3 – Array Reduction
•	Approach: Checks if each element (from the second onward) is divisible by its previous element. If so, the array can be reduced to zeros except the first element.
•	Run:
```
javac Question3_ArrayReduction.java
java Question3_ArrayReduction
```
Question 4 – First Unique Product
•	Approach: Uses a LinkedHashMap to maintain insertion order while counting occurrences. Returns the first product appearing only once.
•	Run:
```
javac Question4_FirstUniqueProduct.java
java Question4_FirstUniqueProduct
```
Question 5 – Closest Minimum Distance
•	Approach: Finds all indices of the minimum value and computes the smallest gap between consecutive occurrences.
•	Run:
```
javac Question5_ClosestMinimumDistance.java
java Question5_ClosestMinimumDistance
```
Question 6 – Top Three Common Words
•	Approach: Splits the sentence into words, counts frequency using a HashMap, sorts by frequency and then alphabetically, returns top 3 in ascending order.
•	Run:
```
javac Question6_TopThreeCommonWords.java
java Question6_TopThreeCommonWords
```

Question 7 – Rotate Linked List
•	Approach: Calculates list length, makes it circular, adjusts rotation steps, and breaks the circle at the new tail.
•	Run:
```
javac Question7_RotateList.java
java Question7_RotateList
```
Test Files
### Test File for Question 1

**File:** `Test_Question1.java`
```
import java.util.*;
public class Test_Question1 {
    public static void main(String[] args) {
        List<Character> validChars = Arrays.asList('A','B','C','D');

        // Test 1
        String[] arr1 = {"AABCDA","ABCDZADC","ABCDBCA","ABCDABDCA"};
        System.out.println("Expected: ABCDABDCA | Got: " +
            Question1_GetLongestString.getLongestString(validChars, arr1));

        // Test 2 - Edge case
        String[] arr2 = {"ZZZ","YYY"};
        System.out.println("Expected: '' | Got: " +
            Question1_GetLongestString.getLongestString(validChars, arr2));
    }
}
```
### Test File for Question 2

**File:** `Test_Question2.java`
```
import java.util.*;
public class Test_Question2 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        System.out.println("Expected: 3 | Got: " +
            Question2_UniqueSums.countCombinations(arr1, 10));

        int[] arr2 = {1,2,4,7,5};
        System.out.println("Expected: 1 | Got: " +
            Question2_UniqueSums.countCombinations(arr2, 17));
    }
}
```
Test File for Question 3

**File:** `Test_Question3.java`

```java
public class Test_Question3 {
    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        int[] a2 = {2,4,8};
        int[] a3 = {3,6,14};

        System.out.println("Expected: 1 | Got: " + Question3_ArrayReduction.canMakeZero(a1));
        System.out.println("Expected: 1 | Got: " + Question3_ArrayReduction.canMakeZero(a2));
        System.out.println("Expected: 0 | Got: " + Question3_ArrayReduction.canMakeZero(a3));
    }
}
```

### Test File for Question 4

**File:** `Test_Question4.java`
```
public class Test_Question4 {
    public static void main(String[] args) {
        String[] products = {"Apple","Computer","Apple","Bag"};
        System.out.println("Expected: Computer | Got: " +
            Question4_FirstUniqueProduct.firstUniqueProduct(products));

        String[] products2 = {"Pen","Pen","Pen"};
        System.out.println("Expected: null | Got: " +
            Question4_FirstUniqueProduct.firstUniqueProduct(products2));
    }
}
```
### Test File for Question 5

**File:** `Test_Question5.java`
```
public class Test_Question5 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,4,5,2};
        System.out.println("Expected: 3 | Got: " +
            Question5_ClosestMinDistance.closestMinDistance(arr));
    }
}
```
### Test File for Question 6

**File:** `Test_Question6.java`
```
import java.util.*;
public class Test_Question6 {
    public static void main(String[] args) {
        String sentence = "hi there care to discuss algorithm basis or how to solve algorithm or";
        List<String> result = Question6_TopThreeWords.topThreeWords(sentence);
        System.out.println("Expected: [algorithm, or, to] | Got: " + result);
    }
}
```
### Test File for Question 7

**File:** `Test_Question7.java`
```
public class Test_Question7 {
    public static void main(String[] args) {
        Node head = new Node("ID_A01");
        head.next = new Node("ID_A02");
        head.next.next = new Node("ID_A03");
        head.next.next.next = new Node("ID_A04");
        head.next.next.next.next = new Node("ID_A05");
        head.next.next.next.next.next = new Node("ID_A06");

        Node rotated = Question7_RotateList.rotateRight(head, 2);
        Question7_RotateList.printList(rotated);
        // Expected Output: ID_A05 -> ID_A06 -> ID_A01 -> ID_A02 -> ID_A03 -> ID_A04 -> null
    }
}

