package zuozhen;

public class 面试题27_二叉树的镜像 {
    /*
    请完成一个函数，输入一颗二叉树，该函数输出它的镜像。
     */
    /*
    牛客AC代码：（将二叉树变成其镜像）
     */
    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
