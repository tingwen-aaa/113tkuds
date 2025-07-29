import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static int rangeSum(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSum(root.right, L, R);
        if (root.val > R) return rangeSum(root.left, L, R);
        return root.val + rangeSum(root.left, L, R) + rangeSum(root.right, L, R);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        int L = sc.nextInt();
        int R = sc.nextInt();

        TreeNode root = null;
        for (String v : values) {
            root = insert(root, Integer.parseInt(v));
        }

        int sum = rangeSum(root, L, R);
        System.out.println("Sum: " + sum);
        sc.close();
    }
}
