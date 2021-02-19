package zuozhen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 面试题40_最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        /*
        思路一：利用Partition函数，找到排序下标为k-1的数字，这时数组前k个数字即为所求。
        O(n)
         */
//        ArrayList ret = new ArrayList<Integer>();
//        if (input.length == 0 || k == 0 || input.length < k) return ret;
//        int start = 0;
//        int end = input.length - 1;
//        int index = Partition(input, start, end);
//        while (index != k - 1) {
//            if (index > k - 1) {
//                end = index - 1;
//                index = Partition(input, start, end);
//            } else {
//                start = index + 1;
//                index = Partition(input, start, end);
//            }
//        }
//        for (int i = 0; i <= k - 1; i++) {
//            ret.add(input[i]);
//        }
//        return ret;
        /*
        思路二：利用堆 O(nlgk)
         */
        if (input.length == 0 || k == 0 || input.length < k) return new ArrayList<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int num: input){
            maxHeap.add(num);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

    public int Partition(int[] array, int lo, int hi) {
        int key = array[lo];//以第一个值为基准值
        while (lo < hi) {
            while (array[hi] > key && hi > lo) {
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    @Test
    public void test() {
        int[] arr = {3, 4, 1, 2, 5};
        System.out.println(Partition(arr, 0, arr.length - 1));
    }
}
