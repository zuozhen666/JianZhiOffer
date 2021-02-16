package zuozhen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 面试题32_从上到下打印二叉树 {
    /*
    层序遍历二叉树；
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //经典
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeNode temp = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(temp);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                temp = queue.poll();
                ans.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
        }
        return ans;
    }

    /*
    题目延伸：分行打印{添加两个变量toBePrinted，nextLevel来判断是否输出换行}
     */
    /*
    题目延伸：之字形打印二叉树
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        /*
        没有分析，直接写的，有点繁琐
         */
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        if (pRoot == null) return ans;
//        TreeNode p = pRoot;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(p);
//        boolean flag = true;//true:左到右，false:右到左
//        while (!queue.isEmpty()) {
//            int len = queue.size();
//            if (flag) {
//                ArrayList<Integer> arr = new ArrayList<>();
//                for (int i = 0; i < len; i++) {
//                    TreeNode node = queue.poll();
//                    arr.add(node.val);
//                    if (node.left != null) queue.offer(node.left);
//                    if (node.right != null) queue.offer(node.right);
//                }
//                ans.add(arr);
//            } else {
//                Stack<Integer> stack = new Stack<>();
//                for (int i = 0; i < len; i++) {
//                    TreeNode node = queue.poll();
//                    stack.push(node.val);
//                    if (node.left != null) queue.offer(node.left);
//                    if (node.right != null) queue.offer(node.right);
//                }
//                ArrayList<Integer> arr = new ArrayList<>();
//                while (!stack.isEmpty()) {
//                    arr.add(stack.pop());
//                }
//                ans.add(arr);
//            }
//            flag = !flag;
//        }
//        return ans;
        /*
        分析：使用两个栈结构
        在奇数层遍历时，从左到右入栈0；
        在偶数层遍历时，从右到左入栈1。
         */
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) return ret;
        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<TreeNode>();
        stacks[1] = new Stack<TreeNode>();
        stacks[1].push(pRoot);
        int isOdd = 1;//当前层是否为奇数层
        int isEven = 0;//当前层是否为偶数层
        while (true) {
            if (stacks[0].isEmpty() && stacks[1].isEmpty()) {
                break;
            }
            int len = stacks[isOdd].size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode p = stacks[isOdd].pop();
                temp.add(p.val);
                if (isOdd == 1) {
                    if (p.left != null) stacks[isEven].push(p.left);
                    if (p.right != null) stacks[isEven].push(p.right);
                } else {
                    if (p.right != null) stacks[isEven].push(p.right);
                    if (p.left != null) stacks[isEven].push(p.left);
                }
            }
            ret.add(temp);
            int t = isOdd;
            isOdd = isEven;
            isEven = t;
        }
        return ret;
    }

    /*
    其实更简单的之字形打印就是按照层序遍历，然后需要反转的直接调用Collections.reverse即可
     */
    @Test
    public void test() {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.left = node5;
        node3.left = node6;
        node3.right = node7;
        ArrayList<ArrayList<Integer>> ans = Print(node1);
    }
}
