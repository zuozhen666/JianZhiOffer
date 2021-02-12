package zuozhen;

public class 面试题13_机器人的运动范围 {
    /*
    地上有一个m行n列的方格，一个机器人从坐标(0,0)的格子开始移动，他每次可以向左、右、上、下移动一格，
    但不能进入行坐标和列坐标的数位之和大于k的格子。请问该机器人能到达多少个格子？
     */
    /*
    牛客AC代码
     */
    /*
    还是经典的回溯法
     */
    int rows;
    int cols;
    int threshold;
    boolean[][] marked;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        marked = new boolean[rows][cols];
        return dfs(0, 0);
    }

    public int dfs(int r, int c) {
        int count = 0;
        if (check(r, c)) {
            marked[r][c] = true;
            count = 1 + dfs(r + 1, c) + dfs(r - 1, c)
                    + dfs(r, c + 1) + dfs(r, c - 1);
        }
        return count;
    }

    public boolean check(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || getDigitSum(r) + getDigitSum(c) > threshold || marked[r][c]) {
            return false;
        }
        return true;
    }

    public int getDigitSum(int num) {
        int ret = 0;
        while (num != 0) {
            ret += num % 10;
            num /= 10;
        }
        return ret;
    }
}
