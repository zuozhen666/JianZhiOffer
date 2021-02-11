package zuozhen;

public class 面试题10_斐波那契数列 {
    /*
    求斐波那契数列的第n项
     */
    /*
    牛客AC代码：
     */
    public int Fibonacci(int n) {
        /*
        递归
         */
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return Fibonacci(n - 1) + Fibonacci(n - 2);
        /*
        递推，递归做了很多重复的运算，占用空间
         */
        if (n == 0) return 0;
        if (n == 1) return 1;
        int ret = 0;
        int fib0 = 0;
        int fib1 = 1;
        for (int i = 2; i <= n; i++) {
            ret = fib0 + fib1;
            fib0 = fib1;
            fib1 = ret;
        }
        return ret;
    }
    /*
    题目延伸：
    青蛙跳台阶，一次可以跳1阶，一次也可以跳2阶；求跳n阶共有多少跳法。
    推一下之后发现是斐波那契数列的变式而已。
     */
}
