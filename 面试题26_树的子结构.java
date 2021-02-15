package zuozhen;

public class 面试题26_树的子结构 {
    /*
    输入两颗二叉树A和B，判断B是不是A的子结构。
     */
    /*
    思路：
    第一步：
        在树A中找到和树B根节点的值一样的节点R
    第二步：
        判断A中以R为根节点的子树中是否包含和树B一样的结构
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return isSame(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    //判断两树是否有相同的结构
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;//root2的整体结构一定<=root1
        if (root1 == null) return false;//同上
        if (root1.val != root2.val) return false;
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}
