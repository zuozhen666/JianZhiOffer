package zuozhen;

import java.util.PriorityQueue;

public class 面试题41_数据流中的中位数 {
    /*
    将数据流放置在容器中，假设已排序，用两个指针p1，p2指向中位数；
    易知：在左半部分：p1指向最大值(大顶堆)
    右半部分：p2指向最小值(小顶堆)
    所以：插入O(lgn)
    查找中位数O(1)
     */
    private PriorityQueue<Integer> left = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N = 0;

    public void Insert(Integer num) {
        /*
        保证两个堆的平衡
        1.数目平衡
        2.小顶堆中的元素大于大顶堆
         */
        if ((N & 0x1) == 0) {
            left.add(num);
            right.add(left.poll());//相当于N为偶数时，将数值插入right
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if ((N & 0x1) == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) right.peek();
        }
    }
}
