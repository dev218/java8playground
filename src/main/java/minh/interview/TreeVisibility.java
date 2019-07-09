package minh.interview;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * In a binary tree, if in the path from the root to the node A, there is no
 * node with value greater than A's value, then A is a visible node. We need
 * to count the number of visible nodes in a binary tree.
 *
 */
public class TreeVisibility {

    public static void main(String[] args) {
        Node root = populateTree(3);
        printTree(root);

        System.out.println(countVisibleRecursive(root, Integer.MIN_VALUE));
        System.out.println(countVisibleIterative(root));
    }

    private static int countVisibleIterative(Node root) {
        class NodeVisit {
            Node node;
            int maxSoFar;

            public NodeVisit(Node node, int maxSoFar) {
                this.node = node;
                this.maxSoFar = maxSoFar;
            }
        }

        int count = 0;
        Stack stack = new Stack();
        stack.push(new NodeVisit(root, Integer.MIN_VALUE));

        while (!stack.empty()) {
            NodeVisit visit = (NodeVisit) stack.pop();
            int maxValue = visit.maxSoFar;
            if (visit.node.value >= maxValue) {
                count++;
                maxValue = visit.node.value;
            }

            if (visit.node.left != null) {
                stack.push(new NodeVisit(visit.node.left, maxValue));
            }

            if (visit.node.right != null) {
                stack.push(new NodeVisit(visit.node.right, maxValue));
            }
        }

        return count;
    }

    private static int countVisibleRecursive(Node node, int maxValue) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        if (node.value >= maxValue) {
            count = 1;
            maxValue = node.value;
        }

        return countVisibleRecursive(node.left, maxValue) + countVisibleRecursive(node.right, maxValue) + count;
    }

    private static void printTree(Node root) {
        if (root == null) {
            return;
        }

        Queue queue = new ArrayDeque();
        queue.add(root);

        int count = 0;
        int newLineCount = 1;

        while (queue.size() > 0) {
            Node node = (Node) queue.remove();

            System.out.print(node.value + " ");
            count++;
            if (count == newLineCount) {
                System.out.println();
                newLineCount = count * 2 + 1;
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private static Node populateTree(int depth) {
        Node node = new Node((int) (Math.random() * 20) + 1);

        if (depth > 1) {
            node.left = populateTree(depth - 1);
            node.right = populateTree(depth - 1);
        }

        return node;
    }

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }
}
