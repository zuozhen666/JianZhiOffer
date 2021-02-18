package zuozhen;

import java.util.HashMap;
import java.util.Map;

public class 面试题39_数组中出现次数超过一半的数字 {
    /*
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        /*
        解法1：基于Partition函数()
        分析知：排序后位于数组中间的数字一定就是target，即中位数；
        即长度为n的数组里第n/2大的数字：
        问题转化为：数字中任意第K大的数字；
        利用快排思想：随机选取数字，大于它的排在右边，小于它的排在左边，如果下标为
        n/2，那么即为所求；如果>n/2，那么去左边查找；否则去右边查找。
        */
        /*
        解法2：
        分析：target的出现次数比其他所有数字出现次数的和还要多。
        遍历数组时维护两个变量：num（数组中的某一数字），cut（num出现次数）
        当cut=0时，num换为下一数字，并重置cut=1；
        当遍历的下一数字与num相同时，cut++，不同时，cut--；
        target即为最后一次把次数重置为1时的数字。（？？？）
         */
        /*
        Boyer-Moore Algorithm多数投票算法
        */
        if (array.length == 0) return 0;
        int num = array[0];
        int cut = 0;
        for (int i = 0; i < array.length; i++) {
            if (cut == 0) {
                num = array[i];
                cut = 1;
            }
            if (num == array[i]) cut++;
            else cut--;
        }
        //检查一下
        cut = 0;
        for (int val : array) {
            if (val == num)
                cut++;
        }
        return cut > array.length / 2 ? num : 0;
    }
}
