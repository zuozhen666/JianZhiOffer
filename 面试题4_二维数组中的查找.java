package zuozhen;

public class 面试题4_二维数组中的查找 {
    /*
    在一个二维数组中，每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序；
    输入一个该二维数组和一个整数，判断整数是否在二维数组中。
     */
    /*
    思路：
    按照该二维数组的规律，从右上角或者左下角开始查找即可；
     */
    /*
    牛客AC代码：
     */
    public boolean Find(int target, int[][] array) {
        int cols = array[0].length;
        int rows = array.length;
        if (cols == 0 || rows == 0) return false;
        int col = cols - 1;
        int row = 0;
        while (row < rows && col >= 0) {
            int tmp = array[row][col];
            if (tmp == target) {
                return true;
            } else if (tmp > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
