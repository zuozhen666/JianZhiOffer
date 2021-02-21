package zuozhen;

public class 面试题54_二叉搜索树的第K大节点 {
    /*
    中序遍历即可
     */
    int count = 0;
    TreeNode ansNode;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(k == 0 || pRoot == null) return null;
        infixOrder(pRoot, k);
        return ansNode;
    }

    void infixOrder(TreeNode node, int k) {
        if(node.left != null) {
            infixOrder(node.left, k);
        }
        count++;
        if(count == k) {
            ansNode = node;
            return;
        }
        if(node.right != null) {
            infixOrder(node.right, k);
        }
    }
}
