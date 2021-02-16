package zuozhen;

import java.util.ArrayList;

public class 面试题34_二叉树中和为某一值的路径 {
    /*
    输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
    从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     */
    /*
    思路：前序遍历加回溯
     */
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> tmp = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return ans;
        target -= root.val;
        tmp.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<Integer>(tmp));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        tmp.remove(tmp.size() - 1);
        return ans;
    }
}
