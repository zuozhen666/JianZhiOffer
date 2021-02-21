package zuozhen;

public class 面试题49_丑数 {
    /*
    把只包含因子2、3和5的数称作丑数。求按从小到大顺序的第1500个丑数。
     */
    /*
    牛客：只包含质因子2、3、5的数称作丑数。6、8为丑数，14不是（包含质因子7）
    把1当做第一个丑数。
    求按从小到大的顺序的第N个丑数。
     */
    /*
    丑数为其他丑数乘以2、3、5而来，所以只计算丑数递推即可。
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 6) return index;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[index];//丑数排序数组
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) {
                i2++;
            }
            if (dp[i] == next3) {
                i3++;
            }
            if (dp[i] == next5) {
                i5++;
            }
        }
        return dp[index - 1];
    }
}
