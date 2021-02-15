package zuozhen;

import java.util.Stack;

public class 面试题31_栈的压入弹出序列 {
    /*
    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
    （假设入栈的数字均不相等）
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        /*
        感觉这应该是最直观的思路了。
        （剑指上的。。。。）
         */
        Stack stack = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && (int) stack.peek() == popA[j]) {
                j++;
                stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
