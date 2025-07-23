public class TreeComparison {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode sub) {
        if (sub == null) return true;
        if (root == null) return false;
        if (isSameTree(root, sub)) return true;
        return isSubtree(root.left, sub) || isSubtree(root.right, sub);
    }

    public static TreeNode largestCommonSubtree(TreeNode a, TreeNode b) {
        if (a == null || b == null) return null;

        if (isSameTree(a, b)) return a;

        TreeNode left = largestCommonSubtree(a.left, b);
        TreeNode right = largestCommonSubtree(a.right, b);

        if (left != null) return left;
        if (right != null) return right;

        TreeNode left2 = largestCommonSubtree(a, b.left);
        TreeNode right2 = largestCommonSubtree(a, b.right);

        if (left2 != null) return left2;
        return right2;
    }

    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(5);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(2);

        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);

        TreeNode t3 = new TreeNode(3);
        t3.left = new TreeNode(4);
        t3.right = new TreeNode(5);
        t3.left.left = new TreeNode(1);
        t3.left.right = new TreeNode(2);

        System.out.println(isSameTree(t1, t3));        // true
        System.out.println(isSubtree(t1, t2));         // true

        TreeNode common = largestCommonSubtree(t1, t2);
        printPreOrder(common);                         // 4 1 2
        System.out.println();
    }
}
