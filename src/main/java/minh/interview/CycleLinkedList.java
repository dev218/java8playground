package minh.interview;

import java.util.HashSet;
import java.util.Set;

public class CycleLinkedList {

    public static void main(String[] args) {
        LinkedListNode root = new LinkedListNode(1);
        root.next = new LinkedListNode(2);
        root.next.next = new LinkedListNode(3);
        //root.next.next.next = root;

        System.out.println(isCycle(root));
        System.out.println(containsCycleSolution(root));
    }

    private static boolean isCycle(LinkedListNode root) {
        Set<LinkedListNode> nodes = new HashSet<>();
        nodes.add(root);

        LinkedListNode node = root.next;

        while (node != null) {
            // check if next has been visited
            if (nodes.contains(node)) return true;

            node = node.next;
        }
        return false;
    }

    public static boolean containsCycleSolution(LinkedListNode firstNode) {

        // start both runners at the beginning
        LinkedListNode slowRunner = firstNode;
        LinkedListNode fastRunner = firstNode;

        // until we hit the end of the list
        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            // case: fastRunner is about to "lap" slowRunner
            if (fastRunner == slowRunner) {
                return true;
            }
        }

        // case: fastRunner hit the end of the list
        return false;
    }

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }
}
