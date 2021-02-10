package zuozhen;

import java.util.Arrays;

public class 面试题3_数组中重复的数字 {
    /*
    在一个长度为n的数组里的所有数字都在0~n-1范围内；
    请找出数组中任意一个重复的数字。
     */
    /*
    思路：
    1.排序后遍历，时间复杂度O(nlgn)
    2.哈希，空间复杂度O(n)
    3.根据取值规律，如果没有重复数字，那么0~n-1可以填满长度为n的数组，且序号与取值相同
    时间O(n),空间O(n)
    按序遍历，如果当前位置数值不等于当前序号，那么直接交换
     */
    /*
    牛客AC代码
     */
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        /*
        排序后遍历（不适用于找出第一个重复的数字，适用于找出重复的最小数字）
         */
//        if (length == 0) {
//            return false;
//        }
//        Arrays.sort(numbers);
//        for (int i = 0; i < length - 1; i++) {
//            if (numbers[i] == numbers[i + 1]) {
//                duplication[0] = numbers[i];
//                return true;
//            }
//        }
//        return false;
        /*
        哈希
        */
//        if (length == 0) {
//            return false;
//        }
//        boolean[] hash = new boolean[length];
//        for (int i = 0; i < length; i++) {
//            if (hash[numbers[i]]) {
//                duplication[0] = numbers[i];
//                return true;
//            }
//            hash[numbers[i]] = true;
//        }
//        return false;
        /*
        按规律排序
        */
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int value = numbers[i];
            if (value == i) continue;
            if (numbers[value] == value) {
                duplication[0] = value;
                return true;
            } else {
                numbers[i] = numbers[value];
                numbers[value] = value;
            }
        }
        return false;
    }

    /*
    题目延伸：
    不修改数组找出重复的数字，数组长度n+1，数字范围1~n
    //方法一：辅助数组：空间复杂度O(n)
    //方法二：二分，统计1~n中1~n的个数，如果为>=n+1，那么重复数字在其中，然后。。。
     */

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        System.out.println(duplicate(numbers, numbers.length, duplication));
    }
}
