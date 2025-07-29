import java.util.*;

public class F11_BSTClosestValue {
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

    public static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target) ||
                (Math.abs(root.val - target) == Math.abs(closest - target) && root.val < closest)) {
                closest = root.val;
            }

            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] vals = sc.nextLine().split(" ");
        int target = sc.nextInt();

        TreeNode root = null;
        for (String v : vals) {
            root = insert(root, Integer.parseInt(v));
        }

        int result = closestValue(root, target);
        System.out.println("Closest: " + result);
        sc.close();
    }
}
