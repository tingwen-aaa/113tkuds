import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxDiameter = 0;

    public static int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }

    public static TreeNode buildTree(List<Integer> data) {
        if (data.size() == 0 || data.get(0) == -1) return null;
        TreeNode root = new TreeNode(data.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < data.size()) {
            TreeNode node = queue.poll();
            if (i < data.size() && data.get(i) != -1) {
                node.left = new TreeNode(data.get(i));
                queue.add(node.left);
            }
            i++;
            if (i < data.size() && data.get(i) != -1) {
                node.right = new TreeNode(data.get(i));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (String s : input) list.add(Integer.parseInt(s));
        TreeNode root = buildTree(list);
        height(root);
        System.out.println("Diameter: " + maxDiameter);
        sc.close();
    }
}
