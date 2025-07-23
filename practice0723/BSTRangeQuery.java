import java.util.*;

public class BSTRangeQuery {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrder(root, min, max, result);
        return result;
    }

    private static void inOrder(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) return;

        if (node.val > min) {
            inOrder(node.left, min, max, result);
        }
        if (node.val >= min && node.val <= max) {
            result.add(node.val);
        }
        if (node.val < max) {
            inOrder(node.right, min, max, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        int min = 12;
        int max = 27;

        ArrayList<Integer> result = rangeQuery(root, min, max);
        System.out.println(result);  // Expected: [15, 20, 25]
    }
}
