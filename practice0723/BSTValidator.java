public class BSTValidator {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return validate(node.left, min, node.data) &&
               validate(node.right, node.data, max);
    }

    public static void main(String[] args) {
        TreeNode validBST = new TreeNode(50);
        validBST.left = new TreeNode(30);
        validBST.right = new TreeNode(70);
        validBST.left.left = new TreeNode(20);
        validBST.left.right = new TreeNode(40);

        TreeNode invalidBST = new TreeNode(50);
        invalidBST.left = new TreeNode(30);
        invalidBST.right = new TreeNode(70);
        invalidBST.left.left = new TreeNode(20);
        invalidBST.left.right = new TreeNode(60); // invalid

        System.out.println("First tree is valid BST: " + isValidBST(validBST));
        System.out.println("Second tree is valid BST: " + isValidBST(invalidBST));
    }
}
