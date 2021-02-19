package zuozhen;

public class 面试题43_1到n整数中1出现的次数 {
    /*
    输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数。
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        /*
        一位一位的统计
        第i位（从右到左）
        当前位：cur
        当前位前面的数：high
        当前位后面的数：low
        当前位的基数：10^i
        //没有算重复这一说，因为例如：11即1出现两次
        */
        if (n == 0) return 0;
        if (n < 10) return 1;
        int count = 0;
        int cur = n % 10;
        int high = n / 10;
        int low = 0;
        int base = 1;
        do {
            if (cur == 0) {
                count += high * base;
            } else if (cur == 1) {
                if (base == 1) count += high * base + 1;
                else count += high * base + low + 1;
            } else {
                if (base == 1) count += high * base + 1;
                else count += high * base + base;
            }
            base = 10 * base;
            cur = (n / base) % 10;
            low = n - (n / base) * base;
            high = n / (base * 10);
        } while (high != 0 || cur != 0);
        return count;
    }
}
