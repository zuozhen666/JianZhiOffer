package zuozhen;

import org.junit.Test;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class 面试题29_顺时针打印矩阵 {
    /*
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
     */
    /*
    思路：
    以每圈为一个循环，循环起始节点为[0,0],[1,1]...[n,n]且满足n*2<cols,n*2<rows
    其余的对照规律打印即可，注意细节
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return null;
        ArrayList<Integer> ret = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        while (cols > 2 * start && rows > 2 * start) {
            Print(ret, rows, cols, start, matrix);
            start++;
        }
        return ret;
    }

    /*
    打印每一圈
     */
    public void Print(ArrayList<Integer> list, int rows, int cols, int start, int[][] matrix) {
        //打印从左到右的一行
        //System.out.println("left to right");
        for (int i = 0; i < cols - 2 * start; i++) {
            //System.out.println(matrix[start][start + i]);
            list.add(matrix[start][start + i]);
        }
        //打印从上到下的一行
        //System.out.println("up to down");
        for (int i = 0; i < rows - 2 * start - 2; i++) {
            //System.out.println(matrix[start + i + 1][cols - start - 1]);
            list.add(matrix[start + i + 1][cols - start - 1]);
        }
        //打印从右到左的一行
        if (rows - 2 * start >= 2) {
            //System.out.println("right to left");
            for (int i = 0; i < cols - 2 * start; i++) {
                //System.out.println(matrix[rows - start - 1][cols - start - 1 - i]);
                list.add(matrix[rows - start - 1][cols - start - 1 - i]);
            }
        }
        //打印从下到上的一行
        if (cols - 2 * start >= 2) {
            //System.out.println("down to up");
            for (int i = 0; i < rows - 2 * start - 2; i++) {
                //System.out.println(matrix[rows - start - 1 - i][start]);
                list.add(matrix[rows - start - 2 - i][start]);
            }
        }
    }

    @Test
    public void test() {
//        int[][] matrix = {
//                {1, 2, 3, 4, 5},
//                {16, 17, 18, 19, 6},
//                {15, 24, 25, 20, 7},
//                {14, 23, 22, 21, 8},
//                {13, 12, 11, 10, 9}
//        };
        int[][] matrix = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
