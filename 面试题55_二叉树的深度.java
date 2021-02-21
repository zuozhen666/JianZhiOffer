package zuozhen;

public class 面试题55_二叉树的深度 {
    /*
    题目一：二叉树的深度
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(TreeDepth(root.right), TreeDepth(root.left));
    }

    /*
    题目二：平衡二叉树
    输入一颗二叉树的根节点，判断该树是不是平衡二叉树。
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }
    /*
    相当于后序遍历，节点只遍历一次
     */
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if (left == -1) return -1;
        int right = depth(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}
