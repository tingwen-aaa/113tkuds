public class BSTDelete {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
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

    public static TreeNode delete(TreeNode root, int data) {
        if (root == null) return null;

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    private static int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            root = insert(root, value);
        }

        System.out.print("Original BST: ");
        inOrder(root);
        System.out.println();

        root = delete(root, 20);
        System.out.print("After deleting 20: ");
        inOrder(root);
        System.out.println();

        root = delete(root, 30);
        System.out.print("After deleting 30: ");
        inOrder(root);
        System.out.println();

        root = delete(root, 50);
        System.out.print("After deleting 50: ");
        inOrder(root);
        System.out.println();
    }
}
