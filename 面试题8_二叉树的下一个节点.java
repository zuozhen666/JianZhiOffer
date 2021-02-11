package zuozhen;

import java.util.ArrayList;
import java.util.Iterator;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class 面试题8_二叉树的下一个节点 {
    /*
    给定一颗二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
    树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    /*
    牛客AC代码
     */
//    public void inOrder(TreeLinkNode p, ArrayList<TreeLinkNode> list) {
//        if (p == null) return;
//        if (p.left != null) inOrder(p.left, list);
//        list.add(p);
//        if (p.right != null) inOrder(p.right, list);
//    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        /*
        方法1：找到根节点然后中序遍历（显然有点太直接了）
        */
//        if (pNode == null) return null;
//        ArrayList<TreeLinkNode> list = new ArrayList<>();
//        TreeLinkNode p = pNode;
//        while (p.next != null) {
//            p = p.next;
//        }
//        inOrder(p, list);
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            p = (TreeLinkNode) iterator.next();
//            if (p.val == pNode.val) {
//                if (iterator.hasNext()) {
//                    return (TreeLinkNode) iterator.next();
//                } else {
//                    return null;
//                }
//            }
//        }
//        return null;
        /*
        先查看右子节点，若右子节点存在，查看右子节点的左子节点（直到最左），
      左子节点不存在，那么右子节点即为所求；//总结得不好，其实就是右子树的最左节点
        再查看父节点，（父节点为空，即为null）如果自己是父节点的左子节点，那么父节点即为所求；
      如果为右子节点，沿着父节点向上寻找，直到找到满足其中一个父节点
      是其父节点的左子节点的情况，其父节点即为所求；否则，null。
        */
        if (pNode == null) return null;
        //先查找右子树的最左节点，找到返回
        if (pNode.right != null) {
            TreeLinkNode p = pNode.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        //查看自己是不是父节点的左子节点，若满足返回父节点
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }
        //向上查找某一父节点是其父节点的左子节点，返回其父节点
        if (pNode.next != null) {
            TreeLinkNode pp = pNode.next;
            while (pp.next != null && pp.next.left != pp) {
                pp = pp.next;
            }
            return pp.next;
        }
        return null;
    }
}
