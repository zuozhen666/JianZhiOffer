package zuozhen;

public class 面试题42_连续子数组的最大和 {
    /*
    输入一个整型数组，数组里有正数也有负数。数组中的一个或多个连续整数组成一个子数组。
    求所有子数组的和的最大值。（要求O(n)）
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        /*
        dp:
        设A[i]：以序号i为尾的子数组的最大和。
        所以易知：
        A[i+1]={
            A[i]+array[i+1] (if A[i] > 0)
            array[i+1] (if A[i] <= 0)
        }
         */
        if (array.length == 0) return 0;
        int[] A = new int[array.length];
        A[0] = array[0];
        int ret = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > 0) {
                A[i] = A[i - 1] + array[i];
            } else {
                A[i] = array[i];
            }
            ret = Math.max(ret, A[i]);
        }
        return ret;
    }
}
