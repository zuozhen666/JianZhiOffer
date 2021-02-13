package zuozhen;

public class 面试题17_打印从1到最大的n位数 {
    /*
    输入数字n，按顺序打印出从1到最大的n位十进制数。
     */
    public static void main(String[] args) {
        //Way1_Print1toN(2);
        Way2_Print1ToN(2);
    }

    /*
    思路1：在字符串上模拟数字加法的解法
    */
    public static void Way1_Print1toN(int n) {
        if (n < 0) return;
        char[] str = new char[n];
        for (int i = 0; i < n; i++) {
            str[i] = '0';
        }
        while (!Increment(str)) {
            Print(str);
        }
    }

    /**
     * 加一操作并判断是否到最后
     *
     * @param str
     * @return
     */
    public static boolean Increment(char[] str) {
        boolean isOverFlow = false;
        int nTakeOver = 0;//进位
        int nLength = str.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = str[i] - '0' + nTakeOver;
            if (i == nLength - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0)
                    isOverFlow = true;
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    str[i] = (char) ('0' + nSum);
                }
            } else {
                str[i] = (char) ('0' + nSum);
                break;//这个break相当灵性
            }
        }
        return isOverFlow;
    }

    /**
     * 打印
     *
     * @param str
     */
    public static void Print(char[] str) {
        boolean isBeginning0 = true;
        int nLength = str.length;
        for (int i = 0; i < nLength; i++) {
            if (isBeginning0 && str[i] != '0') {
                //从第一个非零位置开始打印
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.printf("%c", str[i]);
            }
        }
        System.out.println();
    }

    /*
    思路2：将问题转换成数字排列的解法，递归求解。
    n位十进制数其实就是n个从0到9的全排列
     */
    public static void Way2_Print1ToN(int n) {
        if (n <= 0)
            return;
        char[] str = new char[n];
        for (int i = 0; i < 10; i++) {
            str[0] = (char) (i + '0');
            Print(str, n, 0);
        }
    }

    public static void Print(char[] str, int length, int index) {
        if (index == length - 1) {
            Print(str);
            return;
        }
        for (int i = 0; i < 10; i++) {
            str[index + 1] = (char) (i + '0');
            Print(str, length, index + 1);
        }
    }
}
