import java.util.*;

public class BSTValidation {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static List<Integer> findInvalidNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        findInvalid(root, null, null, result);
        return result;
    }

    private static void findInvalid(TreeNode node, Integer min, Integer max, List<Integer> result) {
        if (node == null) return;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            result.add(node.val);
        }
        findInvalid(node.left, min, node.val, result);
        findInvalid(node.right, node.val, max, result);
    }

    public static int minNodesToRemove(TreeNode root) {
        return findInvalidNodes(root).size();
    }

    public static void main(String[] args) {
        TreeNode validBST = new TreeNode(10);
        validBST.left = new TreeNode(5);
        validBST.right = new TreeNode(15);
        validBST.left.left = new TreeNode(2);
        validBST.left.right = new TreeNode(7);
        validBST.right.left = new TreeNode(12);
        validBST.right.right = new TreeNode(20);

        TreeNode invalidBST = new TreeNode(10);
        invalidBST.left = new TreeNode(5);
        invalidBST.right = new TreeNode(8); // invalid
        invalidBST.left.left = new TreeNode(2);
        invalidBST.left.right = new TreeNode(12); // invalid

        System.out.println(isValidBST(validBST));      // true
        System.out.println(isValidBST(invalidBST));    // false
        System.out.println(findInvalidNodes(invalidBST)); // [8, 12]
        System.out.println(minNodesToRemove(invalidBST)); // 2
    }
}
