import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] pre, int preL, int preR, int[] in, int inL, int inR, Map<Integer, Integer> inMap) {
        if (preL > preR || inL > inR) return null;

        TreeNode root = new TreeNode(pre[preL]);
        int idx = inMap.get(pre[preL]);
        int leftSize = idx - inL;

        root.left = buildPreIn(pre, preL + 1, preL + leftSize, in, inL, idx - 1, inMap);
        root.right = buildPreIn(pre, preL + leftSize + 1, preR, in, idx + 1, inR, inMap);

        return root;
    }

    public static TreeNode buildFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] post, int postL, int postR, int[] in, int inL, int inR, Map<Integer, Integer> inMap) {
        if (postL > postR || inL > inR) return null;

        TreeNode root = new TreeNode(post[postR]);
        int idx = inMap.get(post[postR]);
        int leftSize = idx - inL;

        root.left = buildPostIn(post, postL, postL + leftSize - 1, in, inL, idx - 1, inMap);
        root.right = buildPostIn(post, postL + leftSize, postR - 1, in, idx + 1, inR, inMap);

        return root;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder =  {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode fromPreIn = buildFromPreIn(preorder, inorder);
        TreeNode fromPostIn = buildFromPostIn(postorder, inorder);

        printInOrder(fromPreIn);   // 9 3 15 20 7
        System.out.println();
        printInOrder(fromPostIn);  // 9 3 15 20 7
    }
}
