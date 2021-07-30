package btree;

public class CreateBinaryTreeFromTraversal {
    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};
        Solution solution = new Solution();
        TreeNode root = solution.constructFromPrePost(pre, post);
        preOrder(root);
    }

    private static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    private int preIndex;

    private TreeNode constructFromPrePost(int[] pre, int[] post, int l, int h, int size) {
        if (preIndex >= size || l > h) {
            return null;
        }

        TreeNode rootNode = new TreeNode(pre[preIndex]);
        preIndex++;
        if (preIndex >= size  || l == h) {
            return rootNode;
        }

        int i = l;
        for (; i < h; i++) {
            if (pre[preIndex] == post[i]) {
                break;
            }
        }

        if(i <= h) {
            rootNode.left = constructFromPrePost(pre, post, l, i, size);
            rootNode.right = constructFromPrePost(pre, post, i + 1, h - 1, size);
        }
        return rootNode;
    }


    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, 0, pre.length, pre.length);
    }

}
