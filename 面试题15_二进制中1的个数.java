package zuozhen;

public class 面试题15_二进制中1的个数 {
    /*
    输入一个整数，输出该数二进制表示中1的个数。
     */
    /*
    牛客AC代码：
     */
    public int NumberOf1(int n) {
        /*
        由于有负数存在，所以不能用n右移来求解
        */
//        int num = 1;
//        int count = 0;
//        while (num != 0) {
//            if ((n & num) != 0) count++;
//            num <<= 1;
//        }
//        return count;
        /*
        nb算法
        观察得(n-1)&n
        例：1100&1011=1000
        1000&0111=0000
        分析知：把一个整数减去1，在和原整数做&运算，会把该整数最右边的1变成0，所以有多少个1就有多少次&操作。
        两个1，两次&操作
        */
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }
}
