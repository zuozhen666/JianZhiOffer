package zuozhen;

import java.util.Stack;

public class 面试题30_包含min函数的栈 {
    /*
    牛客AC代码
     */
/*    Stack stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    int pre_min;
    public void push(int node) {
        if(node < min) {
            pre_min = min;
            min = node;
        }
        stack.push(node);
    }

    public void pop() {
        int temp =  (int)stack.pop();
        if(temp == min) {
            min = pre_min;
        }
    }

    public int top() {
        return (int)stack.peek();
    }

    public int min() {
        return min;
    }*/
/*
使用辅助栈替换变量
辅助栈：每次主栈push操作时，辅助栈push最小值即可
 */
    Stack stack1 = new Stack<Integer>();
    Stack stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) stack2.push(node);
        else {
            stack2.push(Math.min(node, (int) stack2.peek()));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return (int) stack1.peek();
    }

    public int min() {
        return (int) stack2.peek();
    }
}
