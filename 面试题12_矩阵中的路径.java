package zuozhen;

import javax.swing.*;
import java.util.logging.Level;

public class 面试题12_矩阵中的路径 {
    /*
    请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
    路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
    如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     */
    /*
    牛客AC代码
     */
    private final static int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int rows;
    int cols;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        boolean[] marked = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(str, marked, matrix, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[] str, boolean[] marked, char[] matrix, int i, int j, int pathSize) {
        /*
        经典回溯
         */
        if (pathSize == str.length) return true;
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols
                || matrix[index] != str[pathSize] || marked[index]) {
            return false;
        }
        marked[index] = true;
        for (int[] n : next) {
            if (dfs(str, marked, matrix, i + n[0], j + n[1], pathSize + 1))
                return true;
        }
        marked[index] = false;
        return false;
    }
}
