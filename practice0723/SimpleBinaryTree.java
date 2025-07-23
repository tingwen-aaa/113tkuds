package practice0723;

public class SimpleBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }

        public void displayNode() {
            System.out.println("Node value: " + data);
            System.out.println("Left child: " + (left != null ? left.data : "null"));
            System.out.println("Right child: " + (right != null ? right.data : "null"));
        }
    }

    public static void printTree(TreeNode node, int space) {
        if (node == null) return;
        int COUNT = 5;
        space += COUNT;
        printTree(node.right, space);
        System.out.println();
        for (int i = COUNT; i < space; i++) System.out.print(" ");
        System.out.println(node.data);
        printTree(node.left, space);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Node info:");
        root.displayNode();
        root.left.displayNode();
        root.right.displayNode();
        root.left.left.displayNode();
        root.left.right.displayNode();

        System.out.println("\nTree structure:");
        printTree(root, 0);
    }
}
