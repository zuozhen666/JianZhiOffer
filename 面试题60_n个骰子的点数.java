package zuozhen;

import java.util.*;

public class 面试题60_n个骰子的点数 {
    /*
    把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
    输入n，打印出s的所有可能的值出现的概率。
     */
    /*
    LintCode AC代码
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        /*
        dp：
        dp[i][j]i个骰子产生点数j的次数
        dp[i][j]=dp[i-1][j-1]+...dp[i-1][j-6]
         */
        if (n == 0) return null;
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= 0)
                        dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        //n个骰子，点数：n~6n
        double base = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList();
        for (int i = n; i <= 6 * n; i++) {
            ret.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i] / base));
        }
        return ret;
    }
}
