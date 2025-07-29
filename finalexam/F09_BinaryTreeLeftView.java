import java.util.*;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(List<Integer> data) {
        if (data.size() == 0 || data.get(0) == -1) return null;
        TreeNode root = new TreeNode(data.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < data.size()) {
            TreeNode current = queue.poll();
            if (i < data.size() && data.get(i) != -1) {
                current.left = new TreeNode(data.get(i));
                queue.add(current.left);
            }
            i++;
            if (i < data.size() && data.get(i) != -1) {
                current.right = new TreeNode(data.get(i));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            view.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return view;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split(" ");
        List<Integer> nodes = new ArrayList<>();
        for (String p : parts) {
            nodes.add(Integer.parseInt(p));
        }

        TreeNode root = buildTree(nodes);
        List<Integer> result = leftView(root);
        System.out.print("LeftView:");
        for (int v : result) {
            System.out.print(" " + v);
        }
        System.out.println();
        sc.close();
    }
}
