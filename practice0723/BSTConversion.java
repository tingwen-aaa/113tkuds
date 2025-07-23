public class BSTConversion {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class DLLNode {
        int val;
        DLLNode prev, next;
        DLLNode(int val) {
            this.val = val;
        }
    }

    public static DLLNode bstToSortedDoublyList(TreeNode root) {
        return inorderToList(root)[0];
    }

    private static DLLNode[] inorderToList(TreeNode root) {
        if (root == null) return new DLLNode[]{null, null};

        DLLNode[] left = inorderToList(root.left);
        DLLNode curr = new DLLNode(root.val);
        DLLNode[] right = inorderToList(root.right);

        if (left[1] != null) {
            left[1].next = curr;
            curr.prev = left[1];
        }

        if (right[0] != null) {
            curr.next = right[0];
            right[0].prev = curr;
        }

        DLLNode head = left[0] != null ? left[0] : curr;
        DLLNode tail = right[1] != null ? right[1] : curr;
        return new DLLNode[]{head, tail};
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBSTFromArray(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBSTFromArray(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBSTFromArray(nums, left, mid - 1);
        node.right = buildBSTFromArray(nums, mid + 1, right);
        return node;
    }

    static int sum = 0;
    public static void convertToGreaterSumTree(TreeNode root) {
        if (root == null) return;
        convertToGreaterSumTree(root.right);
        sum += root.val;
        root.val = sum;
        convertToGreaterSumTree(root.left);
    }

    public static void printDLL(DLLNode head) {
        DLLNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(10);
        bst.left = new TreeNode(6);
        bst.right = new TreeNode(14);
        bst.left.left = new TreeNode(4);
        bst.left.right = new TreeNode(8);
        bst.right.left = new TreeNode(12);
        bst.right.right = new TreeNode(16);

        DLLNode dllHead = bstToSortedDoublyList(bst);
        printDLL(dllHead);

        int[] sorted = {-10, -3, 0, 5, 9};
        TreeNode balanced = sortedArrayToBST(sorted);
        printInOrder(balanced);
        System.out.println();

        TreeNode bst2 = new TreeNode(5);
        bst2.left = new TreeNode(2);
        bst2.right = new TreeNode(13);
        convertToGreaterSumTree(bst2);
        printInOrder(bst2); // 20 18 13
    }
}
