package zuozhen;

import java.util.Arrays;

public class 面试题21_调整数组顺序使奇数位于偶数前面 {
    /*
    输入一个整数数组，实现一个函数来调整数组中数字的顺序，
    使得所有奇数位于数组的前半部分，所有偶数位于后半部分。
     */
    public static void adjust(int[] arr) {
        /*
        双指针
         */
        if (arr.length == 0) return;
        int pre = 0;
        int post = arr.length - 1;
        while (pre < post) {
            while (pre < post && (arr[pre] & 1) != 0) {
                pre++;
            }
            while (pre < post && (arr[post] & 1) == 0) {
                post--;
            }
            if (pre < post) {
                int temp = arr[pre];
                arr[pre] = arr[post];
                arr[post] = temp;
            }
        }
    }

    /*
    牛客AC代码：
    要求：原奇数与奇数，偶数与偶数相对位置不变
     */
    public void reOrderArray(int[] array) {
        /*
        冒泡：保证相对顺序不变
        */
        int len = array.length;
        if (len == 0) return;
        while (len != 0) {
            boolean isChange = false;
            for (int i = 0; i < len - 1; i++) {
                if ((array[i] & 1) == 0 && (array[i + 1] & 1) == 1) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isChange = true;
                }
            }
            if (isChange == false) return;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        adjust(arr);
        System.out.println(Arrays.toString(arr));
    }
}
