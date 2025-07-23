import java.util.*;

public class BSTBalance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode node) {
        if (node == null) return 0;
        int left = checkBalance(node.left);
        if (left == -1) return -1;
        int right = checkBalance(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

    public static Map<TreeNode, Integer> getBalanceFactors(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        computeBalance(root, map);
        return map;
    }

    private static int computeBalance(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return 0;
        int left = computeBalance(node.left, map);
        int right = computeBalance(node.right, map);
        map.put(node, left - right);
        return 1 + Math.max(left, right);
    }

    public static TreeNode mostUnbalancedNode(TreeNode root) {
        Map<TreeNode, Integer> map = getBalanceFactors(root);
        TreeNode result = null;
        int maxDiff = -1;
        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            int abs = Math.abs(entry.getValue());
            if (abs > maxDiff) {
                maxDiff = abs;
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        root2.right.right.right = new TreeNode(4);

        System.out.println(isBalanced(root1)); // true
        System.out.println(isBalanced(root2)); // false

        Map<TreeNode, Integer> factors = getBalanceFactors(root2);
        for (TreeNode node : factors.keySet()) {
            System.out.println("Node " + node.val + ": " + factors.get(node));
        }

        TreeNode most = mostUnbalancedNode(root2);
        System.out.println("Most unbalanced: " + most.val);
    }
}
