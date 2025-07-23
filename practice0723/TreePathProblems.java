import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        traverse(root, new ArrayList<>(), paths);
        return paths;
    }

    private static void traverse(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            traverse(node.left, path, result);
            traverse(node.right, path, result);
        }

        path.remove(path.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == target;
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    }

    public static List<Integer> maxSumPath(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        dfsMax(root, new ArrayList<>(), 0, new int[]{Integer.MIN_VALUE}, maxPath);
        return maxPath;
    }

    private static void dfsMax(TreeNode node, List<Integer> path, int sum, int[] maxSum, List<Integer> maxPath) {
        if (node == null) return;

        path.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null) {
            if (sum > maxSum[0]) {
                maxSum[0] = sum;
                maxPath.clear();
                maxPath.addAll(path);
            }
        } else {
            dfsMax(node.left, path, sum, maxSum, maxPath);
            dfsMax(node.right, path, sum, maxSum, maxPath);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(allPaths(root));
        System.out.println(hasPathSum(root, 22)); // true
        System.out.println(maxSumPath(root));     // [5, 8, 4, 1] => sum = 18 or [5, 4, 11, 7] = 27
    }
}
