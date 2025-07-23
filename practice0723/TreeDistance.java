import java.util.*;

public class TreeDistance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int distance(TreeNode root, int a, int b) {
        TreeNode lca = lowestCommonAncestor(root, a, b);
        return depthFrom(lca, a, 0) + depthFrom(lca, b, 0);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {
        if (root == null || root.val == a || root.val == b) return root;
        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    private static int depthFrom(TreeNode root, int target, int depth) {
        if (root == null) return -1;
        if (root.val == target) return depth;
        int left = depthFrom(root.left, target, depth + 1);
        if (left != -1) return left;
        return depthFrom(root.right, target, depth + 1);
    }

    static int maxDiameter = 0;

    public static int treeDiameter(TreeNode root) {
        maxDiameter = 0;
        diameterDFS(root);
        return maxDiameter;
    }

    private static int diameterDFS(TreeNode node) {
        if (node == null) return 0;
        int left = diameterDFS(node.left);
        int right = diameterDFS(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }

    public static List<Integer> nodesAtDistanceK(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        findNodesK(root, k, result);
        return result;
    }

    private static void findNodesK(TreeNode node, int k, List<Integer> result) {
        if (node == null) return;
        if (k == 0) {
            result.add(node.val);
            return;
        }
        findNodesK(node.left, k - 1, result);
        findNodesK(node.right, k - 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println(distance(root, 4, 5));  // 2
        System.out.println(distance(root, 4, 6));  // 4

        System.out.println(treeDiameter(root));   // 5

        System.out.println(nodesAtDistanceK(root, 2)); // [4, 5, 6]
    }
}
