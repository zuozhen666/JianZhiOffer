package zuozhen;

public class 面试题64_求1到n的累加和 {
    /*
    求1+2+3+...+n，要求不能使用乘除法、
    for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     */
    public int Sum_Solution(int n) {
        boolean x = n > 1 && (n += Sum_Solution(n-1)) == 1;
        return n;
    }
}
