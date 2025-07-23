import java.util.*;

public class CompleteBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static class BST {
        TreeNode root;

        public BST() {
            root = null;
        }

        public void insert(int data) {
            root = insertRec(root, data);
        }

        private TreeNode insertRec(TreeNode root, int data) {
            if (root == null) return new TreeNode(data);
            if (data < root.data) root.left = insertRec(root.left, data);
            else if (data > root.data) root.right = insertRec(root.right, data);
            return root;
        }

        public boolean search(int data) {
            return searchRec(root, data);
        }

        private boolean searchRec(TreeNode root, int data) {
            if (root == null) return false;
            if (root.data == data) return true;
            return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
        }

        public void delete(int data) {
            root = deleteRec(root, data);
        }

        private TreeNode deleteRec(TreeNode root, int data) {
            if (root == null) return null;
            if (data < root.data) root.left = deleteRec(root.left, data);
            else if (data > root.data) root.right = deleteRec(root.right, data);
            else {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                root.data = findMin(root.right);
                root.right = deleteRec(root.right, root.data);
            }
            return root;
        }

        private int findMin(TreeNode root) {
            while (root.left != null) root = root.left;
            return root.data;
        }

        public void inOrder() {
            inOrderRec(root);
            System.out.println();
        }

        private void inOrderRec(TreeNode root) {
            if (root != null) {
                inOrderRec(root.left);
                System.out.print(root.data + " ");
                inOrderRec(root.right);
            }
        }

        public void levelOrder() {
            if (root == null) return;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println();
        }

        public int height() {
            return heightRec(root);
        }

        private int heightRec(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(heightRec(root.left), heightRec(root.right));
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        System.out.println("Inserting values: " + Arrays.toString(values));

        for (int value : values) {
            bst.insert(value);
        }

        System.out.print("In-order traversal: ");
        bst.inOrder();

        System.out.print("Level-order traversal: ");
        bst.levelOrder();

        System.out.println("Tree height: " + bst.height());

        System.out.println("Search 35: " + bst.search(35));
        System.out.println("Search 55: " + bst.search(55));

        bst.delete(20);
        System.out.print("After deleting 20: ");
        bst.inOrder();

        bst.delete(30);
        System.out.print("After deleting 30: ");
        bst.inOrder();

        bst.delete(50);
        System.out.print("After deleting 50: ");
        bst.inOrder();
    }
}
