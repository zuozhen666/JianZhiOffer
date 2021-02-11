package zuozhen;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class 面试题7_重建二叉树 {
    /*
    输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     */
    /*
    思路：通过前序遍历第一个数值确定根节点，然后确定左右子树的前序遍历和中序遍历，然后递归即可
     */
    /*
    牛客AC代码
     */
    Map<Integer, Integer> inOrderValueToIndex = new HashMap<Integer, Integer>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        /*
        经典思路简单，上手困难
        递归
        开了四个数组，消耗较大，改进，使用Map
        */
//        if (pre.length == 0 || pre.length != in.length) return null;
//        TreeNode root = new TreeNode(pre[0]);
//        int i;
//        for (i = 0; i < in.length; i++) {
//            if (in[i] == pre[0]) break;
//        }
//        int[] leftPre = new int[i];
//        int[] leftIn = new int[i];
//        int[] rightPre = new int[in.length - i - 1];
//        int[] rightIn = new int[in.length - i - 1];
//        for (int j = 0; j < i; j++) {
//            leftPre[j] = pre[j + 1];
//            leftIn[j] = in[j];
//        }
//        for (int j = 0; j < in.length - i - 1; j++) {
//            rightPre[j] = pre[i + 1 + j];
//            rightIn[j] = in[i + 1 + j];
//        }
//        root.left = reConstructBinaryTree(leftPre, leftIn);
//        root.right = reConstructBinaryTree(rightPre, rightIn);
//        return root;
        //改进版
        for (int i = 0; i < in.length; i++) {
            //记录中序遍历数值对应的下标
            inOrderValueToIndex.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     * @param pre  整棵树前序遍历数组
     * @param preL 当前树前序遍历最左序号
     * @param preR 当前树前序遍历最右序号
     * @param inL  当前树中序遍历最左序号
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int rootIndex = inOrderValueToIndex.get(root.val);
        int leftLength = rootIndex - inL;//左子树前序，中序遍历数组长度
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftLength, inL);
        root.right = reConstructBinaryTree(pre, preL + leftLength + 1, preR, rootIndex + 1);
        return root;
    }
}
