package zuozhen;

public class 面试题36_二叉搜索树与双向链表 {
    /*
    输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    要求：不新建节点，只调整树中的指针即可。
     */
    /*
    思路：中序遍历即为增序排列，利用线索化二叉树的思想，设置一个全局变量pre指向前一个节点
    而head单纯就是为了找到头结点，即中序遍历的第一个节点。
     */
    TreeNode pre = null;
    TreeNode head = null;//中序遍历的第一个节点

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
        }
        if (pre != null) {
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.right);
        return head;
    }
}
