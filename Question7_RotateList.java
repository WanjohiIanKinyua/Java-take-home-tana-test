/**
 * Question 7:
 * Rotate a singly linked list by moving each element n times to the right.
 *
 * Example:
 * Input: "ID_A01"->"ID_A02"->"ID_A03"->"ID_A04"->"ID_A05"->"ID_A06"->null, n = 2
 * Output: "ID_A05"->"ID_A06"->"ID_A01"->"ID_A02"->"ID_A03"->"ID_A04"->null
 */

// Node class for linked list
class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Question7_RotateList {

    /**
     * Rotates the linked list to the right by n positions.
     *
     * @param head Head node of the linked list
     * @param n    Number of rotations
     * @return New head after rotation
     */
    public static Node rotateRight(Node head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }

        // Step 1: Find the length of the list and last node
        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 2: Connect tail to head to make it circular
        temp.next = head;

        // Step 3: Normalize n
        n = n % length;
        int stepsToNewHead = length - n;

        // Step 4: Find new tail and break the circle
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    /**
     * Prints the linked list.
     */
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println(" -> null");
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        // Create linked list: ID_A01 -> ID_A02 -> ID_A03 -> ID_A04 -> ID_A05 -> ID_A06
        Node head = new Node("ID_A01");
        head.next = new Node("ID_A02");
        head.next.next = new Node("ID_A03");
        head.next.next.next = new Node("ID_A04");
        head.next.next.next.next = new Node("ID_A05");
        head.next.next.next.next.next = new Node("ID_A06");

        System.out.println("Original List:");
        printList(head);

        int n = 2;
        Node rotated = rotateRight(head, n);

        System.out.println("\nRotated List by " + n + " positions:");
        printList(rotated);

        // Additional test: rotate by list length
        n = 6;
        Node rotatedAgain = rotateRight(rotated, n);
        System.out.println("\nRotated List by " + n + " positions:");
        printList(rotatedAgain);
    }
}
