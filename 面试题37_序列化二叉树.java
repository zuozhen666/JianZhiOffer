package zuozhen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 面试题37_序列化二叉树 {
    /*
    请实现两个函数，分别用来序列化和反序列化二叉树。
     */
    private String Str;

    String Serialize(TreeNode root) {
        //前序遍历
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        Str = str;
        return Deserialize();
    }

    TreeNode Deserialize() {
        if (Str.length() == 0) {
            return null;
        }
        int index = Str.indexOf(" ");
        String val = index == -1 ? Str : Str.substring(0, index);
        Str = index == -1 ? "" : Str.substring(index + 1);
        if (val.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = Deserialize();
        node.right = Deserialize();
        return node;
    }
}
