package minh.interview;

public class BinaryTree2ndLargest {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(130);
        System.out.println(find2ndLagest(root));

        root = new BinaryTreeNode(130);
        root.insertLeft(50);
        root.left.insertRight(100);
        System.out.println(find2ndLagest(root));

        root = new BinaryTreeNode(10);
        root.insertLeft(5);
        System.out.println(find2ndLagest(root));

        root = new BinaryTreeNode(10);
        root.insertLeft(5);
        root.insertRight(20);
        root.right.insertRight(30);
        System.out.println(find2ndLagest(root));

    }

    private static Integer find2ndLagest(BinaryTreeNode root) {
        BinaryTreeNode mostRight = findMostRightLeaf(root);

        // if this node has left, 2nd largest is either its value or his right
        if (mostRight.left != null) {
            return findMostRightLeaf(mostRight.left).value;
        } else {
            // if not, return the parent
            return mostRight.parent == null ? null : mostRight.parent.value;
        }
    }

    private static BinaryTreeNode findMostRightLeaf(BinaryTreeNode root) {
        // start from root
        BinaryTreeNode node = root;

        // if there's no right leaf, return this
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode parent;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            this.left.parent = this;
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            this.right.parent = this;
            return this.right;
        }
    }
}
