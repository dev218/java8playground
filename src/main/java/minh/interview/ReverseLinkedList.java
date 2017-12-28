package minh.interview;

/**
 * Write a method for reversing a linked list. Do it in-place.
 * Your method will have one input: the head of the list.
 * Your method should return the new head of the list.
 */
public class ReverseLinkedList {

    class LinkedListNode {
        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public LinkedListNode reverse(LinkedListNode root) {
        if (root == null) {
            return null;
        }

        LinkedListNode current = root;
        LinkedListNode next = root.next;

        while (next != null) {
            // keep the next node
            LinkedListNode tmp = next.next;

            // modify the pointer to the current
            next.next = current;

            // move on
            current = next;
            next = tmp;
        }

        return current;
    }
}
