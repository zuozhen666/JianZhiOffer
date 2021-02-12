package zuozhen;

public class 面试题16_数值的整数次方 {
    /*
    实现函数double Power(double base, int exponent)，求base的exponent次方。
    不得使用库函数，同时不需要考虑大数问题。
     */

    /*
    牛客AC代码
     */
    public double Power(double base, int exponent) {
        /*
        思路相当简单，考虑几种特殊情况后直接写即可
         */
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        //以下部分可以优化
//        double ans = 1;
//        for (int i = 0; i < Math.abs(exponent); i++) {
//            ans *= base;
//        }
        double ans = Calculate(base, Math.abs(exponent));
        return exponent > 0 ? ans : 1.0 / ans;
    }
    /*
    原理
    a^n = {
        a^(n/2)*a^(n/2) n为偶数
        a^((n-1)/2)*a^((n-1)/2)*a n为奇数
    }
     */
    public double Calculate(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = Calculate(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1)//判断奇偶（好方法）
            result *= base;
        return result;
    }
}
