package zuozhen;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.logging.Level;

public class 面试题59_队列的最大值 {
    /*
    题目一：滑动窗口的最大值
    给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
    例如：{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
    结果{4,4,6,6,6,5}。
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        /*
        使用队列，并保证滑动窗口最大值始终在队列头部
         */
        /*
        优先级队列：大顶堆
         */
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1) return ret;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            queue.add(num[i]);
        }
        ret.add(queue.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            queue.remove(num[i]);
            queue.add(num[j]);
            ret.add(queue.peek());
        }
        return ret;
    }
    /*
    题目二：队列的最大值
    请定义一个队列并实现函数max得到队列里的最大值。
    要求函数的时间复杂度均为O(1)
     */
}
