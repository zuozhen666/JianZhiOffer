package zuozhen;

public class 面试题28_对称的二叉树 {
    /*
    请实现一个函数，用来判断一棵二叉树是不是对称的。
    如果一棵二叉树和它的镜像一样，那么它是对称的。
     */
    /*
    发现：对称的二叉树的前序遍历（头，左，右）与对称前序遍历（头，右，左）输出的序列一样（考虑null）
     */
    boolean isSymmetrical(TreeNode pRoot) {
        return judge(pRoot, pRoot);//参数一：按照前序遍历，参数二：按照对称前序遍历
    }

    boolean judge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;//输出序列考虑null
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return judge(root1.left, root2.right) && judge(root1.right, root2.left);
    }
}
