package zuozhen;

public class 面试题14_剪绳子 {
    /*
    一根长度为n的绳子，把绳子剪成m段（m，n均为整数且大于1）
    问m段绳子的连乘积最大是多少？
     */
    /*
    思路：
    dp：
    根据乘法特性，不妨设f(n)为长度为n的绳子对应的结果；
    易知状态转移方程：f(n) = max {f(k)f(n-k)} (1<=k<=n/2)
    所以递推即可；
     */
    /*
    牛客AC代码：
     */
    public int cutRope(int target) {
        /*
        dp:
        状态转移方程
        f(i)=max{f(i-k)*f(k)}(1<=k<=i/2) i>=2
        题意：2<=n<=60
        即使用一个数组作为记录，递推的求解；
        (其中2，3要做特殊处理)
        */
//        if (target == 2) return 1;
//        if (target == 3) return 2;
//        int[] record = new int[61];
//        record[1] = 1;
//        record[2] = 2;
//        record[3] = 3;
//        for (int num = 4; num <= target; num++) {
//            for (int k = 1; k <= num / 2; k++) {
//                record[num] = Math.max(record[num], record[k] * record[num - k]);
//            }
//        }
//        return record[target];
        /*
        贪心：（妙）
        思想：当n>=5时，尽可能多的剪长度为3的绳子；当剩下的绳子为4时，剪成2*2
        */
        if (target == 2) return 1;
        if (target == 3) return 2;
        if (target == 4) return 4;
        int threeNums = target / 3;
        if (target % 3 == 1) {
            threeNums--;
            return (int) Math.pow(3, threeNums) * 4;
        }
        return (int) Math.pow(3, threeNums) * (target % 3 != 0 ? target % 3 : 1);

    }
}
