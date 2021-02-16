package zuozhen;

public class 面试题33_二叉搜索树的后序遍历序列 {
    /*
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
    （假设输入数组任意两个数字均不相同）
     */
    /*
    经典递归处理
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return judge(sequence, 0, sequence.length - 1);
    }

    public boolean judge(int[] sequence, int start, int root) {
        int len = root - start + 1;
        if (len <= 1) return true;
        int val = sequence[root];
        int i = start;
        while (i < root) {
            if (sequence[i] < val) {
                i++;
            } else {
                break;
            }
        }
        //check一下右子树是不是都大于val
        for (int j = i; j < root; j++) {
            if (sequence[j] < val)
                return false;
        }
        return judge(sequence, start, i - 1) && judge(sequence, i, root - 1);
    }
}
