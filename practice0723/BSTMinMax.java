public class BSTMinMax {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static int findMin(TreeNode root) {
        if (root == null) throw new RuntimeException("Tree is empty");

        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public static int findMax(TreeNode root) {
        if (root == null) throw new RuntimeException("Tree is empty");

        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;

        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 90};
        for (int value : values) {
            root = insert(root, value);
        }

        System.out.println("Min value: " + findMin(root));
        System.out.println("Max value: " + findMax(root));
    }
}
