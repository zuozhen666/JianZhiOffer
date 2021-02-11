package zuozhen;

import java.util.Stack;

public class 面试题9_用两个栈实现队列 {
    /*
    用两个栈实现一个队列。
    实现两个函数appendTail,deleteHead。
     */
    /*
    思路：
    两个栈stack1,stack2
    入队：直接push进statck1；
    出队：如果stack2不为空，那么stack2进行pop即可；
    如果为空，{
        如果stack1为空，。。；
        如果stack2非空，将stack1进行pop，然后push进stack2，直至stack1为空；
        stack2进行pop即可。
    }
     */
    /*
    牛客AC代码：
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) return stack2.pop();
        else {
            if (stack1.isEmpty()) return 0;
            while (!stack1.isEmpty()) {
                int temp = stack1.pop();
                stack2.push(temp);
            }
            return stack2.pop();
        }
    }
    /*
    题目延伸：用两个队列实现一个栈
    queue1，queue2；
    push：哪个队列不为空，就入队哪个队列，如果均为空，whatever；
    pop：将非空队列依次出队到另一个队列，当原队列size为1时，最后出队的即为所求。
     */
}
