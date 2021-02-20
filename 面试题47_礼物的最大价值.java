package zuozhen;

import org.junit.Test;

public class 面试题47_礼物的最大价值 {
    /*
    在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
    你可以从棋盘左上角开始拿格子里的礼物，并每次向右或向下移动一格，直到到达棋盘的右下角。
    给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
     */
    /*
    dp：
    rows:m
    cols:n
    dp[i][j]:从左上角到此位置礼物的最大价值，dp[m-1][n-1]即为最终结果。
    dp[0][j] = chess[0][0]+...+chess[0][j] (0<=j<=n-1)
    dp[i][0] = chess[0][0]+...+chess[i][0] (0<=i<=m-1)

    dp[i][j] = {
        max(dp[i][j-1] + chess[i][j],dp[i-1][j] + chess[i][j]);
    }
     */
    public int getMost(int[][] values) {
        if (values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int m = values.length;
        int n = values[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = values[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + values[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + values[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + values[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        int[][] test = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        System.out.println(getMost(test));//53
    }
}
